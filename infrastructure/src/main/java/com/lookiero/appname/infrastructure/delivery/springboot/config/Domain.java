package com.lookiero.appname.infrastructure.delivery.springboot.config;

import com.lookiero.common.messagebus.stereotype.AppComponent;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
    value = {"com.lookiero.appname.domain.model"},
    includeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = AppComponent.class)
)
public class Domain {

}
