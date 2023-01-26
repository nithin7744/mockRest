package com.test.mockRest.controller;

import com.test.mockRest.model.ResponseData;
import com.test.mockRest.service.MockService;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MockRestController {

    @Autowired
    MockService service;

    @GetMapping("/login/{loginId}/{password}")
    public ResponseData processRequest(@PathVariable @NonNull String loginId, @PathVariable @NonNull String password){
        return service.validateData(loginId, password);
    }
}
