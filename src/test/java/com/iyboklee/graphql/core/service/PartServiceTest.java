package com.iyboklee.graphql.core.service;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.iyboklee.graphql.core.model.Part;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

@SpringBootTest
@RunWith(SpringRunner.class)
public class PartServiceTest {

    @Autowired private PartService partService;

    @Test
    public void 파트를_조회한다() {
        List<Part> parts = partService.findAll();

        assertThat(parts, is(notNullValue()));
        assertThat(parts.size(), is(2));

        Part part = partService.findByName("Big data");

        assertThat(part, is(notNullValue()));
        assertThat(part.getName(), is("Big data"));
    }

}