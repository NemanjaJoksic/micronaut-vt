package org.joksin.micronaut.vt.file;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.PathVariable;
import io.micronaut.scheduling.TaskExecutors;
import io.micronaut.scheduling.annotation.ExecuteOn;
import jakarta.inject.Inject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

@Controller
@ExecuteOn(TaskExecutors.BLOCKING)
public class FileController {

  private static final Logger log = LoggerFactory.getLogger(FileController.class);

  @Inject private FileService fileService;

  @Get("/api/files/{id}")
  public Map<String, Object> getFile(@PathVariable Long id) throws Exception {
    log.info(
        "Controller thread class: {};{}",
        Thread.currentThread(),
        Thread.currentThread().getClass());

    var content = fileService.readFileContent(id);

    return Map.of("size", content.length());
  }
}
