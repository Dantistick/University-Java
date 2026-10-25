package Lab6.CarbonFootPrint;

public class Airplane implements ICarbonFootprint{
    private double distanceInKilometers;
    private double emissionFactorPerKilometer;
    private int numberOfPassengers;
    private String name = "Undefine";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Airplane(double distanceInKilometers, double emissionFactorPerKilometer, int numberOfPassengers) {
        this.distanceInKilometers = distanceInKilometers;
        this.emissionFactorPerKilometer = emissionFactorPerKilometer;
        this.numberOfPassengers = numberOfPassengers;
    }

    @Override
    public double getCarbonFootprint() {
        return (emissionFactorPerKilometer * distanceInKilometers) / numberOfPassengers;
    }
}
