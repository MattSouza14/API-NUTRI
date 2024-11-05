package com.NutriAPI.API_Nutri.repositories;

import com.NutriAPI.API_Nutri.models.Consulta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ConsultaRepository extends JpaRepository<Consulta, Long> {

    List<Consulta> findByIdPaciente(Long idPaciente);
}
