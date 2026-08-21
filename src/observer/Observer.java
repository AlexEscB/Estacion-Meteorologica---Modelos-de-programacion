package observer;

/**
 * Interfaz Observer (Suscriptor) del patrón Observer.
 *
 * Todo objeto que quiera ser notificado de cambios en un Subject debe
 * implementar esta interfaz. El método update() es llamado por el
 * Subject cada vez que su estado cambia, pasándole los datos más
 * recientes (temperatura, humedad, presión).
 *
 * Nota de diseño: se usa "push" (el Subject empuja los datos como
 * parámetros de update) en vez de "pull" (el observador consulta al
 * Subject). Esto desacopla completamente al observador de los
 * getters internos del Subject.
 */
public interface Observer {

    /**
     * Llamado por el Subject cuando sus mediciones cambian.
     *
     * @param temperature temperatura actual (°C)
     * @param humidity    humedad relativa actual (%)
     * @param pressure    presión barométrica actual (hPa)
     */
    void update(float temperature, float humidity, float pressure);
}
