package racingcar.model;

public class Car {
    private final String name;
    private int position;
    private static final int INCREASE_POSITION = 1;

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

    public void move() {
        this.position += INCREASE_POSITION;
    }
}
