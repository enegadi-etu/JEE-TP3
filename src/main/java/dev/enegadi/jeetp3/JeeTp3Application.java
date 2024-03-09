package dev.enegadi.jeetp3;

import dev.enegadi.jeetp3.Entities.Patient;
import dev.enegadi.jeetp3.Services.HospitalServiceImpl;
import dev.enegadi.jeetp3.Services.IHospitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
public class JeeTp3Application implements CommandLineRunner {
    @Autowired
    private IHospitalService hospitalService;
    public static void main(String[] args) {
        SpringApplication.run(JeeTp3Application.class, args);
    }


    @Override
    public void run(String... args) throws Exception {
        Patient patientToSave = new Patient(null, "Ismail Enegadi", new Date(), 10000, false, null);
        Patient patient = hospitalService.savePatient(patientToSave);
    }
}
