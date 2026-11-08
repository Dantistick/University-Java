package Lab6.CarbonFootPrint;

public class Car implements CarbonFootprint {
    private double fuelUsed;
    private String mark;

    public Car(String mark, double fuelUsed) {
        this.mark = mark;
        this.fuelUsed = fuelUsed;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    @Override
    public double getCarbonFootprint() {
        return fuelUsed * 2.31;
    }

    @Override
    public String toString() {
        return "Машина (" + mark + ")";
    }
}
