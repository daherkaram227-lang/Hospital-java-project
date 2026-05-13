package org.example;

import com.hospital.*;
import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;
import static org.junit.jupiter.api.Assertions.*;

class AppTest {

  // A simple mock doctor class to test Doctor's scheduling logic
  static class TestDoctor extends Doctor {
    public TestDoctor() {
      super(40, 1, "Dr. Smith");
    }
  }

  @Test
  void testNormalAppointmentScheduling() {
    Doctor doctor = new TestDoctor();

    CheckUp normal1 = new CheckUp("2026-05-13T10:00:00", "2026-05-13T10:30:00", false, false);
    assertTrue(doctor.addAppointment(normal1), "Should add first appointment");

    // Conflict
    CheckUp normal2 = new CheckUp("2026-05-13T10:15:00", "2026-05-13T10:45:00", false, false);
    assertFalse(doctor.addAppointment(normal2), "Should fail due to overlap");

    // Non-conflict
    CheckUp normal3 = new CheckUp("2026-05-13T10:30:00", "2026-05-13T11:00:00", false, false);
    assertTrue(doctor.addAppointment(normal3), "Should add non-overlapping appointment");
  }

  @Test
  void testEmergencyAppointmentScheduling() {
    Doctor doctor = new TestDoctor();

    CheckUp normal1 = new CheckUp("2026-05-14T08:15:00", "2026-05-14T09:00:00", false, false);
    CheckUp normal2 = new CheckUp("2026-05-14T09:30:00", "2026-05-14T10:00:00", false, false);

    // This appointment occupies tomorrow's slot, causing normal1 to be pushed a
    // second time
    CheckUp normal3 = new CheckUp("2026-05-15T08:00:00", "2026-05-15T09:30:00", false, false);

    doctor.addAppointment(normal1);
    doctor.addAppointment(normal2);
    doctor.addAppointment(normal3);

    // Emergency requested for 08:30 - 09:45
    // Overlaps with normal1 and normal2
    CheckUp emergency = new CheckUp("2026-05-14T08:30:00", "2026-05-14T09:45:00", true, true);
    assertTrue(doctor.addAppointment(emergency), "Should add emergency appointment");

    assertEquals(LocalDateTime.parse("2026-05-14T08:30:00"), emergency.getStartTime(),
        "Emergency should keep its requested start time");
    assertEquals(LocalDateTime.parse("2026-05-14T09:45:00"), emergency.getEndTime(),
        "Emergency should keep its requested end time");

    // normal1 is bumped to 05-15, but normal3 is occupying that slot.
    // Therefore, normal1 must loop and push itself to 05-16.
    assertEquals(LocalDateTime.parse("2026-05-16T08:15:00"), normal1.getStartTime(),
        "Normal1 should cascade push to the day after tomorrow due to conflict");
    assertEquals(LocalDateTime.parse("2026-05-16T09:00:00"), normal1.getEndTime());

    // normal2 is bumped to 05-15. It starts at 09:30. normal3 ends at 09:30.
    // It does not strictly overlap, so it successfully lands on 05-15.
    assertEquals(LocalDateTime.parse("2026-05-15T09:30:00"), normal2.getStartTime(),
        "Normal2 should be rescheduled to next day without secondary conflict");
  }
}
