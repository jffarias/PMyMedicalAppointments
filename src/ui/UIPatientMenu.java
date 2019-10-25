/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import model.Doctor;

/**
 *
 * @author i5
 */
public class UIPatientMenu {
    
    public static void showPatientMenu() throws ParseException{
        int response = 0;
        do{
            System.out.println("\n\n");
            System.out.println("Patient");
            System.out.println("Welcome "+UIMenu.patinetLogged);
            System.out.println("1. Add Available Appointment");
            System.out.println("2. My Scheduled appointments");
            System.out.println("0. Logout");
            
            Scanner sc = new Scanner(System.in);
            response = Integer.valueOf(sc.nextLine());
            switch(response){
                case 1:
                    break;
                case 2:
                    break;
                case 0:
                    UIMenu.showMenu();
                    break;
            }
        }while(response != 0);
    }
    
    private static void showBookAppointmentMenu(){
        
        int response = 0;
        do{
            System.out.println(":: Book an Appointment");
            System.out.println(":: Select date: ");
            //Numero de la lista de fechas
            //Indice de fechas disponibles
            //[doctors]
            //1.- doctor1
                    //1- fecha 1
                    //2 - fecha 2
            //2.- doctor2
            Map<Integer, Map<Integer, Doctor>> doctors = new TreeMap<>();
            int k = 0;
            for(int i=0; i<UIDoctorMenu.doctorsAvailableAppointments.size(); i++){
                ArrayList<Doctor.AvailableAppointment> avalailableAppointments = 
                        UIDoctorMenu.doctorsAvailableAppointments.get(i).getAvailableAppointments();
                
                //recorremos avalailableAppointmets
                Map<Integer, Doctor> doctorAppointments = new TreeMap<>();
                for(int j=0; j<avalailableAppointments.size(); j++){
                    k++;
                    System.out.println(k + ". "+avalailableAppointments.get(j).getDate());
                    doctorAppointments.put(Integer.valueOf(j), UIDoctorMenu.doctorsAvailableAppointments.get(i));
                    doctors.put(Integer.valueOf(k), doctorAppointments);
                }
            }
            
            Scanner sc = new Scanner(System.in);
            int responseDateSelected = Integer.valueOf(sc.nextLine());
            Map<Integer, Doctor> doctorAvailableSelected = doctors.get(responseDateSelected);
            Integer indexDate = 0;
            Doctor doctorSelected = new Doctor("","");
            
            for(Map.Entry<Integer, Doctor> doc :doctorAvailableSelected.entrySet()){
                indexDate = doc.getKey();
                doctorSelected = doc.getValue();
            }
            
            /**/
            System.out.println(doctorSelected.getName() + 
                    ". Date: " + 
                    doctorSelected.getAvailableAppointments().get(indexDate).getDate() + 
                    ". Time:" +
                    doctorSelected.getAvailableAppointments().get(indexDate).getTime());
            
            System.out.println("Confirm your appointment: \n1. Yes \n2. Change Data");
            response = Integer.valueOf(sc.nextLine());
            if(response == 1){
                //UIMenu.patinetLogged.addAppointmentDoctors();
            }
        }while(response != 0);
        
    }
    
}
