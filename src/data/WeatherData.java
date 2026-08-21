package data;

import observer.Observer;
import observer.Subject;

import java.util.ArrayList;
import java.util.List;

/**
 * WeatherData es el ConcreteSubject del patrón Observer.
 *
 * Mantiene las mediciones actuales (temperatura, humedad, presión) y
 * una lista de observadores suscritos. Cada vez que llegan nuevas
 * mediciones (measurementsChanged), se notifica automáticamente a
 * TODOS los observadores registrados, cumpliendo la exigencia:
 * "Cada vez que las condiciones cambian, todos los suscriptores
 * deben ser notificados del cambio".
 *
 * Nótese que WeatherData NO conoce las clases concretas de los
 * displays (CurrentConditionsDisplay, StatisticsDisplay, etc.):
 * solo conoce la interfaz Observer. Esto resuelve exactamente los
 * problemas detectados en el "Sharpen your pencil" del enunciado
 * (A, B, C, D, E, F): ya no se codifica contra implementaciones
 * concretas, los displays se pueden agregar/quitar en tiempo de
 * ejecución, y se respeta la encapsulación de WeatherData.
 */
public class WeatherData implements Subject {

    private final List<Observer> observers;
    private float temperature;
    private float humidity;
    private float pressure;

    public WeatherData() {
        this.observers = new ArrayList<>();
    }

    // ---------- Implementación de Subject ----------

    @Override
    public void registerObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(temperature, humidity, pressure);
        }
    }

    // ---------- Lógica propia de WeatherData ----------

    /**
     * Se invoca cada vez que la estación meteorológica obtiene nuevas
     * mediciones desde los sensores. Notifica a todos los observadores.
     */
    public void measurementsChanged() {
        notifyObservers();
    }

    /**
     * Método de conveniencia usado por Weather-O-Rama (o por pruebas)
     * para simular la llegada de nuevas mediciones desde los sensores.
     */
    public void setMeasurements(float temperature, float humidity, float pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        measurementsChanged();
    }

    // ---------- Getters (datos encapsulados) ----------

    public float getTemperature() {
        return temperature;
    }

    public float getHumidity() {
        return humidity;
    }

    public float getPressure() {
        return pressure;
    }
}
