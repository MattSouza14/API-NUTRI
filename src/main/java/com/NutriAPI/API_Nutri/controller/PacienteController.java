package com.NutriAPI.API_Nutri.controller;

import com.NutriAPI.API_Nutri.services.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hello-world")
public class PacienteController {

    @Autowired
    private PacienteService pacienteService;


    @GetMapping//Get/hello-world
    public String helloword(){
        return pacienteService.hello("Mateus");
    }


   // @PostMapping
   // public String helloPost(@RequestBody String name){
    //    return pacienteService.hello(name);
    //}
    //@PathVariable
    //@RequestParam

}
