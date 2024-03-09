package dev.enegadi.jeetp3.Services;

import dev.enegadi.jeetp3.Entities.Appointment;
import dev.enegadi.jeetp3.Entities.Consultation;
import dev.enegadi.jeetp3.Entities.Doctor;
import dev.enegadi.jeetp3.Entities.Patient;

import java.util.List;

public interface IHospitalService {
    Doctor saveDoctor(Doctor doctor);
    Doctor getDoctorById(Long id);
    List<Doctor> getAllDoctors();
    Patient savePatient(Patient patient);
    Patient getPatientById(Long id);
    List<Patient> getAllPatients();
    Appointment saveAppointment(Appointment appointment);
    Appointment getAppointmentById(Long id);
    List<Appointment> getAllAppointments();
    Consultation saveConsultation(Consultation consultation);
    Consultation getConsultationById(Long id);
    List<Consultation> getAllConsultations();
}
