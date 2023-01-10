package com.example.springbootstarter.sample;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleController {

    @Autowired
    SampleService sampleService;

    @GetMapping("/sample")
    ResponseEntity<SampleEntity> sample() {
        return ResponseEntity.ok(this.sampleService.sampleService());
    }

}
