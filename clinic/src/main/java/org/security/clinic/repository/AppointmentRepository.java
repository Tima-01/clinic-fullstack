package org.security.clinic.repository;

import org.security.clinic.entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
    List<Appointment> findByDateBetween(LocalDate start, LocalDate end);
    List<Appointment> findByDoctorIdAndDateBetween(Long doctorId, LocalDate start, LocalDate end);
    List<Appointment> findByDoctorId(Long doctorId);

}
