package racingcar.Model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingGameTest {

    @DisplayName("가장 많이 전진한 자동차가 한 명일 때 우승자로 반환한다")
    @Test
    void findSingleWinner() {
        Car car1 = new Car("pobi");
        Car car2 = new Car("woni");
        Car car3 = new Car("jun");

        // 객체 전진, car1: 2, car2: 1, car3: 0
        car1.move(4);
        car1.move(9);
        car2.move(4);
        car2.move(3);

        RacingGame game = new RacingGame(List.of(car1,car2,car3));

        List<String> winners = game.findWinners();

        assertThat(winners).containsOnly("pobi");
    }

    @DisplayName("가장 많이 전진한 자동차가 여러 명일 때 모두 반환한다")
    @Test
    void findMultipleWinner() {
        Car car1 = new Car("pobi");
        Car car2 = new Car("woni");
        Car car3 = new Car("jun");

        car1.move(4);
        car2.move(4);
        car2.move(3);

        RacingGame game = new RacingGame(List.of(car1, car2, car3));

        List<String> winners = game.findWinners();

        assertThat(winners).containsExactlyInAnyOrder("pobi", "woni");
    }
}
