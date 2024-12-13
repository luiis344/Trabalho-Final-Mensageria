package com.example.Mensageria2.Persistence;

import com.example.Mensageria2.Entities.AlertaClimatico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlertaClimaticoRepository extends JpaRepository<AlertaClimatico, Long> {
}
