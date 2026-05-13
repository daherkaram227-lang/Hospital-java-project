package com.hospital;

public class CheckUp extends Appointment {
  public CheckUp(String startTime, String endTime, boolean isOperation, boolean isEmergency) {
    super(startTime, endTime, isOperation, isEmergency);
  }

  @Override
  public String Treat() {
    return "Checking up on " + super.getPaitent().getName() + " for illness " + getIllness();
  }
}
