package com.example.demo.Repository;

import com.example.demo.Entity.Model;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ModelRepository extends JpaRepository<Model,Long> {
}