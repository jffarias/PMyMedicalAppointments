/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;
import model.Doctor;
import model.Patient;
import static ui.UIDoctorMenu.showDoctorMenu;
import static ui.UIPatientMenu.showPatientMenu;



/**
 *
 * @author i5
 */
public class UIMenu {
    
    public static final String[] MONTHS = {"Enero", "Febrero","Marzo","Abril","Mayo","Junio","Julio","Agosto",
        "Septiembre","Octubre","Noviembre","Diciembre"};
    public static Doctor doctorLogged;
    public static Patient patientLogged;
    
    
    public static void showMenu() throws ParseException{
        int response = 0;
        do {
            System.out.println("\n");
            System.out.println("Welcome to My Appointments");
            System.out.println("Selecciona la opción deseada");
            System.out.println("1. Doctor");
            System.out.println("2. Patient");
            System.out.println("0. Salir");

            Scanner sc = new Scanner(System.in);
            response = Integer.valueOf(sc.nextLine());

            switch (response){
                case 1:
                    System.out.println("Doctor");
                    authUser(1);
                    break;
                case 2:
                     System.out.println("Patient");
                    authUser(2);
                    break;
                case 0:
                    System.out.println("Thank you for you visit");
                    break;
                default:
                    System.out.println("Please select a correct answer");
            }
        }while (response != 0);
    }
    
    private static void authUser(int userType) throws ParseException{
        //userType = 1 Doctor
        //userType = 2 Patient
        ArrayList<Doctor> doctors = new ArrayList<>();
        doctors.add(new Doctor("Dr Juan Perez", "drjperez@mail.com"));
        doctors.add(new Doctor("Karen Sosa", "kare@mail.com"));
        doctors.add(new Doctor("RocÃ­o GÃ³mez", "rocio@mail.com"));

        ArrayList<Patient> patients = new ArrayList<>();
        patients.add(new Patient("Jesus Flor Farias", "jflor@mail.com"));
        patients.add(new Patient("Roberto RodrÃ­guez", "roberto@mail.com"));
        patients.add(new Patient("Carlos SÃ¡nchez", "carlos@mail.com"));


        boolean emailCorrect = false;
        do {
            System.out.println("Insert your email: [a@a.com]");
            Scanner sc = new Scanner(System.in);
            String email = sc.nextLine();
            if (userType == 1){
                for (Doctor d: doctors){
                    if (d.getEmail().equals(email)){
                        emailCorrect = true;
                        //Obtener el usuario logeado
                        doctorLogged = d;
                        showDoctorMenu();
                    }
                }
            }

            if (userType == 2){
                for (Patient p: patients){
                    if (p.getEmail().equals(email)){
                        emailCorrect = true;
                        patientLogged = p;
                        showPatientMenu();
                    }
                }
            }
        }while (!emailCorrect);

    }
}
