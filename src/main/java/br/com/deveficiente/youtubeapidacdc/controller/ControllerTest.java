package br.com.deveficiente.youtubeapidacdc.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerTest {
    @GetMapping(value = "/")
    public String teste(){
        return "Está configurado";
    }
}
