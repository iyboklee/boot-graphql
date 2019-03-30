package com.iyboklee.graphql.core.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.iyboklee.graphql.core.model.Member;
import com.iyboklee.graphql.core.model.Part;

public interface MemberRepository extends JpaRepository<Member, Long> {

    Member findByName(String name);

    List<Member> findByPart(Part part);

}
