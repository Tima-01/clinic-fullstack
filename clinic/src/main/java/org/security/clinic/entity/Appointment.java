package org.security.clinic.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class Appointment {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    private Patient patient;

    @ManyToOne(optional = false)
    private Doctor doctor;

//    @ManyToOne
//    private ServiceProcedure serviceProcedure; // опционально

    private LocalDate date;
    private LocalTime time;
    private String status; // Запланировано, Завершено, Отменено
}
