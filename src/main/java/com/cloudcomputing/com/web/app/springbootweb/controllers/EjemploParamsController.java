package com.cloudcomputing.com.web.app.springbootweb.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(value = "/params")
public class EjemploParamsController {

    @GetMapping(value = "/")
    public String index(Model model) {
        model.addAttribute("titulo", "Enviamos parametros del Request HTTP GET - URL");
        return "params/index";
    }
    @GetMapping(value = "/string")
    public String param(@RequestParam(name = "texto", required = false, defaultValue = "Algun valor...") String texto, Model model) {
        model.addAttribute("titulo", "Recibir parametros del Request HTTP GET - URL");
        model.addAttribute("resultado", "El texto enviado es: " + texto);
        return "params/ver";
    }

    @GetMapping(value = "/mix-params")
    public String param(@RequestParam() String saludo,@RequestParam() Integer numero, Model model) {
        model.addAttribute("titulo", "Recibir parametros del Request HTTP GET - URL");
        model.addAttribute("resultado", "El saludo enviado es: '" + saludo + "' y el numero es: '" + numero + "'");
        return "params/ver";
    }

    @GetMapping(value = "/mix-params-request")
    public String param(HttpServletRequest request, Model model) {
        String saludo = request.getParameter("saludo");
        Integer numero = null;
        try {
            numero = Integer.parseInt(request.getParameter("numero"));
        } catch ( NumberFormatException e) {
            numero = 0;
        }
        model.addAttribute("titulo", "Recibir parametros del Request HTTP GET - URL");
        model.addAttribute("resultado", "El saludo enviado es: '" + saludo + "' y el numero es: '" + numero + "'");
        return "params/ver";
    }



}
