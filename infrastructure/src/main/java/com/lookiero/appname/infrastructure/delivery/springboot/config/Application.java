package com.lookiero.appname.infrastructure.delivery.springboot.config;

import com.lookiero.common.messagebus.infrastructure.AppComponentBeanNameGenerator;
import com.lookiero.common.messagebus.stereotype.AppComponent;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(
    value = {"com.lookiero.appname.application"},
    nameGenerator = AppComponentBeanNameGenerator.class,
    includeFilters = @ComponentScan.Filter(classes = AppComponent.class)
)
public class Application {

}
