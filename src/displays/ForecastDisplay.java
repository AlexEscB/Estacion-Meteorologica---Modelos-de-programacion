package displays;

import observer.DisplayElement;
import observer.Observer;
import observer.Subject;

/**
 * ConcreteObserver + DisplayElement.
 * Muestra un pronóstico simple comparando la presión actual con la
 * última medición registrada.
 */
public class ForecastDisplay implements Observer, DisplayElement {

    private float currentPressure = 29.92f;
    private float lastPressure;
    private final Subject weatherData;

    public ForecastDisplay(Subject weatherData) {
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }

    @Override
    public void update(float temperature, float humidity, float pressure) {
        lastPressure = currentPressure;
        currentPressure = pressure;
        display();
    }

    @Override
    public void display() {
        System.out.print("Pronóstico: ");
        if (currentPressure > lastPressure) {
            System.out.println("¡Mejorando el clima!");
        } else if (currentPressure == lastPressure) {
            System.out.println("Sin cambios.");
        } else {
            System.out.println("Cuidado, clima frío y lluvioso a la vista.");
        }
    }
}
