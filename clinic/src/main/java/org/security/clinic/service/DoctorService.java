package org.security.clinic.service;

import org.security.clinic.entity.Doctor;
import org.security.clinic.repository.DoctorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorService {
    private final DoctorRepository doctorRepostory;

    public DoctorService(DoctorRepository doctorRepostory) {
        this.doctorRepostory = doctorRepostory;
    }

    public List<Doctor> getAll() {
        return doctorRepostory.findAll();
    }

    public Doctor getById(Long id) {
        return doctorRepostory.findById(id).orElse(null);
    }

    public Doctor create(Doctor doctor) {
        return doctorRepostory.save(doctor);
    }

    public Doctor update(Long id,Doctor updated) {
        return doctorRepostory.findById(id)
                .map(d-> {
                    d.setFullName(updated.getFullName());
                    d.setSpecialization(updated.getSpecialization());
                    d.setLicenseNumber(updated.getLicenseNumber());
                    d.setWorkSchedule(updated.getWorkSchedule());
                    return doctorRepostory.save(d);
                }).orElse(null);
    }
    public void delete(Long id) {
        doctorRepostory.deleteById(id);
    }
}
