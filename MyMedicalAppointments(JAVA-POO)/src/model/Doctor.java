package model;

import java.sql.Wrapper;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Doctor extends User {
    //Atributos
    private String especialidad;


    public Doctor(String name, String email){
        super(name,email);
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    ArrayList<AvailableAppointment> availableAppointments = new ArrayList<>();
    public void addAvailableAppointment( String fecha, String hora){

        availableAppointments.add(new AvailableAppointment(fecha,hora));
    }

    public ArrayList<AvailableAppointment> getAvailableAppointments(){
        return availableAppointments;
    }

    public static class AvailableAppointment{
        private int id;
        private Date fecha;
        private String hora;
        SimpleDateFormat format = new SimpleDateFormat("dd/mm/yyyy");

        public AvailableAppointment(String fecha, String hora) {
            try {
                this.fecha = format.parse(fecha);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            this.hora = hora;

        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public Date getFecha(String DATE){
            return fecha;
        }
        public String getFecha() {
            return format.format(fecha);
        }

        public void setFecha(Date fecha) {
            this.fecha = fecha;
        }

        public String getHora() {
            return hora;
        }

        public void setHora(String hora) {
            this.hora = hora;
        }

        @Override
        public String toString() {
            return "Available Appointment" +
                    "\nid= " + id +
                    "\nfecha= " + fecha +
                    "\nhora= " + hora;
        }
    }

    @Override
    public String toString() {
        return  "model.Doctor"+
                "\nespecialidad= " + especialidad+
                "\navailable= " + availableAppointments;
    }

  
}
