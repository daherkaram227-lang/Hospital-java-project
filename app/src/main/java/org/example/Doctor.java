package org.example;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

enum DoctorStatus{

    Available,Non_Available

}
public abstract class Doctor {
   String Id;
   String Name;
   int Age;
   PriorityQueue<Appointment> appointments;
    DoctorStatus doctorStatus;

    public Doctor(int age, DoctorStatus doctorStatus, String id, String name) {
        Age = age;
        this.doctorStatus = doctorStatus;
        Id = id;
        Name = name;
this.appointments=new PriorityQueue<>(Comparator.comparing(appointment -> appointment.getAppointmentStart()));
    }
public boolean AddAppointment(Appointment Newappointment){

        for (Appointment existing:appointments) {
            if (Newappointment.getAppointmentStart().isBefore(existing.getAppointmentEnd())
                    && Newappointment.getAppointmentEnd().isAfter(existing.getAppointmentStart())) {

                return false;
            }
        }
appointments.add(Newappointment);
return true;
}
    boolean IsAvaulable(){

  return (doctorStatus==DoctorStatus.Available);

        }
    public abstract boolean addCheakUp(Check_UP Checkup);
}
