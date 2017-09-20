package com.woowahan.blog;

import com.woowahan.blog.service.MemberService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {BlogConfiguration.class})
public class BlogApplicationTest {

    @Autowired
    private MemberService memberService;

    @Test
    public void context가_정상적으로_초기화_되어야_한다() {
        Assert.assertNotNull(memberService);
    }

}