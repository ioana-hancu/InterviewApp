package com.example.demo.AvailablePositions;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.IanaLinkRelations;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
public class JobController {
    private final JobRepository repository;
    private final JobModelAssembler assembler;

    JobController(JobRepository repository, JobModelAssembler assembler) {
        this.repository = repository;
        this.assembler  = assembler;
    }

    @GetMapping("/jobs")
    CollectionModel<EntityModel<Job>> all() {
        List<EntityModel<Job>> jobs = repository.findAll().stream()
                .map(assembler::toModel)
                .collect(Collectors.toList());

        return CollectionModel.of(jobs,
                linkTo(methodOn(JobController.class).all()).withSelfRel());
    }

    @PostMapping("/jobs")
    ResponseEntity<?> newTest(@RequestBody Job newJob) {
        EntityModel<Job> entityModel = assembler.toModel(repository.save(newJob));
        return ResponseEntity.created(entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri())
                .body(entityModel);
    }

    @GetMapping("/jobs/{id}")
    EntityModel<Job> one(@PathVariable Long id) {

        Job job = repository.findById(id)
                .orElseThrow(() -> new JobNotFoundException(id));
        return assembler.toModel(job);
    }

    @PutMapping("/jobs/{id}")
    ResponseEntity<?> replaceTest(@RequestBody Job newJob, @PathVariable Long id) {

        Job updatedJob = repository.findById(id)
                .map(job -> {
                    job.setName(newJob.getName());
                    job.setDomain(newJob.getDomain());
                    job.setNumberOfWantedPeople(newJob.getNumberOfWantedPeople());
                    job.setDescription(newJob.getDescription());
                    job.setLevel(newJob.getLevel());
                    return repository.save(job);
                })
                .orElseGet(() -> {
                    newJob.setId(id);
                    return repository.save(newJob);
                });

        EntityModel<Job> entityModel = assembler.toModel(updatedJob);

        return ResponseEntity.created(entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri())
                .body(entityModel);
    }

    @DeleteMapping("/jobs/{id}")
    ResponseEntity<?> deleteJob(@PathVariable Long id) {
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
