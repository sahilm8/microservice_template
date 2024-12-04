package com.sahil.template.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sahil.template.model.Model;

@Repository
public interface ModelRepository extends JpaRepository<Model, Long> {
    public Optional<Model> findByName(String name);
}