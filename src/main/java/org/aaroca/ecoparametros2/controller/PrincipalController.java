package org.aaroca.ecoparametros2.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.aaroca.ecoparametros2.model.Colecciones;
import org.aaroca.ecoparametros2.model.DatosFormulario;
import org.aaroca.ecoparametros2.model.Pais;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

@Controller
@RequestMapping("formulario") // Define la URL base /formulario para los métodos de este controlador
public class PrincipalController extends Colecciones {

    // Carga un mapa de opciones de música en el modelo
    @ModelAttribute("musicas")
    private Map<String, String> devuelveListaMusicas() {
        return Colecciones.getMusicas();
    }

    // Carga un mapa de opciones de países en el modelo
    @ModelAttribute("paises")
    private Map<String, Pais> devuelveListaPaises() {
        return Colecciones.getPaises();
    }

    // Carga un mapa de opciones de géneros en el modelo
    @ModelAttribute("generos")
    private Map<String, String> devuelveListaGeneros() {
        return Colecciones.getGeneros();
    }

    // Carga un mapa de opciones de aficiones en el modelo
    @ModelAttribute("aficiones")
    private Map<String, String> devuelveListaAficiones() {
        return Colecciones.getAficiones();
    }

    // Método de prueba que devuelve "Hola mundo" en texto
    @GetMapping("hola-mundo")
    @ResponseBody
    public String holaMundo() {
        return "Hola mundo";
    }

    // Método para mostrar todos los parámetros recibidos en la URL
    @GetMapping("imprime-parametros")
    @ResponseBody
    public String formPost(@RequestParam Map<String, String> allParams) {
        return "Parametros: " + allParams.entrySet();
    }


    @GetMapping("devuelve-formulario")
    public String form(Model modelo, HttpServletRequest request) {
        // Datos del formulario por defecto
        DatosFormulario formulario = new DatosFormulario();
        formulario.setUsuario("Lola");
        formulario.setPaisSeleccionado("pt");
        formulario.setPrefijoTelefonico("33");
        formulario.setMusicasSeleccionadas(Arrays.asList("F", "R"));
        formulario.setAficionesSeleccionadas(Arrays.asList("D", "P", "V"));
        modelo.addAttribute("formulario", formulario);
        modelo.addAttribute("titulo", "Original"); // Texto inicial del título
        modelo.addAttribute("iteraciones", 1);    // Inicialización de contador de iteraciones

        // Información de las cabeceras HTTP
        String direccionIp = request.getHeader("X-Forwarded-For");
        // Intenta obtener la dirección IP del cliente desde la cabecera "X-Forwarded-For", que es usada por proxies.

        if (direccionIp == null || direccionIp.isEmpty()) {
            // Verifica si la cabecera está vacía o no existe.

            direccionIp = request.getRemoteAddr();
            // Si no existe la cabecera, obtiene la dirección IP directamente de la solicitud.

            if (direccionIp.equals("0:0:0:0:0:0:0:1")) {
                // Si la dirección IP es "::1" (IPv6 para localhost), la reemplaza por "127.0.0.1" (IPv4 para localhost).
                direccionIp = "127.0.0.1";
            }
        }

        if (direccionIp == null || direccionIp.isEmpty()) {
            // Si la dirección IP sigue siendo nula o vacía, intenta obtenerla de nuevo desde la solicitud.
            direccionIp = request.getRemoteAddr();
        }

        String userAgent = request.getHeader("User-Agent");
        // Obtiene la cabecera "User-Agent", que contiene información sobre el navegador y sistema operativo del cliente.

        String navegador = "Desconocido";
        // Inicializa la variable `navegador` como "Desconocido".

        String sistemaOperativo = "Desconocido";
        // Inicializa la variable `sistemaOperativo` como "Desconocido".

        String motorRenderizado = "Desconocido";
        // Inicializa la variable `motorRenderizado` como "Desconocido".

        if (userAgent != null) {
            // Verifica si la cabecera "User-Agent" no es nula.

            // Identificar sistema operativo
            if (userAgent.contains("Windows")) sistemaOperativo = "Windows";
                // Si el User-Agent contiene "Windows", se asume que el sistema operativo es Windows.

            else if (userAgent.contains("Mac")) sistemaOperativo = "MacOS";
                // Si contiene "Mac", se asume que es MacOS.

            else if (userAgent.contains("Linux")) sistemaOperativo = "Linux";
            // Si contiene "Linux", se asume que es Linux.

            // Identificar navegador
            if (userAgent.contains("Chrome")) navegador = "Chrome";
                // Si contiene "Chrome", se asume que el navegador es Google Chrome.

            else if (userAgent.contains("Firefox")) navegador = "Firefox";
                // Si contiene "Firefox", se asume que es Mozilla Firefox.

            else if (userAgent.contains("Safari")) navegador = "Safari";
            // Si contiene "Safari", se asume que es Safari.

            // Identificar motor de renderizado
            if (userAgent.contains("WebKit")) motorRenderizado = "WebKit";
                // Si contiene "WebKit", se identifica este motor de renderizado.

            else if (userAgent.contains("Gecko") && !userAgent.contains("WebKit")) motorRenderizado = "Gecko";
                // Si contiene "Gecko" pero no "WebKit", el motor es Gecko.

            else if (userAgent.contains("Trident")) motorRenderizado = "Trident";
                // Si contiene "Trident", el motor es Trident (usado en Internet Explorer).

            else if (userAgent.contains("EdgeHTML")) motorRenderizado = "EdgeHTML";
            // Si contiene "EdgeHTML", el motor es EdgeHTML (usado en versiones antiguas de Microsoft Edge).
        }

        String idioma = request.getLocale().toString();
        // Obtiene el idioma y la configuración regional preferidos por el cliente.

        String nombreHost = request.getServerName();
        // Obtiene el nombre del host solicitado por el cliente (como "localhost").

        // Agregar datos de cabecera HTTP al modelo
        modelo.addAttribute("direccionIp", direccionIp);
        modelo.addAttribute("navegador", navegador);
        modelo.addAttribute("sistemaOperativo", sistemaOperativo);
        modelo.addAttribute("motorRenderizado", motorRenderizado);
        modelo.addAttribute("nombreHost", nombreHost);


        modelo.addAttribute("idioma", idioma);
        // Añade el idioma y configuración regional al modelo.



        return "formulario";
        // Devuelve el nombre de la vista "formulario", que se encargará de renderizar el contenido.
    }

