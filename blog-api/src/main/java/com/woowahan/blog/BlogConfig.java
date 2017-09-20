package com.woowahan.blog;

import nz.net.ultraq.thymeleaf.LayoutDialect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.thymeleaf.spring4.SpringTemplateEngine;
import org.thymeleaf.templateresolver.ITemplateResolver;

@Import(BlogConfiguration.class)
@EnableJpaRepositories(
        basePackages = {"com.woowahan.blog.repository"}
)
@ComponentScan(basePackages = {"com.woowahan.blog"})
@Configuration
public class BlogConfig {

    @Bean
    public SpringTemplateEngine templateEngine(ITemplateResolver templateResolver){
        SpringTemplateEngine templateEngine = new SpringTemplateEngine();
        templateEngine.setTemplateResolver(templateResolver);
        templateEngine.addDialect(new LayoutDialect());
        return templateEngine;
    }
}
