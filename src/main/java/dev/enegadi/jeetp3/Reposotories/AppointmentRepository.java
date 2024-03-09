package dev.enegadi.jeetp3.Reposotories;

import dev.enegadi.jeetp3.Entities.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
}
