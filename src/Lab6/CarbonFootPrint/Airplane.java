package Lab6.CarbonFootPrint;

public class Airplane implements CarbonFootprint {
    private double distanceInKilometers;
    private double emissionFactorPerKilometer;
    private int numberOfPassengers;
    private String name;

    public Airplane(String name, double distanceInKilometers, double emissionFactorPerKilometer, int numberOfPassengers) {
        if (numberOfPassengers <= 0)
            throw new IllegalArgumentException("Количество пассажиров должно быть больше 0");

        this.name = name;
        this.distanceInKilometers = distanceInKilometers;
        this.emissionFactorPerKilometer = emissionFactorPerKilometer;
        this.numberOfPassengers = numberOfPassengers;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public double getCarbonFootprint() {
        return (emissionFactorPerKilometer * distanceInKilometers) / numberOfPassengers;
    }

    @Override
    public String toString() {
        return "Самолёт (" + name + "), на пассажира";
    }
}
