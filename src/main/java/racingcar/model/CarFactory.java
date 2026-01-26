package racingcar.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CarFactory {
    private static final String DELIMITER = ",";

    public List<Car> createCarList(String carNameInput) {
        String[] names = carNameInput.split(DELIMITER);
        List<String> nameList = Arrays.asList(names);

        Validator.validateDuplicateNames(nameList);

        List<Car> carList = new ArrayList<>();
        for (String name : names) {
            carList.add(new Car(name));
        }
        return carList;
    }
}
