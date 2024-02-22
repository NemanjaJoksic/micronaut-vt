package org.joksin.micronaut.vt.file;

import jakarta.inject.Singleton;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.file.Files;
import java.nio.file.Paths;

@Singleton
public class FileService {

  private static final Logger log = LoggerFactory.getLogger(FileService.class);

  public String readFileContent(long id) throws Exception {
    long startTime = System.currentTimeMillis();
    var content = Files.readString(Paths.get("data/file" + id + ".txt"));
    Thread.sleep(1000);
    long timeTaken = System.currentTimeMillis() - startTime;
    log.info("File content read in " + timeTaken + "ms");
    log.info(
        "Service thread class: {};{}", Thread.currentThread(), Thread.currentThread().getClass());

    return content;
  }
}
