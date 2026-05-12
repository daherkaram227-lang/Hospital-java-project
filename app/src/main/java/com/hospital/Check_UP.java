package com.hospital;

public class Check_UP extends Appointment {
  public Check_UP(String AppointmentStart, String AppointmentEnd, Status status, boolean isOperation) {
    super(AppointmentStart, AppointmentEnd, status, isOperation);
  }

  @Override
  public String Treat() {
    return "";
  }
}
