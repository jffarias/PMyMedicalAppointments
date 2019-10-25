package model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
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
    //static int id = 0; //Autoincrement
    //String name;
    String speciality;
    
    public Doctor(String name, String email){
        super(name, email);
        //System.out.println("El nombre del doctor designado es "+name);
        //id++;
        //this.name = name;
    }
    
    public String getSpeciality(){
        return speciality;
    }
    public void setSpeacility(String speciality){
        this.speciality = speciality;
    }
    //Comportamiento
    /*public void showName(){
        System.out.println(name);
    }
    public void showId(){
        System.out.println("ID Doctor: "+id);
    }*/

    /**
     * Agregamos nueva cita
     */
    ArrayList<AvailableAppointment> availableAppointments = new ArrayList<>();
    public void addAvailableAppointment(String date, String time) throws ParseException{
        availableAppointments.add(new AvailableAppointment(date, time));
    }

    /**
     * Regresamos las citas
     * @return 
     */
    public ArrayList<AvailableAppointment> getAvailableAppointments() {
        return availableAppointments;
    }
    
    @Override
    public String toString() {
        return super.toString() + "\nSpeciality: " +speciality;
    }

    @Override
    public void showDataUser() {
        System.out.println("Hospital: Cruz Roja");
        System.out.println("Departamento: Cancelorogia");
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        
    }


    //Subclases
    public static class AvailableAppointment {
        private int id;
        private Date date;
        private String time;
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yy");
        
        public AvailableAppointment(String date, String time) throws ParseException{
            this.date = format.parse(date);
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
