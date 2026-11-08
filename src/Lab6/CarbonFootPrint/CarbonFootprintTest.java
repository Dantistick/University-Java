package Lab6.CarbonFootPrint;

import java.util.ArrayList;

public class CarbonFootprintTest {

    static void main() {

        ArrayList<CarbonFootprint> footprints = new ArrayList<>();

        footprints.add(new Building("Nish Street 23/1", 12_000, 1_500));
        footprints.add(new Car("Audi", 1_200));
        footprints.add(new Airplane("Boeing 737", 2_000, 12, 150));

        for (CarbonFootprint entity : footprints) {
            System.out.printf("%-40s %10.2f кг CO2%n", entity, entity.getCarbonFootprint());
        }
    }
}
