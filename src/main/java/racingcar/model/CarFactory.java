package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class CarFactory {
    private static final String DELIMITER = ",";

    public static List<Car> createCarList(String carNameInput) {
        String[] names = carNameInput.split(DELIMITER);
        List<Car> carList = new ArrayList<>();

        for (String name : names) {
            carList.add(new Car(name.trim()));
        }
        return carList;
    }
}
