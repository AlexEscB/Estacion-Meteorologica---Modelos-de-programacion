package displays;

import observer.DisplayElement;
import observer.Observer;
import observer.Subject;

/**
 * ConcreteObserver + DisplayElement.
 * Muestra la temperatura y la humedad actuales.
 */
public class CurrentConditionsDisplay implements Observer, DisplayElement {

    private float temperature;
    private float humidity;
    private final Subject weatherData;

    /**
     * Recibe el Subject al que debe suscribirse. Se registra a sí
     * mismo automáticamente en el constructor (patrón común en el
     * libro Head First Design Patterns).
     */
    public CurrentConditionsDisplay(Subject weatherData) {
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }

    @Override
    public void update(float temperature, float humidity, float pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        display();
    }

    @Override
    public void display() {
        System.out.println("Condiciones actuales: " + temperature
                + "°C y " + humidity + "% de humedad");
    }
}
