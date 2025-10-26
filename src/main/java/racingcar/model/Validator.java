package racingcar.model;

public class Validator {
    private static final int MAX_NAME_LENGTH = 5;

    public static void validateName(String name) {
        if(name == null) throw new IllegalArgumentException("이름은 null일 수 없습니다");

        if(name.isBlank()) throw new IllegalArgumentException("이름이 비어있습니다");

        if(name.length() > MAX_NAME_LENGTH) throw new IllegalArgumentException("이름은 5자 이하만 가능합니다");
    }

    public static void validateTryCount(String tryCount) {
        try {
            int count = Integer.parseInt(tryCount);
            if(count < 1) throw new IllegalArgumentException("입력값이 자연수가 아닙니다");
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("입력값이 정수가 아닙니다");
        }
    }
}
