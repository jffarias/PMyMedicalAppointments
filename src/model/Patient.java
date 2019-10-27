/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author iesous_flor
 */
public class Patient extends User{
    //Patient hereda de User
    private String birthday;
    private double weight;
    private double height;
    private String blood;
    
    //Video 37 - Agendamos las citas
    private ArrayList<AppointmentDoctor> appointmentDoctors = new ArrayList<>();
    private ArrayList<AppointmentNurse> appointmentNurses = new ArrayList<>();
    
    public ArrayList<AppointmentDoctor> getAppointmentDoctors(){
        return appointmentDoctors;
    }
    
    //Doctor doctor, Date date, String time
    public void addAppointmentDoctors(Doctor doctor, Date date, String time){
        AppointmentDoctor appointmentDoctor = new AppointmentDoctor(this, doctor);
        appointmentDoctor.schedul(date, time);
        appointmentDoctors.add(appointmentDoctor);
    }
    
    public Patient(String name, String email){
        super(name, email);
    }
    
     // 54.5
    public void setWeight(double weight) {
        this.weight = weight;
    }

    // 54.5 Kg. String
    public String getWeight(){
        return this.weight + " Kg.";
    }


    public String getHeight() {
        return height + " Mts.";
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getBlood() {
        return blood;
    }

    public void setBlood(String blood) {
        this.blood = blood;
    }

    @Override
    public String toString() {
        return super.toString() + "\nAge: " + birthday + 
                "\n Weight: " +getWeight()+ 
                "\n Height"+getHeight()+
                "\nBlood"+blood;
    }

    @Override
    public void showDataUser() {
        System.out.println("Paciente");
        System.out.println("Historial clinico en este Hospital");
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
