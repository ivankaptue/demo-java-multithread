package unit.com.klid.countdownlatch;

import com.klid.countdownlatch.Student;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class StudentTest {

  @Test
  void testComputeAverageHarry() {
    var student = new Student("Harry", List.of(12D, 02D, 15D, 04D, 18D));
    testComputeAverage(student, "HARRY", 10.2);
  }

  @Test
  void testComputeAverageAzikiwe() {
    var student = new Student("Azikiwe", List.of(04D, 06D, 19D, 07D, 12D));
    testComputeAverage(student, "AZIKIWE", 9.6);
  }

  void testComputeAverage(Student student, String expectedName, double expectedAvg) {
    var avg = student.avg();
    assertThat(student.name()).isEqualTo(expectedName);
    assertThat(avg).isEqualTo(expectedAvg);
  }
}
