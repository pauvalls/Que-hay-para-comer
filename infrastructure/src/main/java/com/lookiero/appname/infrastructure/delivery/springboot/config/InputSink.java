package com.lookiero.appname.infrastructure.delivery.springboot.config;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.MessageChannel;

public interface InputSink {

  String INPUT_CHANNEL_NAME = "input";

  @Input
  MessageChannel input();
}
