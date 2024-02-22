package org.joksin.micronaut.vt.hello;

import jakarta.inject.Singleton;

@Singleton
class HelloServiceImpl implements HelloService {
  @Override
  public String sayHello(String name) {
    return "Hello " + name;
  }
}
