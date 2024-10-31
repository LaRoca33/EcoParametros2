package org.aaroca.ecoparametros2.controller;

import org.aaroca.ecoparametros2.model.Colecciones;
import org.aaroca.ecoparametros2.model.DatosFormulario;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Map;

@Controller
@RequestMapping("formulario")
public class PrincipalController {

    @GetMapping("hola-mundo")
    @ResponseBody
    public String holaMundo() {
        return "Hola mundo";
    }




    @GetMapping("imprime-parametros")
    @ResponseBody
    public String formPost(@RequestParam Map<String,String> allParams) {
        return "Parametros: "+allParams.entrySet();
    }
    @GetMapping("devuelve-formulario")
    public String form(Model modelo) {
        modelo.addAttribute("generos",Colecciones.getGeneros());
        modelo.addAttribute("paises", Colecciones.getPaises());
        modelo.addAttribute("aficiones", Colecciones.getAficiones());
        modelo.addAttribute("musicas", Colecciones.getMusicas());
        return "form";
    }
    @PostMapping("recibe-parametros")
    public String recibeParams(
            @RequestParam(required = false)String  usuario,
            @RequestParam(required = false)String  clave,
            @RequestParam(required = false) ArrayList<String> aficiones,
            @RequestParam(required = false)String  genero,
            @RequestParam(required = false)String  comentarios,
            Model modelo
            ) {
        modelo.addAttribute("generos",Colecciones.getGeneros());
        modelo.addAttribute("paises", Colecciones.getPaises());
        modelo.addAttribute("aficiones", Colecciones.getAficiones());
        modelo.addAttribute("musicas", Colecciones.getMusicas());
      //  modelo.addAttribute("paises",paises);
        modelo.addAttribute("usuario",usuario);
        modelo.addAttribute("clave",clave);
      //  modelo.addAttribute("aficiones",aficiones);
        modelo.addAttribute("genero",genero);
        modelo.addAttribute("comentarios",comentarios);
        return "form";
    }
}