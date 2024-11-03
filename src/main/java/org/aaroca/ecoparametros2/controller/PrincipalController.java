package org.aaroca.ecoparametros2.controller;

import org.aaroca.ecoparametros2.model.Colecciones;
import org.aaroca.ecoparametros2.model.DatosFormulario;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.Map;

@Controller
@RequestMapping("formulario")
public class PrincipalController extends Colecciones{
    @ModelAttribute("musicas")
    private Map<String,String> devuelveListaMusicas(){return Colecciones.getMusicas();}
    @ModelAttribute("paises")
    private Map<String,String> devuelveListaPaises(){return Colecciones.getPaises();}
    @ModelAttribute("generos")
    private Map<String,String> devuelveListaGeneros(){return Colecciones.getGeneros();}
    @ModelAttribute("aficiones")
    private Map<String,String> devuelveListaAficiones(){return Colecciones.getAficiones();}

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
        modelo.addAttribute("titulo", "Original"); // Se pasa el título "Original" en el primer renderizado
        modelo.addAttribute("iteraciones", 1);  // Inicializamos iteraciones en 1
        return "form";
    }
    @PostMapping("recibe-parametros")
    public String recibeParams(
            @RequestParam(required = false) String usuario,
            @RequestParam(required = false) String clave,
            @RequestParam(required = false) ArrayList<String> aficiones_seleccionadas,
            @RequestParam(required = false) String genero_seleccionado,
            @RequestParam(required = false) String pais_seleccionado,
            @RequestParam(required = false) ArrayList<String> musicas_seleccionadas,
            @RequestParam(required = false) String comentarios,
            @RequestParam(required = false) MultipartFile archivo, // Campo de archivo
            @RequestParam(required = false, defaultValue = "1") int iteraciones, // Campo de iteración
            Model modelo
    ) {
        // Añadir colecciones para listas desplegables y opciones del formulario
        modelo.addAttribute("generos", Colecciones.getGeneros());
        modelo.addAttribute("paises", Colecciones.getPaises());
        modelo.addAttribute("aficiones", Colecciones.getAficiones());
        modelo.addAttribute("musicas", Colecciones.getMusicas());

        // Agregar valores de los campos al modelo para repintado
        modelo.addAttribute("usuario", usuario);
        modelo.addAttribute("clave", clave);
        modelo.addAttribute("aficionesSeleccionadas", aficiones_seleccionadas);
        modelo.addAttribute("generoSeleccionado", genero_seleccionado);
        modelo.addAttribute("paisSeleccionado", pais_seleccionado);
        modelo.addAttribute("musicasSeleccionadas", musicas_seleccionadas);
        modelo.addAttribute("comentarios", comentarios);

        // Procesar el archivo
        if (archivo != null && !archivo.isEmpty()) {
            String nombreArchivo = archivo.getOriginalFilename();
            modelo.addAttribute("nombreArchivo", nombreArchivo);
        } else {
            modelo.addAttribute("nombreArchivo", "No se ha seleccionado ningún archivo");
        }

        // Contar los parámetros recibidos (excluyendo los nulos)
        int contadorParametrosRecibidos = 0;
        if (usuario != null) contadorParametrosRecibidos++;
        if (clave != null) contadorParametrosRecibidos++;
        if (aficiones_seleccionadas != null && !aficiones_seleccionadas.isEmpty()) contadorParametrosRecibidos++;
        if (genero_seleccionado != null) contadorParametrosRecibidos++;
        if (pais_seleccionado != null) contadorParametrosRecibidos++;
        if (musicas_seleccionadas != null && !musicas_seleccionadas.isEmpty()) contadorParametrosRecibidos++;
        if (comentarios != null) contadorParametrosRecibidos++;
        if (archivo != null && !archivo.isEmpty()) contadorParametrosRecibidos++; // Contar archivo si fue enviado

        modelo.addAttribute("contadorParametrosRecibidos", contadorParametrosRecibidos);
        modelo.addAttribute("titulo", "Repintado");
        // Incrementar el contador de iteraciones
        modelo.addAttribute("iteraciones", iteraciones + 1);

        return "form"; // Asegúrate de que esta vista coincide con el nombre del archivo HTML
    }

    //Redirigir las Solicitudes a favicon.ico a un Recurso Vacio
    @GetMapping("favicon.ico")
    @ResponseBody
    public void returnNoFavicon() {
        // No hace nada, devuelve una respuesta vacía
    }

}