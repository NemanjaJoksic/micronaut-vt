package org.joksin.micronaut.vt.hello;

import io.micronaut.http.HttpStatus;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.QueryValue;
import io.micronaut.http.exceptions.HttpStatusException;
import jakarta.inject.Inject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

@Controller
public class HelloController {

  private static final Logger log = LoggerFactory.getLogger(HelloController.class);

  @Inject private HelloService helloService;

  @Get("/api/hello")
  public Map<String, Object> hello(@QueryValue String name) {
    log.info("Thread: {}", Thread.currentThread().getClass());

    if (name.equals("1")) {
      throw new HttpStatusException(HttpStatus.BAD_REQUEST, "name cannot be 1");
    }

    return Map.of("message", helloService.sayHello(name));
  }
}
