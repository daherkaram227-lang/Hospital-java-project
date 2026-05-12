
package org.example;

public class App {


    public static void main(String[] args) {

        SurgeonDoctor doctor=new SurgeonDoctor(33,DoctorStatus.Available,"112334","ali") ;
        Operation operation=new Operation("12:00","13:00",Status.Scheduled,true,Operationtype.Cardiacsurgery);
        Check_UP checkUp = new Check_UP("12:00","13:00",Status.Scheduled,true);
         Paitent paitent =new Paitent("122","Basel",33,"0959514555");



}}
