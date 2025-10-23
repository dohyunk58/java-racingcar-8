package racingcar;

import racingcar.Model.Car;
import racingcar.Model.CarFactory;
import racingcar.Model.RacingGame;
import racingcar.View.InputView;
import racingcar.View.OutputView;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        String carNameInput = InputView.readCarNames();

        List<Car> cars = CarFactory.createCarList(carNameInput);

        String tryCountInput = InputView.readTryCount();

        RacingGame game = new RacingGame(cars);

        // 게임 실행 및 View 출력
        OutputView.printResultHeader();
        int tryCount = Integer.parseInt(tryCountInput);
        for (int i = 0; i < tryCount; i++) {
            game.runOneRound();
            OutputView.printCurrentStatus(game.getCarList());
        }

        List<String> winners = game.findWinners();
        OutputView.printWinner(winners);
    }
}
