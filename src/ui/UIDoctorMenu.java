/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import java.util.Scanner;
import static ui.UIMenu.MONTHS;
import static ui.UIMenu.showMenu;

/**
 *
 * @author i5
 */
public class UIDoctorMenu {
    
    public static void showDoctorMenu(){
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
                    for(int i=1; i<4;i++){
                        System.out.println(1+"."+MONTHS[i]);
                    }
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
    
    public static void showAddAvalaibleAppointmentsMenu(){
         int response = 0;
        do{
            System.out.println("");
            System.out.println(":: Add Available Appointment");
            System.out.println(":: Select a Moth");
            for(int i=0; i<4; i++){
                int j = i+1;
                System.out.println(j +". "+UIMenu.MONTHS[j]);
            }
            System.out.println("0. Return");
            
            Scanner sc = new Scanner(System.in);
            response = Integer.valueOf(sc.nextLine());
            if(response > 0 && response < 5){
                int monthSelected = response;
                
            }else if(response == 0){
                showDoctorMenu();
            }
        }while(response != 0);
    }
    
}
