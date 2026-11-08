package Lab6.CarbonFootPrint;

public class Building implements CarbonFootprint {
    private double electricityUsed;
    private double gasUsed;
    private String address;

    public Building(String address, double electricityUsed, double gasUsed) {
        this.address = address;
        this.electricityUsed = electricityUsed;
        this.gasUsed = gasUsed;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public double getCarbonFootprint() {
        return electricityUsed * 0.000233 + gasUsed * 2.0;
    }

    @Override
    public String toString() {
        return "Здание (" + address + ")";
    }
}
