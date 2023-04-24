package com.klid.countdownlatch.nothread;

import com.klid.countdownlatch.NoteCalculator;
import com.klid.countdownlatch.Student;
import com.klid.countdownlatch.StudentData;
import lombok.extern.slf4j.Slf4j;

import java.util.Comparator;
import java.util.Map;
import java.util.stream.Collectors;

@Slf4j
public class SingleThreadNoteCalculator implements NoteCalculator {

  @Override
  public boolean computeAndDisplayStudentAverageNote() {
    try {
      var students = StudentData.students;

      students.stream()
        .collect(Collectors.toMap(Student::name, Student::avg))
        .entrySet()
        .stream()
        .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
        .map(Map.Entry::toString)
        .forEach(log::info);

      return true;
    } catch (Exception ex) {
      log.error("Error on computing student average note", ex);
      return false;
    }
  }
}
