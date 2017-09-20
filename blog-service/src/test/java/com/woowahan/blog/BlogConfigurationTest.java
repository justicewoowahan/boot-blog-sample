package com.woowahan.blog;

import com.woowahan.blog.service.MemberService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.Assert.*;

@SpringBootTest
public class BlogConfigurationTest {

    @Autowired
    private MemberService memberService;

    @Test
    public void 컨텍스트가_정상적으로_만들어져야_한다() {
//        Assert.assertNotNull(memberService);
    }

}