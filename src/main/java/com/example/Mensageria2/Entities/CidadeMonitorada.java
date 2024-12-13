package com.example.Mensageria2.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.sql.Time;
import java.util.Date;

@Setter
@Getter
@Entity
public class CidadeMonitorada {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String descricao;
    private String estado;
    private String nivelSeveridade;
    private String nome;
    private String tipoEvento;

    private Double latitude = 0.0;
    private Double longitude = 0.0;

}

