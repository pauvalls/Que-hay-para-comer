package com.lookiero.appname.infrastructure.delivery.springboot.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan({
    "com.lookiero.appname.infrastructure.delivery.springboot.persistence"
})
public class Persistence {

}
