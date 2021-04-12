package com.example.demo.Service;

import com.example.demo.Entity.Producer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.Repository.ProducerRepository;

import java.util.List;

@Service
public class ProducerService {
    @Autowired
    private ProducerRepository producerRepository;

    public void create(Producer producer){
        producerRepository.save(producer);
    }

    public List<Producer> findAll(){
        return producerRepository.findAll();
    }

    public Producer find(Long id){
        return producerRepository.getOne(id);
    }

    public void delete(Long id){ producerRepository.deleteById(id); }
}