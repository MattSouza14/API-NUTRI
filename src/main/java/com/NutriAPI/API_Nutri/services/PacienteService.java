package com.NutriAPI.API_Nutri.services;


import org.springframework.stereotype.Service;
import com.NutriAPI.API_Nutri.model.PacienteModel;
import com.NutriAPI.API_Nutri.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;


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
   // private BCryptPasswordEncoder bCryptPassword;

    public PacienteModel cadastrarUsuario(PacienteModel paciente) {
        return (PacienteModel) usuarioRepository.save(paciente);
    }
    /*public PacienteModel cadastrarUsuario(PacienteModel paciente) {
       // String senhaCriptografada = bCryptPassword.encode(paciente.getSenha());
       // paciente.setSenha(senhaCriptografada);

        return usuarioRepository.save(paciente);
    }*/


   /* private JwtUtil jwtUtil;

    public String autenticarUsuario(String cpf, String senha) {
        Optional<PacienteModel> paciente = usuarioRepository.findByCpf(cpf);
        if (paciente.isPresent() && bCryptPassword.matches(senha, paciente.get().getSenha())) {
            return jwtUtil.gerarToken(paciente.get().getCpf());
        } else {
            throw new RuntimeException("Credenciais inválidas.");
        }
    }*/

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
    public String atualizarCamposPaciente(String cpf, PacienteModel novosDados) {
        Optional<PacienteModel> pacienteExistente = usuarioRepository.findByCpf(cpf);

        if (pacienteExistente.isPresent()) {
            PacienteModel paciente = pacienteExistente.get();

            if (novosDados.getNome() != null) {
                paciente.setNome(novosDados.getNome());
            }
            if (novosDados.getCpf() != null) {
                paciente.setCpf(novosDados.getCpf());
            }
            if (novosDados.getGenero() != null) {
                paciente.setGenero(novosDados.getGenero());
            }
            if (novosDados.getAltura() != null) {
                paciente.setAltura(novosDados.getAltura());
            }
            if (novosDados.getPeso() != null) {
                paciente.setPeso(novosDados.getPeso());
            }
            if (novosDados.getEmail() != null) {
                paciente.setEmail(novosDados.getEmail());
            }
            if (novosDados.getTelefone() != null) {
                paciente.setTelefone(novosDados.getTelefone());
            }
            if (novosDados.getSenha() != null) {
                paciente.setSenha(novosDados.getSenha());
            }
            usuarioRepository.save(paciente);
            return "Campos atualizados para o paciente com CPF " + cpf + ".";
        } else {
            return "Paciente com CPF " + cpf + " não encontrado.";
        }
    }



    }

