package racingcar.View;

import racingcar.Model.Car;

import java.util.List;

public class OutputView {
    public static void printResultHeader() {
        System.out.println("\n실행 결과");
    }

    public static void printCurrentStatus(List<Car> CarList) {
        for (Car car : CarList) {
            System.out.println(car.getName()+ " : " + "-".repeat(car.getPosition()));
        }
        System.out.println();
    }

    public static void printWinner(List<String> winners) {
        System.out.print("최종 우승자 : ");
        String result = String.join(", ", winners);
        System.out.print(result);
    }
}
