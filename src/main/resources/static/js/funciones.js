document.getElementById("locales").addEventListener("change", function () {
    const selectedLang = this.value;
    if (selectedLang) {
        window.location.href = window.location.pathname + "?lang=" + selectedLang;
    }
});