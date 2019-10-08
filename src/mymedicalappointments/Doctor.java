package mymedicalappointments;

import java.util.ArrayList;
import java.util.Date;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author @Iesous_Flor
 */
public class Doctor extends User{
    static int id = 0; //Autoincrement
    String name;
    String speciality;
    
    public Doctor(String name, String email){
        super(name, email);
        System.out.println("El nombre del doctor designado es "+name);
        id++;
        this.name = name;
    }
    
    //Comportamiento
    public void showName(){
        System.out.println(name);
    }
    public void showId(){
        System.out.println("ID Doctor: "+id);
    }

    /**
     * Agregamos nueva cita
     */
    ArrayList<AvailableAppointment> availableAppointments = new ArrayList<>();
    public void addAvailableAppointment(Date date, String time){
        availableAppointments.add(new AvailableAppointment(date, time));
    }

    /**
     * Regresamos las citas
     * @return 
     */
    public ArrayList<AvailableAppointment> getAvailableAppointments() {
        return availableAppointments;
    }


    //Subclases
    public static class AvailableAppointment {
        private int id;
        private Date date;
        private String time;
        
        public AvailableAppointment(Date date, String time){
            this.date = date;
            this.time = time;
        }
        
        public void setId(int id){
            this.id = id;
        }
        
        public int getId(int id){
            return id;
        }
        
        public void setDate(Date date){
            this.date = date;
        }

        public Date getDate() {
            return this.date;
        }
        
        public void setTime(String time){
            this.time = time;
        }

        public String getTime() {
            return time;
        }
        
         @Override
        public String toString() {
            return "Available Appointments \nDate: " +date+ "\nTime: " + time;
        }
    }
}
