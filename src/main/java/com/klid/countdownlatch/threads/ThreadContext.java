package com.klid.countdownlatch.threads;

import java.util.UUID;

public class ThreadContext {
  public static final ThreadLocal<UUID> THREAD_UUID = ThreadLocal.withInitial(UUID::randomUUID);

  public static void remove() {
    THREAD_UUID.remove();
  }
}
