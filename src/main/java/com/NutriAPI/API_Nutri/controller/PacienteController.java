package com.NutriAPI.API_Nutri.controller;

import com.NutriAPI.API_Nutri.model.PacienteModel;
import com.NutriAPI.API_Nutri.services.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping//endpoint
@CrossOrigin(origins = {"http://localhost:3000", "http://10.0.2.2:3000"})
public class PacienteController {

    @Autowired
    private PacienteService pacienteService;


    @GetMapping("/hello-world")
    public String helloword(){
        return pacienteService.hello("Mateus");
    }
    @GetMapping("/listarUsuarios")
    public ResponseEntity<List<PacienteModel>> listarTodosUsuarios() {
        try {
            List<PacienteModel> pacientes = pacienteService.listarUsuarios();
            return ResponseEntity.ok(pacientes);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }


    @GetMapping("/cpf/{cpf}")
    public ResponseEntity<PacienteModel> buscarUsuarioCpf(@PathVariable String cpf) {
        try {
            Optional<PacienteModel> paciente = pacienteService.buscarPorCpf(cpf);
            if (paciente.isPresent()) {
                return ResponseEntity.ok(paciente.get());
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @PostMapping("/cadastro")
    public ResponseEntity<PacienteModel> cadastrarUsuario(@RequestBody PacienteModel paciente) {
        try {
            PacienteModel novoPaciente = pacienteService.cadastrarUsuario(paciente);
            return new ResponseEntity<>(novoPaciente, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @DeleteMapping("/cpf/{cpf}")
    public ResponseEntity<String> deletarPacientePorCpf(@PathVariable String cpf) {
        String pacienteDeletado = pacienteService.deletarPacienteCpf(cpf);

        if (pacienteDeletado.contains("deletado")) {
            return new ResponseEntity<>(pacienteDeletado, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(pacienteDeletado, HttpStatus.NOT_FOUND);
        }
    }

    @PatchMapping("/paciente/{cpf}")
    public ResponseEntity<String> atualizarCamposPaciente(@PathVariable String cpf, @RequestBody PacienteModel novosDados) {
        String mensagem = pacienteService.atualizarCamposPaciente(cpf, novosDados);
        if (mensagem.contains("atualizados")) {
            return ResponseEntity.ok(mensagem);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(mensagem);
        }
    }
    /* @PostMapping("/login")
   public ResponseEntity<String> login(@RequestBody PacienteModel credenciais) {
        try {
            String token = pacienteService.autenticarUsuario(credenciais.getCpf(), credenciais.getSenha());
            return ResponseEntity.ok("Bearer " + token);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
        }
    }*/

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody Map<String, String> loginData) {
        try {
            String email = loginData.get("email");
            String senha = loginData.get("senha");
            Optional<PacienteModel> pacienteOpt = pacienteService.buscarPorEmail(email);
            if (pacienteOpt.isPresent()) {
                PacienteModel paciente = pacienteOpt.get();
                if (paciente.getSenha().equals(senha)) {
                    return ResponseEntity.ok("Login realizado com sucesso!");
                } else {
                    return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Senha incorreta.");
                }
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuário não encontrado.");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao realizar login.");
        }
    }


    //@PathVariable
    //@RequestParam

}
