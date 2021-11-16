package com.example.demo.InterviewTest;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.IanaLinkRelations;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@RestController
public class InterviewTestController {
    private final InterviewTestRepository repository;
    private final InterviewTestModelAssembler assembler;

    InterviewTestController(InterviewTestRepository repository, InterviewTestModelAssembler assembler) {
        this.repository = repository;
        this.assembler  = assembler;
    }

    @GetMapping("/tests")
    CollectionModel<EntityModel<InterviewTest>> all() {
        List<EntityModel<InterviewTest>> tests = repository.findAll().stream()
                .map(assembler::toModel)
                .collect(Collectors.toList());

        return CollectionModel.of(tests,
                linkTo(methodOn(InterviewTestController.class).all()).withSelfRel());
    }

    @PostMapping("/tests")
    ResponseEntity<?> newTest(@RequestBody InterviewTest newTest) {
        EntityModel<InterviewTest> entityModel = assembler.toModel(repository.save(newTest));
        return ResponseEntity.created(entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri())
                .body(entityModel);
    }

    @GetMapping("/tests/{id}")
    EntityModel<InterviewTest> one(@PathVariable Long id) {

        InterviewTest test = repository.findById(id)
                .orElseThrow(() -> new TestNotFoundException(id));
        return assembler.toModel(test);
    }

    @PutMapping("/tests/{id}")
    ResponseEntity<?> replaceTest(@RequestBody InterviewTest newTest, @PathVariable Long id) {

        InterviewTest updatedTest = repository.findById(id)
                .map(test -> {
                    test.setName(newTest.getName());
                    test.setDomain(newTest.getDomain());
                    test.setDifficulty(newTest.getDifficulty());
                    test.setQuestionSet(newTest.getQuestionSet());
                    return repository.save(test);
                })
                .orElseGet(() -> {
                    newTest.setId(id);
                    return repository.save(newTest);
                });

        EntityModel<InterviewTest> entityModel = assembler.toModel(updatedTest);

        return ResponseEntity.created(entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri())
                .body(entityModel);
    }

    @DeleteMapping("/tests/{id}")
    ResponseEntity<?> deleteTest(@PathVariable Long id) {
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
