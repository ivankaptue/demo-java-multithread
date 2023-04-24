package com.klid.countdownlatch;

import com.klid.countdownlatch.threads.ThreadContext;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public record Student(String name, List<Double> note) {

  public double avg() {
    log.info("%s - started, threadId : %s".formatted(name, ThreadContext.THREAD_UUID.get()));
    Sleep.sleep(5);

    var avg = note.stream()
      .mapToDouble(value -> value)
      .average()
      .orElseThrow();

    log.info("%s - ended, threadId : %s\n".formatted(name, ThreadContext.THREAD_UUID.get()));

    if (avg < 10) {
      // throw new IllegalStateException("Student %s failed".formatted(name));
    }

    return avg;
  }

  @Override
  public String name() {
    return name.toUpperCase();
  }
}
