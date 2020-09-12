package com.lookiero.appname.contract.base;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.lookiero.common.requestresponse.infrastructure.error.AppExceptionHandler;
import com.lookiero.common.requestresponse.infrastructure.springboot.web.RestControllerExceptionHandler;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import javax.validation.Validation;
import javax.validation.Validator;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

final class ContractBaseFixtures {

  static RestControllerExceptionHandler buildRestControllerExceptionHandler() {
    final var appExceptionHandler = new AppExceptionHandler();
    final var objectMapper = new ObjectMapper();
    return new RestControllerExceptionHandler(appExceptionHandler, objectMapper);
  }

  static Validator buildValidator() {
    return Validation.buildDefaultValidatorFactory().getValidator();
  }

  static void mockMvcStandaloneSetupWithJackson(final Object... controllers) {
    final var objectMapper = new ObjectMapper()
        .findAndRegisterModules()
        .configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);

    final var mappingJackson2HttpMessageConverter = new MappingJackson2HttpMessageConverter();
    mappingJackson2HttpMessageConverter.setObjectMapper(objectMapper);

    final var mockMvc = MockMvcBuilders.standaloneSetup(controllers)
        .setMessageConverters(mappingJackson2HttpMessageConverter)
        .build();

    RestAssuredMockMvc.mockMvc(mockMvc);
  }
}
