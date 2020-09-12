package com.lookiero.quehayparacomer.infrastructure.delivery.springboot.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class healthcheckController {

@RequestMapping(value = "health",method = RequestMethod.GET)
    public ResponseEntity healthcheck(){
    return new ResponseEntity(HttpStatus.OK);
}
}
