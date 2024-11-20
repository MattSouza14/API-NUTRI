package com.NutriAPI.API_Nutri.repository;
import com.NutriAPI.API_Nutri.model.PacienteModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PacienteRepository  extends  JpaRepository<PacienteModel, Long>{


    Optional<PacienteModel> findByCpf(String cpf);

    Optional<PacienteModel> findByEmail(String email);


}
