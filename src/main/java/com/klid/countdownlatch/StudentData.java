package com.klid.countdownlatch;

import java.util.List;

public interface StudentData {

  List<Student> students = List.of(
    new Student("Harry", List.of(12D, 02D, 15D, 04D, 18D)),
    new Student("Jean", List.of(03D, 17D, 08D, 04D, 16D)),
    new Student("Emmy", List.of(17D, 14D, 12D, 02D, 09D)),
    new Student("Azikiwe", List.of(04D, 06D, 19D, 07D, 12D)),
    new Student("Nigesa", List.of(03D, 14D, 05D, 13D, 18D)),
    new Student("Babangida", List.of(12D, 10D, 11D, 14D, 17D)),
    new Student("Biobaku", List.of(08D, 14D, 14D, 17D, 11D)),
    new Student("Bamgboshe", List.of(10D, 01D, 18D, 16D, 09D)),
    new Student("Akinjide", List.of(15D, 18D, 17D, 11D, 13D)),
    new Student("Dashiki", List.of(17D, 13D, 07D, 09D, 10D))
  );
}
