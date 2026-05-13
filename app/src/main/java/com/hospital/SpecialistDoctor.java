package com.hospital;

enum Specialist {
  Cardiology, Orthopedics, Dermatology
}

public class SpecialistDoctor extends Doctor {
  public SpecialistDoctor(int age, int id, String name, Paitent paitent) {
    super(age, id, name);
  }
}
