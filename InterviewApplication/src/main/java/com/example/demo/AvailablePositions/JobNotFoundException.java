package com.example.demo.AvailablePositions;

public class JobNotFoundException extends  RuntimeException {
    JobNotFoundException(Long id) {
        super("Could not find job " + id);
    }
}
