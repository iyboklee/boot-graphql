package com.iyboklee.graphql.configuration;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.hibernate5.Hibernate5Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.iyboklee.graphql.core.resolver.QueryResolver;
import com.iyboklee.graphql.core.service.MemberService;
import com.iyboklee.graphql.core.service.PartService;

@Configuration
@EnableJpaRepositories(basePackages = "com.iyboklee.graphql.core.repository")
@EntityScan(basePackages = "com.iyboklee.graphql.core.model")
@EnableTransactionManagement
public class AppConfig {

    @Bean
    public QueryResolver queryResolver(PartService partService, MemberService memberService) {
        return new QueryResolver(partService, memberService);
    }

    @Bean
    public Jackson2ObjectMapperBuilder configureObjectMapper() {
        // Hibernate module
        Hibernate5Module hbm = new Hibernate5Module();
        //hbm.enable(Hibernate4Module.Feature.FORCE_LAZY_LOADING);
        hbm.disable(Hibernate5Module.Feature.USE_TRANSIENT_ANNOTATION);
        // Java time module
        JavaTimeModule jtm = new JavaTimeModule();
        jtm.addDeserializer(LocalDateTime.class, new LocalDateTimeDeserializer(DateTimeFormatter.ISO_DATE_TIME));

        Jackson2ObjectMapperBuilder builder = new Jackson2ObjectMapperBuilder() {
            @Override
            public void configure(ObjectMapper objectMapper) {
                super.configure(objectMapper);
                objectMapper.setVisibility(PropertyAccessor.GETTER, JsonAutoDetect.Visibility.NONE);
                objectMapper.setVisibility(PropertyAccessor.IS_GETTER, JsonAutoDetect.Visibility.NONE);
                objectMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
            }
        };
        builder.serializationInclusion(JsonInclude.Include.NON_NULL);
        builder.featuresToDisable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        builder.modulesToInstall(hbm, jtm);
        return builder;
    }

}