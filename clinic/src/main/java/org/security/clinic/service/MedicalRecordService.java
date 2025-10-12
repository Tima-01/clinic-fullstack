package org.security.clinic.service;


import org.security.clinic.entity.MedicalRecord;
import org.security.clinic.repository.MedicalRecordRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicalRecordService {
    private final MedicalRecordRepository repository;

    public MedicalRecordService(MedicalRecordRepository repository) {
        this.repository = repository;
    }

    public List<MedicalRecord> getAll() {
        return repository.findAll();
    }

    public MedicalRecord getById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public MedicalRecord create(MedicalRecord record) {
        return repository.save(record);
    }

    public MedicalRecord update(Long id, MedicalRecord updated) {
        return repository.findById(id)
                .map(r -> {
                    r.setPatient(updated.getPatient());
                    r.setDiagnosis(updated.getDiagnosis());
                    r.setTreatment(updated.getTreatment());
                    r.setPrescriptions(updated.getPrescriptions());
                    return repository.save(r);
                })
                .orElse(null);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
