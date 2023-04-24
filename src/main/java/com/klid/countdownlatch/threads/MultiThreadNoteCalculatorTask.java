package com.klid.countdownlatch.threads;

import com.klid.countdownlatch.Student;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

@Slf4j
@RequiredArgsConstructor
public class MultiThreadNoteCalculatorTask implements Runnable {

  private final Student student;
  private final CountDownLatch latch;
  private final AtomicBoolean result;
  private final AtomicReference<Map<String, Double>> notes;

  public void run() {
    try {
      notes.get().put(student.name(), student.avg());
    } catch (Exception ex) {
      log.error("Error", ex);
      result.set(false);
    } finally {
      latch.countDown();
      ThreadContext.remove();
    }
  }
}
