package com.iyboklee.graphql.controller.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iyboklee.graphql.core.model.Part;
import com.iyboklee.graphql.core.service.PartService;

@RestController
@RequestMapping("api/parts")
public class PartRestController {

    @Autowired private PartService partService;

    @GetMapping
    public List<Part> findAll() {
        return partService.findAll();
    }

    @GetMapping(path = "{partId}")
    public Part findOne(@PathVariable Long partId) {
        return partService.findOne(partId);
    }

}
