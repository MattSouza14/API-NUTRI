package com.NutriAPI.API_Nutri.services;

import org.springframework.stereotype.Service;
import com.NutriAPI.API_Nutri.model.PacienteModel;
import com.NutriAPI.API_Nutri.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
//import java.util.List;

@Service
public class PacienteService {

    public String hello(String name) {
        return "Hello " + name;
    }

    @Autowired
    private PacienteRepository usuarioRepository;

    public PacienteModel cadastrarUsuario(PacienteModel paciente) {
        return (PacienteModel) usuarioRepository.save(paciente);
    }

    public List<PacienteModel> listarUsuarios() {
        return usuarioRepository.findAll();
    }

    public Optional<PacienteModel> buscarPorCpf(String cpf) {
        return usuarioRepository.findByCpf(cpf);
    }

    public String deletarPacienteCpf(String cpf) {
        Optional<PacienteModel> paciente = usuarioRepository.findByCpf(cpf);
        if (paciente.isPresent()) {
            usuarioRepository.delete(paciente.get());
            return "Paciente com CPF " + cpf + " deletado com sucesso.";
        } else {
            return "Paciente com CPF " + cpf + " não encontrado.";
        }
    }


    }

