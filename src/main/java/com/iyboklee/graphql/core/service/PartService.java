package com.iyboklee.graphql.core.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.iyboklee.graphql.core.model.Part;
import com.iyboklee.graphql.core.repository.PartRepository;

@Service
public class PartService {

    @Autowired private PartRepository partRepository;

    @Transactional(readOnly = true)
    public Part findOne(long partId) {
        return partRepository.findById(partId).orElseThrow(() -> new IllegalArgumentException("Could not found part by [partId=" + partId + "]"));
    }

    @Transactional(readOnly = true)
    public Part findByName(String name) {
        return partRepository.findByName(name);
    }

    @Transactional(readOnly = true)
    public List<Part> findAll() {
        return partRepository.findAll();
    }

}
