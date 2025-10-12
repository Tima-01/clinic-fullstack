package org.security.clinic.service;
import org.security.clinic.entity.MedicalRecord;
import org.security.clinic.entity.ServiceProcedure;
import org.security.clinic.repository.AppointmentRepository;
import org.security.clinic.repository.DoctorRepository;
import org.security.clinic.repository.MedicalRecordRepository;
import org.security.clinic.repository.ServiceProcedureRepository;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class ReportService {

    private final AppointmentRepository appointmentRepo;
    private final DoctorRepository doctorRepo;
    private final MedicalRecordRepository recordRepo;
    private final ServiceProcedureRepository serviceRepo;

    public ReportService(AppointmentRepository appointmentRepo,
                         DoctorRepository doctorRepo,
                         MedicalRecordRepository recordRepo,
                         ServiceProcedureRepository serviceRepo) {
        this.appointmentRepo = appointmentRepo;
        this.doctorRepo = doctorRepo;
        this.recordRepo = recordRepo;
        this.serviceRepo = serviceRepo;
    }

    // 1️⃣ Приемы по врачам
    public Map<String, Long> getAppointmentsByDoctor() {
        return appointmentRepo.findAll().stream()
                .collect(Collectors.groupingBy(a -> a.getDoctor().getFullName(), Collectors.counting()));
    }

    // 2️⃣ Финансовый отчет по услугам
    public Map<String, Double> getFinanceReport() {
        return serviceRepo.findAll().stream()
                .collect(Collectors.toMap(ServiceProcedure::getName, ServiceProcedure::getPrice));
    }

    // 3️⃣ Статистика заболеваний
    public Map<String, Long> getDiseaseStats() {
        return recordRepo.findAll().stream()
                .collect(Collectors.groupingBy(MedicalRecord::getDiagnosis, Collectors.counting()));
    }

    // 4️⃣ Загрузка врачей
    public Map<String, Long> getDoctorLoad() {
        return appointmentRepo.findAll().stream()
                .collect(Collectors.groupingBy(a -> a.getDoctor().getFullName(), Collectors.counting()));
    }
}
