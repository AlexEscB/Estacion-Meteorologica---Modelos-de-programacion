package observer;

/**
 * Interfaz Subject (Sujeto/Publisher) del patrón Observer.
 *
 * Cualquier clase que "publique" cambios de estado debe implementar
 * esta interfaz. Le da al Subject un contrato común para:
 *   - registrar observadores,
 *   - eliminar observadores,
 *   - notificar a todos los observadores registrados.
 *
 * En el caso de estudio, ConcreteSubject = WeatherData.
 */
public interface Subject {

    /**
     * Registra (suscribe) un nuevo observador para que reciba notificaciones.
     * @param o el observador a registrar
     */
    void registerObserver(Observer o);

    /**
     * Elimina (desuscribe) un observador; deja de recibir notificaciones.
     * @param o el observador a remover
     */
    void removeObserver(Observer o);

    /**
     * Notifica a todos los observadores registrados de que el estado
     * del Subject ha cambiado.
     */
    void notifyObservers();
}
