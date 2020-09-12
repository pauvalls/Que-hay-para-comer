package com.lookiero.appname.infrastructure.delivery.springboot;

import java.time.Clock;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication(scanBasePackages = "com.lookiero.appname.infrastructure.delivery.springboot.config")
public class AppnameApp {

  public static void main(final String[] args) {
    SpringApplication.run(AppnameApp.class, args);
  }

  @Bean
  public Clock clock() {
    return Clock.systemUTC();
  }
}
