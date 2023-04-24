package com.klid.countdownlatch.threads;

import com.klid.countdownlatch.NoteCalculator;
import com.klid.countdownlatch.Student;
import com.klid.countdownlatch.StudentData;
import lombok.extern.slf4j.Slf4j;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

@Slf4j
public class MultiThreadNoteCalculator implements NoteCalculator {

  private final ExecutorService executorService;
  private final AtomicBoolean result = new AtomicBoolean(true);
  private final AtomicReference<Map<String, Double>> notes = new AtomicReference<>(new HashMap<>());

  public MultiThreadNoteCalculator(int threads) {
    executorService = Executors.newFixedThreadPool(threads);
  }

  @Override
  public boolean computeAndDisplayStudentAverageNote() {
    var students = StudentData.students;
    var countDownLatch = new CountDownLatch(students.size());

    try {
      for (Student student : students) {
        executorService.submit(new MultiThreadNoteCalculatorTask(student, countDownLatch, result, notes));
      }

      countDownLatch.await();

      notes.get()
        .entrySet()
        .stream()
        .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
        .map(Map.Entry::toString)
        .forEach(log::info);
    } catch (RejectedExecutionException | InterruptedException ex) {
      log.error("Error", ex);
      result.set(false);
    }

    executorService.shutdown();

    return result.get();
  }
}
