package org.example;
enum Specialist{
    Cardiology,Orthopedics,Dermatology

}
public class SpecialistDoctor extends Doctor {
    public SpecialistDoctor(int age, DoctorStatus doctorStatus, String id, String name,Paitent paitent) {
        super(age, doctorStatus, id, name);
    }

    @Override
    public boolean addCheakUp(Check_UP Checkup){
        if(super.AddAppointment(Checkup)) {

            return true;
        }
        return false;

    }
}
