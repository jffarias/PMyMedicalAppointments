/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import java.text.ParseException;
import java.util.Scanner;
import java.util.ArrayList;
import model.Doctor;
import static ui.UIMenu.MONTHS;
import static ui.UIMenu.showMenu;

/**
 *
 * @author i5
 */
public class UIDoctorMenu {
    
    public static ArrayList<Doctor> doctorsAvailableAppointments = new ArrayList<>();
    
    public static void showDoctorMenu() throws ParseException{
        int response = 0;
        do{
            System.out.println("\n\n");
            System.out.println("Doctor");
            System.out.println("Welcome "+UIMenu.doctorLogged.getName());
            System.out.println("1. Add Available Appointment");
            System.out.println("2. My Scheduled appointments");
            System.out.println("0. Logout");

            Scanner sc = new Scanner(System.in);
            response = Integer.valueOf(sc.nextLine());

            switch (response){
                case 1:
                    System.out.println("::Book an appointment");
                    showAddAvalaibleAppointmentsMenu();
                    break;
                case 2:
                    System.out.println("::My appointments");
                    break;
                case 0:
                    UIMenu.showMenu();
                    break;
            }
            
        }while(response != 0);
    }
    
    public static void showAddAvalaibleAppointmentsMenu() throws ParseException{
         int response = 0;
        do{
            System.out.println("");
            System.out.println(":: Add Available Appointment");
            System.out.println(":: Select a Moth");
            for(int i=0; i<4; i++){
                int j = i+1;
                System.out.println(j +". "+UIMenu.MONTHS[i]);
            }
            System.out.println("0. Return");
            
            Scanner sc = new Scanner(System.in);
            response = Integer.valueOf(sc.nextLine());
            if(response > 0 && response < 5){
                int monthSelected = response;
                System.out.println(monthSelected+" . "+UIMenu.MONTHS[monthSelected]);
                System.out.println("Insert the date available: [dd/mm/yy]");
                String date = sc.nextLine();
                System.out.println("Your date is: "+date+"\n1. Correct \n2. Change Date");
                int responseDate = Integer.valueOf(sc.nextLine());
                if(responseDate == 2) continue;
                
                /**
                 * Mientras seleccione Change Time le mostrara el menu
                 */
                int responseTime = 0;
                String time = "";
                do{
                    System.out.println("Insert the time available for date. "+date+"[16:00]");
                    time = sc.nextLine();
                    System.out.println("Your time is: "+time+"\n1. Correct \n2. Change Time");
                    responseTime = Integer.valueOf(sc.nextLine());
                }while(responseTime == 2);
                
                UIMenu.doctorLogged.addAvailableAppointment(date, time);
                checkDoctorAvailableAppointments(UIMenu.doctorLogged);
            }else if(response == 0){
                showDoctorMenu();
            }
        }while(response != 0);
    }
    
    private static void checkDoctorAvailableAppointments(Doctor doctor){
        if(doctor.getAvailableAppointments().size() > 0
                && !doctorsAvailableAppointments.contains(doctor)){
            doctorsAvailableAppointments.add(doctor);
        }
    }
    
}
