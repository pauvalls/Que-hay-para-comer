package com.lookiero.appname.infrastructure.delivery.springboot.config;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import com.lookiero.common.messagebus.core.command.Command;
import io.github.classgraph.ClassGraph;
import io.github.classgraph.ScanResult;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class ApplicationTest {

  @Autowired
  ApplicationContext context;

  @Test
  void should_add_required_application_beans_are_created_with_correct_alias() {
    final var classGraph = new ClassGraph()
        .enableClassInfo()
        .whitelistPackages("com.lookiero.appname.application");

    try (final ScanResult scanResult = classGraph.scan()) {
      final var commandClasses = scanResult.getClassesImplementing(Command.class.getName())
          .loadClasses();
      commandClasses.stream()
          .map(Class::getSimpleName)
          .forEach(name -> assertDoesNotThrow(() -> context.getBean(name), "Command cannot be handle"));
    }
  }
}
