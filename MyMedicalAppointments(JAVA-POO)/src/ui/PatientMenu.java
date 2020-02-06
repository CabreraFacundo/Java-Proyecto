package ui;

import com.sun.org.apache.xalan.internal.xsltc.trax.XSLTCSource;
import model.Doctor;

import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class PatientMenu {

    public static void showPatientMenu(){
        int response = 0;
        do {
            System.out.println("\n\n");
            System.out.println("Patient");
            System.out.println("Welcome: "+UImenu.patientLogged.getName());
            System.out.println("1. Book an appointment");
            System.out.println("2. My appointment");
            System.out.println("0. Logout");

            Scanner sc = new Scanner(System.in);
            response = Integer.valueOf(sc.nextLine());

            switch (response){
                case 1:
                    showBookAppointmentMenu();
                    break;
                case 2:
                    break;
                case 0:
                    UImenu.showMenu();
                    break;
            }

        }while (response!=0);
    }

    private static void showBookAppointmentMenu(){
        int response = 0;
        do {
            System.out.println("::Book an appointment");
            System.out.println("::Select date");
            //Numeracion de la lista de fechas
            //Indice de fecha seleccionada
            //[doctors]
            // 1- doctor1
                    // -1 fecha1
                    //- 2 fecha2
            // 2- doctor2
            // 3- doctor3
            Map<Integer, Map<Integer, Doctor>> doctors  = new TreeMap<>();
            int k = 0;
            for (int i = 0; i < UIDoctorMenu.doctorsAvailableAppointments.size(); i++) {
                ArrayList<Doctor.AvailableAppointment> availableAppointments
                        = UIDoctorMenu.doctorsAvailableAppointments.get(i).getAvailableAppointments();
                Map<Integer, Doctor> doctorAppointments = new TreeMap<>();
                for (int j = 0; j < availableAppointments.size() ; j++) {
                    k++;
                    System.out.println(k + " . "+availableAppointments.get(j).getFecha());
                    doctorAppointments.put(Integer.valueOf(j), UIDoctorMenu.doctorsAvailableAppointments.get(i));

                    doctors.put(Integer.valueOf(k), doctorAppointments);
                }
            }
            Scanner sc = new Scanner(System.in);
            int responseDateSelected = Integer.valueOf(sc.nextLine());
            Map<Integer, Doctor> doctorAvailableSelected = doctors.get(responseDateSelected);
            Integer indexDate = 0;
            Doctor doctorSelected = new Doctor("","");

            for (Map.Entry<Integer, Doctor> doc :doctorAvailableSelected.entrySet()) {
                indexDate = doc.getKey();
                doctorSelected = doc.getValue();
            }

            System.out.println(doctorSelected.getName()+
                    ". Date: "+
                    doctorSelected.getAvailableAppointments().get(indexDate).getFecha()+
                    ". Time: "+
                    doctorSelected.getAvailableAppointments().get(indexDate).getHora());

            System.out.println("Confirm your appointment: \n1. Yes \n2. Change data");
            response = Integer.valueOf(sc.nextLine());

            if (response == 1){
                UImenu.patientLogged.addAppointmentDoctors(
                        doctorSelected,
                        doctorSelected.getAvailableAppointments().get(indexDate).getFecha(null),
                        doctorSelected.getAvailableAppointments().get(indexDate).getHora());
                showPatientMenu();
            }

        }while (response == 0);
    }

    private static void showPatientMyAppointment(){
        int response = 0;
        do{
            System.out.println("::My Appointments");
            if (UImenu.patientLogged.getAppointmentDoctors().size() ==0){
                System.out.println("Don't have appointments");
                break;
            }
            for (int i = 0; i <UImenu.patientLogged.getAppointmentDoctors().size(); i++) {
                int j = i +1;
                System.out.println(j+". "+
                        " Date: "+UImenu.patientLogged.getAppointmentDoctors().get(i).getDate()+
                        " Time:"+UImenu.patientLogged.getAppointmentDoctors().get(i).getTime()+
                        "\n Doctor : "+UImenu.patientLogged.getAppointmentDoctors().get(i).getDoctor());
            }

            System.out.println("0. Return");
        }while (response!=0);
    }
}
