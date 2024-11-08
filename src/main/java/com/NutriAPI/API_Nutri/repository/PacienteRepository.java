package com.NutriAPI.API_Nutri.repository;
import com.NutriAPI.API_Nutri.model.PacienteModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface PacienteRepository  extends  JpaRepository<PacienteModel, Long>{



}
