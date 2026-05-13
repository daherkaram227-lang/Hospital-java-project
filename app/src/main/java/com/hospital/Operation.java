package com.hospital;

enum Operationtype {
  Orthopedicsurgery,
  Neurosurgery,
  Cardiacsurgery

}

public class Operation extends Appointment {

  private Operationtype type;

  public Operation(String startTime, String endTime, Status status, boolean isOperation, boolean isEmergency, Operationtype type) {
    super(startTime, endTime, isOperation, isEmergency);
    this.type = type;
  }

  public final Operationtype getType() {
    return this.type;
  }

  @Override
  public String Treat() {
    return "Doing operation for patient " + super.getPaitent();
  }
}
