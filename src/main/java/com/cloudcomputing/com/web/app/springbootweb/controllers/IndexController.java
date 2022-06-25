package com.cloudcomputing.com.web.app.springbootweb.controllers;

import com.cloudcomputing.com.web.app.springbootweb.models.Usuario;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/app")
public class IndexController {

    /**
     * Pasar Datos desde el Controller a la vista HTML
     */
//    @RequestMapping(value = "/index", method = RequestMethod.GET)
//    @GetMapping(value = {"/index", "/", "/home"})
//    public String index(Model model)
//    public String index(ModelMap modelMap)
//    public String index(Map<String, Object> map)
//      public ModelAndView index(ModelAndView modelAndView){
//        model.addAttribute("titulo", "Hola Springboot Framework!");
//        modelMap.addAttribute("titulo", "Hola Springboot Framework!");
//        map.put("titulo", "Hola Springboot Framework con Map!");
//        modelAndView.addObject("titulo", "Hola Springboot Framework con ModelAndView!");
//        modelAndView.setViewName("index");
//        return modelAndView;
//    }
    @Value("${texto.indexcontroller.index.titulo}")
    private String textoIndex;
    @Value("${texto.indexcontroller.perfil.titulo}")
    private String textoPerfil;
    @Value("${texto.indexcontroller.listar.titulo}")
    private String textoListar;

    @GetMapping(value = {"/index", "/", "/home", ""} )
    public String index(Model model) {
        model.addAttribute("titulo", textoIndex);
        return "index";
    }

    @RequestMapping(value = "/perfil")
    public String perfil(Model model) {
        Usuario usuario = new Usuario();
        usuario.setNombre("Sleyther Giulio");
        usuario.setApellido("Calsin Pacsi");
        usuario.setEdad(26);
        usuario.setEmail("sleythergcp@gmail.com");
        model.addAttribute("titulo", textoPerfil);
        model.addAttribute("usuario", usuario);
        return "perfil";
    }

    @RequestMapping("/listar")
    public String listar(Model model) {

//        List<Usuario> usuarios = new ArrayList<>();
//        usuarios.add(new Usuario("Sleyther Giulio", "Calsin Pacsi", 26, "sgcp@gmail.com"));
//        usuarios.add(new Usuario("Edgar Fernando", "Calsin Pacsi", 19, "edgarfernandocalsinpacsi@gmail.com"));
//        usuarios.add(new Usuario("Edgar", "Calsin Humpiri", 56, "edgarcalsinhhumpiri@gmail.com"));

//        List<Usuario> usuarios = Arrays.asList(
//                new Usuario("Sleyther Giulio", "Calsin Pacsi", 26, "sgcp@gmail.com"),
//                new Usuario("Edgar Fernando", "Calsin Pacsi", 19, "edgarfernandocalsinpacsi@gmail.com"),
//                new Usuario("Edgar", "Calsin Humpiri", 56, "edgarcalsinhhumpiri@gmail.com")
//        );

        model.addAttribute("titulo", textoListar);
//        model.addAttribute("usuarios", usuarios);
        return "listar";
    }

    /**
     * Con este metodo podemos mostrar los usuarios en distintas vistas no solo en la vista "listar"
     */
    @ModelAttribute("usuarios")
    public List<Usuario> poblarUsuarios() {
        List<Usuario> usuarios = Arrays.asList(
                new Usuario("Sleyther Giulio", "Calsin Pacsi", 26, "sgcp@gmail.com"),
                new Usuario("Edgar Fernando", "Calsin Pacsi", 19, "edgarfernandocalsinpacsi@gmail.com"),
                new Usuario("Edgar", "Calsin Humpiri", 56, "edgarcalsinhhumpiri@gmail.com")
        );
        return usuarios;
    }
}