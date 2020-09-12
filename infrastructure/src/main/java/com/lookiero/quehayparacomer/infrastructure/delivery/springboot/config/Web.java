package com.lookiero.quehayparacomer.infrastructure.delivery.springboot.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan({
    "com.lookiero.quehayparacomer.infrastructure.delivery.springboot.controller"
})
public class Web {

}
