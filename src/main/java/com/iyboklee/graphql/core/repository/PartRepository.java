package com.iyboklee.graphql.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.iyboklee.graphql.core.model.Part;

public interface PartRepository extends JpaRepository<Part, Long> {

    Part findByName(String name);

}
