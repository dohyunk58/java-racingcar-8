package racingcar.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarTest {
    private Car car;
    private static final String defaultName = "name";

    @BeforeEach
    void setUp() {
        car = new Car(defaultName);
    }

    @DisplayName("Car 객체 생성 시 이름을 검증한다")
    @Test
    void createCarWithInvalidName() {
        assertThatThrownBy(() -> new Car("123456"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("자동차의 초기 position은 0이다")
    @Test
    void initCar() {
        int position = car.getPosition();

        assertThat(position).isEqualTo(0);
    }

    @DisplayName("Car의 이름과 position을 반환한다")
    @Test
    void getNameAndPosition() {
        assertThat(car.getName()).isEqualTo(defaultName);
        assertThat(car.getPosition()).isEqualTo(0);
    }

    @DisplayName("move() 호출 시 position이 1 증가한다")
    @Test
    void moveCarWhenNumberIsFourOrMore() {
        car.move();

        assertThat(car.getPosition()).isEqualTo(1);
    }
}
