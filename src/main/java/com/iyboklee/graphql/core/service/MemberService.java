package com.iyboklee.graphql.core.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.iyboklee.graphql.core.model.Member;
import com.iyboklee.graphql.core.model.Part;
import com.iyboklee.graphql.core.repository.MemberRepository;

@Service
public class MemberService {

    @Autowired private MemberRepository memberRepository;

    @Transactional(readOnly = true)
    public Member findOne(long memberId) {
        return memberRepository.findById(memberId).orElseThrow(() -> new IllegalArgumentException("Could not found member by [memberId=" + memberId + "]"));
    }

    @Transactional(readOnly = true)
    public Member findByName(String name) {
        return memberRepository.findByName(name);
    }

    @Transactional(readOnly = true)
    public List<Member> findAllByPart(Part part) {
        return memberRepository.findByPart(part);
    }


    @Transactional(readOnly = true)
    public List<Member> findAll() {
        return memberRepository.findAll();
    }

}
