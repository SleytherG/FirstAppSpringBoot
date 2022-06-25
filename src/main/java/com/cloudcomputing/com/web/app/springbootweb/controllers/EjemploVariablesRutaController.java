package com.cloudcomputing.com.web.app.springbootweb.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/variables")
public class EjemploVariablesRutaController {

    @GetMapping(value = "/")
    public String index(Model model) {
        model.addAttribute("titulo", "Enviamos parametros de la ruta (@PathVariable)");
        return "variables/index";
    }

    @GetMapping(value = "/string/{texto}")
    public String variables(@PathVariable(name = "texto") String texto, Model model) {
        model.addAttribute("titulo", "Recibir parametros de la ruta (@PathVariable)");
        model.addAttribute("resultado", "El texto enviado en la ruta es: " + texto);
        return "variables/ver";
    }

    @GetMapping(value = "/string/{texto}/{numero}")
    public String variables(@PathVariable(name = "texto") String texto, @PathVariable(name = "numero") Integer numero, Model model) {
        model.addAttribute("titulo", "Recibir parametros de la ruta (@PathVariable)");
        model.addAttribute("texto", "El texto enviado en la ruta es: " + texto);
        model.addAttribute("numero", "El numero enviado en la ruta es: " + numero);
        return "variables/ver";
    }


}
