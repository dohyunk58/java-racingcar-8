package racingcar.Model;

import java.util.ArrayList;
import java.util.List;
import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class RacingGame {
    private final List<Car> carList;
    private static final int MIN_INCREASE_CONDITION = 4;

    public RacingGame(List<Car> carList) {
        this.carList = carList;
    }

    public List<String> findWinners() {
        int maxPosition = findMaxPosition();
        List<String> winners = new ArrayList<>();

        for(Car car : carList) {
            if(car.getPosition() == maxPosition) {
                winners.add(car.getName());
            }
        }
        return winners;
    }

    private int findMaxPosition() {
        int maxPosition = 0;
        for (Car car : carList) {
            maxPosition = Math.max(maxPosition, car.getPosition());
        }
        return maxPosition;
    }

    public void runOneRound() {
        for(Car car : carList) {
            int randomNumber = pickNumberInRange(0,9);
            if(randomNumber >= MIN_INCREASE_CONDITION) car.move();
        }
    }

    public List<Car> getCarList() {
        return carList;
    }
}
