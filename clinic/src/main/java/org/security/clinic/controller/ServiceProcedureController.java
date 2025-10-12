package org.security.clinic.controller;

import org.security.clinic.entity.ServiceProcedure;
import org.security.clinic.service.ServiceProcedureService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/services")
@CrossOrigin(origins = "http://localhost:3000")
public class ServiceProcedureController {

    private final ServiceProcedureService serviceProcedureService;

    public ServiceProcedureController(ServiceProcedureService serviceProcedureService) {
        this.serviceProcedureService = serviceProcedureService;
    }

    @GetMapping
    public List<ServiceProcedure> getAll() {
        return serviceProcedureService.getAll();
    }

    @GetMapping("/{id}")
    public ServiceProcedure getById(@PathVariable Long id) {
        return serviceProcedureService.getById(id);
    }

    @PostMapping
    public ServiceProcedure create(@RequestBody ServiceProcedure service) {
        return serviceProcedureService.create(service);
    }

    @PutMapping("/{id}")
    public ServiceProcedure update(@PathVariable Long id, @RequestBody ServiceProcedure updated) {
        return serviceProcedureService.update(id, updated);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        serviceProcedureService.delete(id);
    }
}