    @PostMapping("recibe-parametros")
    public String recibeParametrosObjeto( Model modelo ,@RequestParam(required = false, defaultValue = "1") int iteraciones
            , @Valid @ModelAttribute("formulario") DatosFormulario formulario,
                                          BindingResult result){

        boolean errores=false;

        if(result.hasErrors()){
            errores=true;

        }
        modelo.addAttribute("titulo", "Repintado"); // Cambia el título al repintar
        modelo.addAttribute("iteraciones", iteraciones + 1); // Incrementa el contador de iteraciones
        modelo.addAttribute("errores", errores);

        System.out.println("Repintando formulario");

        return "formulario";
    }





/*
    // Recibe y procesa parámetros enviados desde el formulario
    @PostMapping("recibe-parametros")
    public String recibeParams(
            @RequestParam(required = false) String usuario,
            @RequestParam(required = false) String clave,
            @RequestParam(required = false) ArrayList<String> aficiones_seleccionadas,
            @RequestParam(required = false) String genero_seleccionado,
            @RequestParam(required = false) String pais_seleccionado,
            @RequestParam(required = false) ArrayList<String> musicas_seleccionadas,
            @RequestParam(required = false) String comentarios,
            @RequestParam(required = false) String archivo, // Campo de archivo
            @RequestParam(required = false, defaultValue = "1") int iteraciones, // Valor predeterminado para iteración
            Model modelo
    ) {

        // Agregar campos recibidos al modelo para repintado en la vista
        modelo.addAttribute("usuario", usuario);
        modelo.addAttribute("clave", clave);
        modelo.addAttribute("aficionesSeleccionadas", aficiones_seleccionadas);
        modelo.addAttribute("generoSeleccionado", genero_seleccionado);
        modelo.addAttribute("paisSeleccionado", pais_seleccionado);
        modelo.addAttribute("musicasSeleccionadas", musicas_seleccionadas);
        modelo.addAttribute("comentarios", comentarios);

        // Procesa y agrega el archivo al modelo si se ha enviado
        if (archivo != null && !archivo.isEmpty()) {
            modelo.addAttribute("nombreArchivo", archivo);
        } else {
            modelo.addAttribute("nombreArchivo", "No se ha seleccionado ningún archivo");
        }

        // Cuenta los parámetros recibidos que no están vacíos o nulos
        int contadorParametrosRecibidos = 0;
        if (usuario != null && !usuario.equals(" ")) contadorParametrosRecibidos++;
        if (clave != null && !clave.equals(" ")) contadorParametrosRecibidos++;
        if (aficiones_seleccionadas != null && !aficiones_seleccionadas.isEmpty()) contadorParametrosRecibidos++;
        if (genero_seleccionado != null) contadorParametrosRecibidos++;
        if (pais_seleccionado != null) contadorParametrosRecibidos++;
        if (musicas_seleccionadas != null && !musicas_seleccionadas.isEmpty()) contadorParametrosRecibidos++;
        if (comentarios != null && !comentarios.equals(" ")) contadorParametrosRecibidos++;
        if (archivo != null && !archivo.isEmpty()) contadorParametrosRecibidos++;

        // Agrega la cantidad de parámetros recibidos al modelo
        modelo.addAttribute("contadorParametrosRecibidos", contadorParametrosRecibidos);
        modelo.addAttribute("titulo", "Repintado"); // Cambia el título al repintar
        modelo.addAttribute("iteraciones", iteraciones + 1); // Incrementa el contador de iteraciones

        return "form"; // Retorna la misma vista para renderizar el formulario nuevamente
    }

 */

    // Método para manejar solicitudes a favicon.ico y devolver una respuesta vacía
    @GetMapping("favicon.ico")
    @ResponseBody
    public void returnNoFavicon() {
        // No hace nada; evita errores de solicitud de favicon
    }

}
