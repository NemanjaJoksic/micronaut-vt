package org.joksin.micronaut.vt.hello;

import jakarta.validation.constraints.NotBlank;

public interface HelloService {

  String sayHello(@NotBlank String name);
}
