package com.lookiero.appname.infrastructure.delivery.springboot.config;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface OutputSource {

  String OUTPUT_CHANNEL_NAME = "output";

  @Output(OutputSource.OUTPUT_CHANNEL_NAME)
  MessageChannel output();
}
