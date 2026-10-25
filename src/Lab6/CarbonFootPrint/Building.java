package Lab6.CarbonFootPrint;

public class Building implements ICarbonFootprint {
    private double electricityUsed;
    private double gasUsed;
    private String address;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Building(float electricityUsed, float gasUsed) {
        this.electricityUsed = electricityUsed;
        this.gasUsed = gasUsed;
    }

    @Override
    public double getCarbonFootprint() {
        return electricityUsed * 0.000233 + gasUsed * 2.0;
    }
}
