package com.iyboklee.graphql.core.service;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.iyboklee.graphql.core.model.Member;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

@SpringBootTest
@RunWith(SpringRunner.class)
public class MemberServiceTest {

    @Autowired private PartService partService;
    @Autowired private MemberService memberService;

    @Test
    public void 멤버를_조회한다() {
        List<Member> members = memberService.findAll();

        assertThat(members, is(notNullValue()));
        assertThat(members.size(), is(4));

        members = memberService.findAllByPart(partService.findByName("Big data"));

        assertThat(members, is(notNullValue()));
        assertThat(members.size(), is(4));

        assertThat(members, is(notNullValue()));
        assertThat(members.size(), is(4));

        Member member = memberService.findByName("bk.lee");

        assertThat(member, is(notNullValue()));
        assertThat(member.getName(), is("bk.lee"));
    }

}