document.getElementById("locales").addEventListener("change", function () {
    const selectedLang = this.value;
    if (selectedLang) {
        window.location.href = window.location.pathname + "?lang=" + selectedLang;
    }
});

function botonClave (){

    let claveInput = document.getElementById('clave');
    let confirmarClaveInput = document.getElementById('confirmarClave');
    if (claveInput.type === 'password') {
        claveInput.type = 'text';
        confirmarClaveInput.type = 'text';
    } else {
        claveInput.type = 'password';
        confirmarClaveInput.type = 'password';
    }
}

// Función para deseleccionar géneros
// Función para deseleccionar géneros
function botonGeneros() {
    let generoRadio = document.getElementsByName('generoSeleccionado');
    for (let i = 0; i < generoRadio.length; i++) {
        generoRadio[i].checked = false;
    }
}

function botonMusicasDes() {
    let selMusica = document.getElementById('musicasSeleccionadas');
    for (let i = 0; i < selMusica.options.length; i++) {
        selMusica.options[i].selected = false;
    }
}

function botonMusicasSel() {
    let selMusica = document.getElementById('musicasSeleccionadas');
    for (let i = 0; i < selMusica.options.length; i++) {
        selMusica.options[i].selected = true;
    }
}

function botonAficionesDes(){
    for (let i=0; i< document.getElementsByName('aficionesSeleccionadas').length;i++){
        document.getElementsByName('aficionesSeleccionadas')[i].checked=false;
    }
}

function botonAficionesSel(){
    for (let i=0; i< document.getElementsByName('aficionesSeleccionadas').length;i++){
        document.getElementsByName('aficionesSeleccionadas')[i].checked=true;
    }
}
