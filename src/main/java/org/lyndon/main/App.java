package org.lyndon.main;

import org.lyndon.service.PersonService;
import org.lyndon.vo.SearchResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.*;

/**
 * Created by Lyndon on 30/5/15.
 */
@Configuration
@EnableAutoConfiguration
@ComponentScan(basePackages = "org.lyndon")
public class App {

    @Autowired
    private PersonService personService;

    @Bean
    @Scope("prototype")
    public SearchResult getSearchResult() {
        return new SearchResult();
    }

    public void exec() {
        personService.serve();
    }

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(App.class);
        app.setShowBanner(false);
        ConfigurableApplicationContext ctx = app.run(args);
        App springApp = ctx.getBean(App.class);
        springApp.exec();
    }

}
