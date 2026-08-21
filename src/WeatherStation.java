import data.WeatherData;
import displays.AtmosphericPressureDisplay;
import displays.CurrentConditionsDisplay;
import displays.ForecastDisplay;
import displays.HeatIndexDisplay;
import displays.StatisticsDisplay;

/**
 * Clase principal (equivalente a WeatherStation en el enunciado).
 *
 * Ensambla el Subject (WeatherData) con todos los ConcreteObservers
 * y simula la llegada de tres tandas de mediciones para demostrar
 * que, cada vez que las condiciones cambian, TODOS los displays
 * suscritos son notificados y se actualizan automáticamente.
 */
public class WeatherStation {

    public static void main(String[] args) {
        // 1. Se crea el Subject
        WeatherData weatherData = new WeatherData();

        // 2. Se crean los displays y se registran como Observers de weatherData
        //    (cada constructor hace weatherData.registerObserver(this))
        CurrentConditionsDisplay currentDisplay = new CurrentConditionsDisplay(weatherData);
        StatisticsDisplay statisticsDisplay = new StatisticsDisplay(weatherData);
        ForecastDisplay forecastDisplay = new ForecastDisplay(weatherData);
        AtmosphericPressureDisplay pressureDisplay = new AtmosphericPressureDisplay(weatherData);
        HeatIndexDisplay heatIndexDisplay = new HeatIndexDisplay(weatherData);

        // 3. Simulación: Weather-O-Rama entrega nuevas mediciones.
        //    setMeasurements() -> measurementsChanged() -> notifyObservers()
        System.out.println("=== Medición 1 ===");
        weatherData.setMeasurements(27f, 65f, 1013f);

        System.out.println("\n=== Medición 2 ===");
        weatherData.setMeasurements(29f, 70f, 1010f);

        System.out.println("\n=== Medición 3 ===");
        weatherData.setMeasurements(24f, 90f, 1015f);

        // 4. Demostración de removeObserver(): el pronóstico deja de suscribirse
        weatherData.removeObserver(forecastDisplay);

        System.out.println("\n=== Medición 4 (sin ForecastDisplay) ===");
        weatherData.setMeasurements(22f, 60f, 1018f);
    }
}
