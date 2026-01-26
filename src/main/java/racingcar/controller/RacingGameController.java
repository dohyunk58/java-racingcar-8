package racingcar.controller;

import racingcar.model.Car;
import racingcar.model.CarFactory;
import racingcar.model.RacingGame;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

public class RacingGameController {
    private final InputView inputView;
    private final OutputView outputView;
    private final CarFactory carFactory;

    public RacingGameController(InputView inputView, OutputView outputView, CarFactory carFactory) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.carFactory = carFactory;
    }

    public void run() {
        // 1. 준비
        List<Car> cars = setupCars();
        int tryCount = setupTryCount();
        RacingGame game = new RacingGame(cars);
        // 2. 실행
        playRacingGame(game, tryCount);
        // 3. 결과
        showGameResult(game);
    }

    private List<Car> setupCars() {
        String carNameInput = inputView.readCarNames();
        return carFactory.createCarList(carNameInput);
    }

    private int setupTryCount() {
        String tryCountInput = inputView.readTryCount();
        return Integer.parseInt(tryCountInput);
    }

    private void playRacingGame(RacingGame game, int tryCount) {
        outputView.printResultHeader();
        for (int i = 0; i < tryCount; i++) {
            game.runOneRound();
            outputView.printCurrentStatus(game.getCarList());
        }
    }

    private void showGameResult(RacingGame game) {
        List<String> winners = game.findWinners();
        outputView.printWinner(winners);
    }
}
