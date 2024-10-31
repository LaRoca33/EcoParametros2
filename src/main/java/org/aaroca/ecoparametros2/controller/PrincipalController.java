package org.aaroca.ecoparametros2.controller;

import org.aaroca.ecoparametros2.model.Colecciones;
import org.aaroca.ecoparametros2.model.DatosFormulario;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Map;

@Controller
public class PrincipalController {

    @GetMapping("hola-mundo")
    @ResponseBody
    public String holaMundo() {
        return "Hola mundo";
    }


    @GetMapping("devuelve-formulario")
    public String form(Model modelo) {
        modelo.addAttribute("generos",Colecciones.getGeneros());
        modelo.addAttribute("paises", Colecciones.getPaises());
        return "ecoParametros";
    }

    @GetMapping("imprime-parametros")
    @ResponseBody
    public String formPost(@RequestParam Map<String,String> allParams) {
        return "Parametros: "+allParams.entrySet();
    }
    @GetMapping("recibe-parametros")
    public String recibeParams(
            @RequestParam(required = false)String  nombre,
            @RequestParam(required = false)String  clave,
            @RequestParam(required = false) ArrayList<String> aficiones,
            @RequestParam(required = false)String  genero,
            @RequestParam(required = false)String  comentarios,
            Model modelo
            ) {
        modelo.addAttribute("generos",Colecciones.getGeneros());
        modelo.addAttribute("paises", Colecciones.getPaises());
      //  modelo.addAttribute("paises",paises);
        modelo.addAttribute("nombre",nombre);
        modelo.addAttribute("clave",clave);
        modelo.addAttribute("aficiones",aficiones);
        modelo.addAttribute("genero",genero);
        modelo.addAttribute("comentarios",comentarios);
        return "ecoParametros";
    }
}