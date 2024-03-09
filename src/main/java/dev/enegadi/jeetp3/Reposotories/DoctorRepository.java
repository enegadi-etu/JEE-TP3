package dev.enegadi.jeetp3.Reposotories;

import dev.enegadi.jeetp3.Entities.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {
}
