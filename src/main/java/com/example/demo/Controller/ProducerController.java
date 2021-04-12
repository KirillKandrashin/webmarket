package com.example.demo.Controller;

import com.example.demo.Entity.Producer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.demo.Service.ProducerService;

import java.util.List;

public class ProducerController {
    private ProducerService producerService;

    @Autowired
    public ProducerController(ProducerService producerService){
        this.producerService = producerService;
    }

    @PostMapping(value = "/model")
    public ResponseEntity<?> create(@RequestBody Producer producer){
        producerService.create(producer);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(value = "/producer")
    public ResponseEntity<List<Producer>> findAll(){
        final List<Producer> producerList = producerService.findAll();

        return producerList != null && !producerList.isEmpty()
                ? new ResponseEntity<>(producerList, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/producer/{id}")
    public ResponseEntity<Producer> find(@PathVariable(name="id") Long id){
        final Producer producer = producerService.find(id);

        return producer != null
                ? new ResponseEntity<>(producer, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping(value = "/producer")
    public ResponseEntity<?> deleteById(@PathVariable(name="id") Long id){
        producerService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}