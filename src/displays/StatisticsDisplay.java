package displays;

import observer.DisplayElement;
import observer.Observer;
import observer.Subject;

/**
 * ConcreteObserver + DisplayElement.
 * Mantiene y muestra la temperatura mínima, máxima y promedio
 * acumuladas desde que la estación empezó a funcionar.
 */
public class StatisticsDisplay implements Observer, DisplayElement {

    private float maxTemp = Float.MIN_VALUE;
    private float minTemp = Float.MAX_VALUE;
    private float tempSum = 0.0f;
    private int numReadings = 0;
    private final Subject weatherData;

    public StatisticsDisplay(Subject weatherData) {
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }

    @Override
    public void update(float temperature, float humidity, float pressure) {
        tempSum += temperature;
        numReadings++;

        if (temperature > maxTemp) {
            maxTemp = temperature;
        }
        if (temperature < minTemp) {
            minTemp = temperature;
        }

        display();
    }

    @Override
    public void display() {
        System.out.println("Estadísticas: temp. promedio = "
                + (tempSum / numReadings)
                + "°C, mín = " + minTemp
                + "°C, máx = " + maxTemp + "°C");
    }
}
