package org.example;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class SurgeonDoctor extends Doctor{

    public SurgeonDoctor(int age, DoctorStatus doctorStatus, String id, String name) {
        super(age, doctorStatus, id, name);

    }
public boolean addOperation(Operation operation1){
if(super.AddAppointment(operation1)) {

    return true;
}
return false;

}
    @Override
    public boolean addCheakUp(Check_UP Checkup){
        if(super.AddAppointment(Checkup)) {

            return true;
        }
        return false;

    }
}
