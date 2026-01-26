package racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CarFactoryTest {

    @DisplayName("쉼표로 구분된 문자열로 Car 리스트를 생성한다")
    @Test
    void createCarsFromNames() {
        CarFactory carFactory = new CarFactory();

        String carNameInput = "pobi,woni,jun";

        List<Car> cars = carFactory.createCarList(carNameInput);

        assertThat(cars).hasSize(3);

        assertThat(cars)
                .extracting(Car::getName)
                .containsExactly("pobi", "woni", "jun");
    }
}
