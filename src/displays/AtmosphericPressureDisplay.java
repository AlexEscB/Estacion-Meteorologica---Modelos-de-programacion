package displays;

import observer.DisplayElement;
import observer.Observer;
import observer.Subject;

/**
 * ConcreteObserver + DisplayElement.
 *
 * Nuevo display pedido en el ejercicio: "Agregue un nuevo display
 * que muestre solo la presión atmosférica".
 *
 * Muestra únicamente el valor de presión, ignorando temperatura y
 * humedad. Al implementar Observer y DisplayElement se integra al
 * patrón sin modificar WeatherData ni ningún otro display existente
 * (Principio Abierto/Cerrado).
 */
public class AtmosphericPressureDisplay implements Observer, DisplayElement {

    private float pressure;
    private final Subject weatherData;

    public AtmosphericPressureDisplay(Subject weatherData) {
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }

    @Override
    public void update(float temperature, float humidity, float pressure) {
        this.pressure = pressure;
        display();
    }

    @Override
    public void display() {
        System.out.println("Presión atmosférica: " + pressure + " hPa");
    }
}
