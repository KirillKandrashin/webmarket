package com.example.demo.Repository;

import com.example.demo.Entity.Producer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProducerRepository extends JpaRepository<Producer,Long> {
}
