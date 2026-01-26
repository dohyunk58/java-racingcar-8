package racingcar;

import racingcar.controller.RacingGameController;
import racingcar.model.CarFactory;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        CarFactory carFactory = new CarFactory();

        RacingGameController racingGameController = new RacingGameController(
                inputView,  outputView, carFactory
        );
        racingGameController.run();
    }
}