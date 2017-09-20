package com.woowahan.blog;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@ComponentScan(basePackages = {"com.woowahan.blog"})
@EnableJpaRepositories(basePackages = {"com.woowahan.blog.repository"})
@EntityScan(basePackages = {"com.woowahan.blog.entity"})
@Configuration
public class BlogConfiguration {


}
