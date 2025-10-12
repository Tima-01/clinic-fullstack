package org.security.clinic.service;

import org.security.clinic.entity.ServiceProcedure;
import org.security.clinic.repository.ServiceProcedureRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceProcedureService {
    private final ServiceProcedureRepository repository;

    public ServiceProcedureService(ServiceProcedureRepository repository) {
        this.repository = repository;
    }

    public List<ServiceProcedure> getAll() {
        return repository.findAll();
    }

    public ServiceProcedure getById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public ServiceProcedure create(ServiceProcedure service) {
        return repository.save(service);
    }

    public ServiceProcedure update(Long id, ServiceProcedure updated) {
        return repository.findById(id)
                .map(s -> {
                    s.setName(updated.getName());
                    s.setPrice(updated.getPrice());
                    s.setDurationMinutes(updated.getDurationMinutes());
                    return repository.save(s);
                })
                .orElse(null);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
