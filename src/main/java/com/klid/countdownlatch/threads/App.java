package com.klid.countdownlatch.threads;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

@Slf4j
public class App {

  public static void main(String[] args) {
    var currentTimeMillis = System.currentTimeMillis();
    var noteCalculator = new MultiThreadNoteCalculator(10);
    var result = noteCalculator.computeAndDisplayStudentAverageNote();

    log.info("================================= EXECUTION TIME =================================");
    log.info(
      "finished. Result : %s, Time : %ss"
        .formatted(
          result,
          TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis() - currentTimeMillis))
    );

    System.exit(result ? 0 : -1);
  }
}
