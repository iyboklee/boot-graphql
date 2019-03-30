package com.iyboklee.graphql.controller.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iyboklee.graphql.core.model.Member;
import com.iyboklee.graphql.core.service.MemberService;
import com.iyboklee.graphql.core.service.PartService;

@RestController
@RequestMapping("api/members")
public class MemberRestController {

    @Autowired private PartService partService;
    @Autowired private MemberService memberService;

    @GetMapping
    public List<Member> findAll() {
        return memberService.findAll();
    }

    @GetMapping(path = "parts/{partId}")
    public List<Member> findAllByPart(@PathVariable Long partId) {
        return memberService.findAllByPart(partService.findOne(partId));
    }

    @GetMapping(path = "{memberId}")
    public Member findOne(@PathVariable Long memberId) {
        return memberService.findOne(memberId);
    }

}
