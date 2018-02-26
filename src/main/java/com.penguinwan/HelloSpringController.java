package com.penguinwan;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/rest", consumes = "application/json", produces = "application/json")
public class HelloSpringController {

    @GetMapping
    public String get() {
        return "{ \"message\" : \"hi\" }";
    }

    @PostMapping(path = "/{name}")
    public String post(@PathVariable String name) {
        return String.format("{ \"message\" : \"hi %s\" }", name);
    }

}