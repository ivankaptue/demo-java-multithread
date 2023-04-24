package com.klid.countdownlatch;

import java.util.concurrent.TimeUnit;

public class Sleep {

  public static void sleep(int timeoutSecond) {
    try {
      TimeUnit.SECONDS.sleep(timeoutSecond);
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
  }
}
