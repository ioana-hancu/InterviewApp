package com.example.demo.InterviewTest;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import com.example.demo.InterviewTest.InterviewTest;
import com.example.demo.InterviewTest.InterviewTestController;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

@Component
public class InterviewTestModelAssembler implements RepresentationModelAssembler<InterviewTest, EntityModel<InterviewTest>> {

    @Override
    public EntityModel<InterviewTest> toModel(InterviewTest test) {

        return EntityModel.of(test,
                linkTo(methodOn(InterviewTestController.class).one(test.getId())).withSelfRel(),
                linkTo(methodOn(InterviewTestController.class).all()).withRel("tests"));
    }
}
