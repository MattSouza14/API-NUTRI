package com.NutriAPI.API_Nutri.controller;

import com.NutriAPI.API_Nutri.model.PacienteModel;
import com.NutriAPI.API_Nutri.services.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping//endpoint

public class PacienteController {

    @Autowired
    private PacienteService pacienteService;


    @GetMapping("/hello-world")
    public String helloword(){
        return pacienteService.hello("Mateus");
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


   // @PostMapping
   // public String helloPost(@RequestBody String name){
    //    return pacienteService.hello(name);
    //}
    //@PathVariable
    //@RequestParam

}
