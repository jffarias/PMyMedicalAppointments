/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mymedicalappointments;
import java.text.ParseException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.User;
import static ui.UIMenu.*;

/**
 *
 * @author i5
 */
public class MyMedicalAppointments {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            // TODO code application logic here
            showMenu();
        } catch (ParseException ex) {
            Logger.getLogger(MyMedicalAppointments.class.getName()).log(Level.SEVERE, null, ex);
        }
        /*
        Video 28 - Clases Anonimas
        Las Clases Anónimas son una forma de instanciar 
        clases abstractas sin necesidad de usar sus clases hijas. 
        Pero este tipo de instanciación tiene algunas restricciones: 
        el ciclo de vida de estas instancias NO es duradero, 
        no las tendremos disponibles durante toda la ejecución del programa.
        */
        /*User user1 = new User("Jesus Flor", "jflor@gmail.com") {
            @Override
            public void showDataUser() {
                System.out.println("IMSS");
                System.out.println("Depto: Urgencias");
            }
        };
        user1.showDataUser();*/
    }
    
}
