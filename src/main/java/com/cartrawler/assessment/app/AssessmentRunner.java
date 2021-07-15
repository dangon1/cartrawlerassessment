package com.cartrawler.assessment.app;

import com.cartrawler.assessment.app.config.CarTrawlerAssessmentConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AssessmentRunner {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(CarTrawlerAssessmentConfig.class);
        SpringRunner springRunner = context.getBean(SpringRunner.class);
        springRunner.run();
        context.close();
    }        
}