package org.security.clinic.service;


import org.security.clinic.entity.Patient;
import org.security.clinic.repository.PatientRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {
    private final PatientRepository patientRepository;

    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public List<Patient> getAll() {
        return patientRepository.findAll();
    }

    public Patient getById(Long id) {
        return patientRepository.findById(id).get();
    }

    public Patient create(Patient patient) {
        return patientRepository.save(patient);
    }

    public Patient update(Long id, Patient updated) {

        return patientRepository.findById(id)
                .map(p -> {
                    p.setFullName(updated.getFullName());
                    p.setGender(updated.getGender());
                    p.setBirthDate(updated.getBirthDate());
                    p.setGender(updated.getGender());
                    return patientRepository.save(p);
                })
                .orElse(null);
    }

    public void delete(Long id) {
        patientRepository.deleteById(id);
    }
}
