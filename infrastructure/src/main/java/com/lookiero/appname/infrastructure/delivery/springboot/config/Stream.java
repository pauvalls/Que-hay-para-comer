package com.lookiero.appname.infrastructure.delivery.springboot.config;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableBinding(value = {OutputSource.class, InputSink.class})
@ComponentScan("com.lookiero.appname.infrastructure.delivery.springboot.stream")
public class Stream {

}
