/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author i5
 */
public abstract class User {
    //Video 26 - Hacemos abstrac User
    private int id;
    private String name;
    private String email;
    private String address;
    private String phoneNumber;

    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        if (phoneNumber.length() > 8){
            System.out.println("El nÃºmero telefÃ³nico debe ser de 8 dÃ­gitos mÃ¡ximo");
        }else if(phoneNumber.length() == 8){
            this.phoneNumber = phoneNumber;
        }
    }

    @Override
    public String toString() {
        return "User: " + name + ", Email: "+email+
                "\nAddreess: "+address+". Phone: "+phoneNumber;
    }
    
    //Video 27 - Miembros abstractos
    /*Los Métodos Abstractos son los métodos que debemos 
    implementar obligatoriamente cada vez que usemos 
    nuestras clases abstractas, mientras que los métodos 
    que no sean abstractos van a ser opcionales.*/
    public abstract void showDataUser();
}
