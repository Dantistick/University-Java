package Lab6.CarbonFootPrint;

import java.util.ArrayList;

public class CarbonFootprintTest {

    static void main() {

        ArrayList<ICarbonFootprint> footprintArrayList = new ArrayList<>();

        Building building = new Building(1,1);
        building.setAddress("Nish Street 23/1");
        footprintArrayList.add(building);

        Car car = new Car(1);
        car.setMark("Audi");
        footprintArrayList.add(car);

        Airplane airplane = new Airplane(5,1, 10);
        footprintArrayList.add(airplane);

        for(var entity : footprintArrayList)
        {
            entity.getCarbonFootprint();

            switch (entity) {
                case Building b -> b.getAddress();
                case Car c -> c.getMark();
                case Airplane a -> a.getName();
                default -> System.out.println("Unknown entity");
            }
        }
    }
}
