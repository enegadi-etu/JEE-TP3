package dev.enegadi.jeetp3.Services;

import dev.enegadi.jeetp3.Entities.Appointment;
import dev.enegadi.jeetp3.Entities.Consultation;
import dev.enegadi.jeetp3.Entities.Doctor;
import dev.enegadi.jeetp3.Entities.Patient;
import dev.enegadi.jeetp3.Reposotories.AppointmentRepository;
import dev.enegadi.jeetp3.Reposotories.ConsultationRepository;
import dev.enegadi.jeetp3.Reposotories.DoctorRepository;
import dev.enegadi.jeetp3.Reposotories.PatientRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class HospitalServiceImpl implements IHospitalService {
    private PatientRepository patientRepository;
    private DoctorRepository doctorRepository;
    private ConsultationRepository consultationRepository;
    private AppointmentRepository appointmentRepository;

    public HospitalServiceImpl(PatientRepository patientRepository, DoctorRepository doctorRepository, ConsultationRepository consultationRepository, AppointmentRepository appointmentRepository) {
        this.patientRepository = patientRepository;
        this.doctorRepository = doctorRepository;
        this.consultationRepository = consultationRepository;
        this.appointmentRepository = appointmentRepository;
    }

    @Override
    public Doctor saveDoctor(Doctor doctor) {
        return doctorRepository.save(doctor);
    }

    @Override
    public Doctor getDoctorById(Long id) {
        return doctorRepository.findById(id).orElse(null);
    }

    @Override
    public List<Doctor> getAllDoctors() {
        return doctorRepository.findAll();
    }

    @Override
    public Patient savePatient(Patient patient) {
        return patientRepository.save(patient);
    }

    @Override
    public Patient getPatientById(Long id) {
        return patientRepository.findById(id).orElse(null);
    }

    @Override
    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    @Override
    public Appointment saveAppointment(Appointment appointment) {
        return appointmentRepository.save(appointment);
    }

    @Override
    public Appointment getAppointmentById(Long id) {
        return appointmentRepository.findById(id).orElse(null);
    }

    @Override
    public List<Appointment> getAllAppointments() {
        return appointmentRepository.findAll();
    }


    @Override
    public Consultation saveConsultation(Consultation consultation) {
        return consultationRepository.save(consultation);
    }

    @Override
    public Consultation getConsultationById(Long id) {
        return consultationRepository.findById(id).orElse(null);
    }

    @Override
    public List<Consultation> getAllConsultations() {
        return consultationRepository.findAll();
    }
}
