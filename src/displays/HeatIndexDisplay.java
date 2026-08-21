package displays;

import observer.DisplayElement;
import observer.Observer;
import observer.Subject;

/**
 * ConcreteObserver + DisplayElement.
 *
 * Display correspondiente al "Reto" del documento: "Agregue un nuevo
 * display que muestre el índice de calor (Heat Index)".
 *
 * Calcula el índice de calor (HI) a partir de la temperatura (T, en °C)
 * y la humedad relativa (R, en %) usando el polinomio de regresión
 * dado en el enunciado:
 *
 *   HI = c1 + c2*T + c3*R + c4*T*R + c5*T^2 + c6*R^2
 *        + c7*T^2*R + c8*T*R^2 + c9*T^2*R^2
 *
 * El resultado se guarda en heatIndex y se recalcula cada vez que
 * WeatherData notifica un cambio en las mediciones.
 */
public class HeatIndexDisplay implements Observer, DisplayElement {

    // Coeficientes de la fórmula (constantes, tal como aparecen en el documento)
    private static final double C1 = -8.784694755556;
    private static final double C2 = 1.61139411;
    private static final double C3 = 2.33854883889;
    private static final double C4 = -0.14611605;
    private static final double C5 = -0.012308094;
    private static final double C6 = -0.0164248277778;
    private static final double C7 = 2.211732e-3;
    private static final double C8 = 7.2546e-4;
    private static final double C9 = -3.582e-6;

    private float heatIndex;
    private final Subject weatherData;

    public HeatIndexDisplay(Subject weatherData) {
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }

    @Override
    public void update(float temperature, float humidity, float pressure) {
        this.heatIndex = computeHeatIndex(temperature, humidity);
        display();
    }

    /**
     * Calcula el índice de calor a partir de la temperatura (T, °C)
     * y la humedad relativa (R, %), siguiendo el polinomio del
     * enunciado.
     */
    public float computeHeatIndex(float t, float rh) {
        double hi = C1
                + (C2 * t)
                + (C3 * rh)
                + (C4 * t * rh)
                + (C5 * t * t)
                + (C6 * rh * rh)
                + (C7 * t * t * rh)
                + (C8 * t * rh * rh)
                + (C9 * t * t * rh * rh);
        return (float) hi;
    }

    @Override
    public void display() {
        System.out.println("Índice de calor: " + heatIndex + "°C");
    }
}
