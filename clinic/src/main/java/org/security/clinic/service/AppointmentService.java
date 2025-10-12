package org.security.clinic.service;

import org.security.clinic.entity.Appointment;
import org.security.clinic.repository.AppointmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppointmentService {
    private final AppointmentRepository repository;

    public AppointmentService(AppointmentRepository repository) {
        this.repository = repository;
    }

    public List<Appointment> getAll() {
        return repository.findAll();
    }

    public Appointment getById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Appointment create(Appointment appointment) {
        return repository.save(appointment);
    }

    public Appointment update(Long id, Appointment updated) {
        return repository.findById(id)
                .map(a -> {
                    a.setPatient(updated.getPatient());
                    a.setDoctor(updated.getDoctor());
                    a.setDate(updated.getDate());
                    a.setTime(updated.getTime());
                    a.setStatus(updated.getStatus());
                    return repository.save(a);
                })
                .orElse(null);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
