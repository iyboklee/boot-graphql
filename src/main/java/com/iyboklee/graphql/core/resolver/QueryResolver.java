package com.iyboklee.graphql.core.resolver;

import java.util.List;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.iyboklee.graphql.core.model.Member;
import com.iyboklee.graphql.core.model.Part;
import com.iyboklee.graphql.core.service.MemberService;
import com.iyboklee.graphql.core.service.PartService;

public class QueryResolver implements GraphQLQueryResolver {

    private PartService partService;
    private MemberService memberService;

    public QueryResolver(PartService partService, MemberService memberService) {
        this.partService = partService;
        this.memberService = memberService;
    }

    public List<Part> findAllParts() {
        return partService.findAll();
    }

    public Part findPart(Long partId) {
        return partService.findOne(partId);
    }

    public List<Member> findAllMembers() {
        return memberService.findAll();
    }

    public Member findMember(Long memberId) {
        return memberService.findOne(memberId);
    }

}
