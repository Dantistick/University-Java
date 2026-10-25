package Lab6.CarbonFootPrint;

public class Car implements ICarbonFootprint {
    private double fuelUsed;
    private String mark;

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public Car(double fuelUsed) {
        this.fuelUsed = fuelUsed;
    }

    @Override
    public double getCarbonFootprint() {
        return fuelUsed * 2.31;
    }
}
