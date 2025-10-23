package racingcar.Model;

public class Car {
    private final String name;
    private int position;
    private static final int INCREASE_POSITION = 1;
    private static final int MIN_INCREASE_CONDITION = 4;

    public Car(String name) {
        this.name = name;
        Validator.validateName(name);
    }

    public int getPosition() {
        return this.position;
    }

    public String getName() {
        return this.name;
    }

    public void move(int randomNumber) {
        if(randomNumber >= MIN_INCREASE_CONDITION ) {
            this.position += INCREASE_POSITION;
        }
    }
}
