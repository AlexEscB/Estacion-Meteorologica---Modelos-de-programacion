package observer;

/**
 * Interfaz DisplayElement.
 *
 * Todos los elementos de visualización (displays) deben implementarla.
 * Esto es independiente de Observer: un display ES-UN Observer (para
 * poder recibir datos) y también ES-UN DisplayElement (para poder
 * mostrarse en pantalla), pero ambas responsabilidades están separadas
 * en interfaces distintas (principio de segregación de interfaces).
 *
 * Gracias a esta interfaz común, cualquier desarrollador externo
 * (ver ThirdPartyDisplay en el enunciado) puede crear su propio
 * display implementando Observer + DisplayElement, sin tocar el
 * código de WeatherData.
 */
public interface DisplayElement {

    /**
     * Muestra en pantalla (o consola, en esta implementación) el
     * contenido actual del display.
     */
    void display();
}
