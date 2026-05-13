package com.hospital;

public class SurgeonDoctor extends Doctor {

  public SurgeonDoctor(int age, int id, String name) {
    super(age, id, name);
  }

  public boolean addOperation(Operation operation1) {
    if (super.addAppointment(operation1)) {

      return true;
    }

    return false;
  }
}
