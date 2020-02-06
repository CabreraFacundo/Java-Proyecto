package model;

import java.util.ArrayList;
import java.util.Date;

public class Patient extends User {
    //Atributos
    private String birthday;
    private double weight;
    private double height;
    private String blood;

    private ArrayList<AppoinmentDoctor> appointmentDoctors = new ArrayList<>();
    private ArrayList<AppointmentNurse> appointmentNurse = new ArrayList<>();

    public ArrayList<AppoinmentDoctor> getAppointmentDoctors() {
        return appointmentDoctors;
    }

    public void addAppointmentDoctors(Doctor doctor, Date date, String time) {
        AppoinmentDoctor appoinmentDoctor = new AppoinmentDoctor(this,doctor);
        appoinmentDoctor.schedule(date, time);
        appointmentDoctors.add(appoinmentDoctor);
    }

    public ArrayList<AppointmentNurse> getAppointmentNurse() {
        return appointmentNurse;
    }

    public void setAppointmentNurse(ArrayList<AppointmentNurse> appointmentNurse) {
        this.appointmentNurse = appointmentNurse;
    }

    public Patient(String name, String email){
        super(name, email);
    }

    //Getters y setters se sacan con alt+insert

    public String getWeight() {
        return this.weight + " Kg.";
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getHeight() {
        return this.height + " Mts.";
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
        return "model.Patient" +
                "\nbirthday='" + birthday+
                "\nweight=" + weight+
                "\nheight=" + height+
                "\nblood='" + blood;
    }
}
