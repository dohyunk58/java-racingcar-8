package racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class ValidatorTest {
    @DisplayName("자동차의 이름이 5자를 초과하면 IllegalArgumentException이 발생한다")
    @Test
    void validateNameLengthExceeds() {
        String longName = "123456";

        assertThatThrownBy(() -> Validator.validateName(longName))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("자동차의 이름이 빈 문자열이면 예외가 발생한다")
    @ParameterizedTest
    @ValueSource(strings = {"", " ", "  "})
    void validateNameIsBlank(String blankName) {
        assertThatThrownBy(() -> Validator.validateName(blankName))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("자동차의 이름이 null이면 예외가 발생한다")
    @Test
    void validateNameIsNull() {
        assertThatThrownBy(() -> Validator.validateName(null))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("정상적인 이름은 예외가 발생하지 않는다")
    @Test
    void validateNameSuccess() {
        assertDoesNotThrow(() -> Validator.validateName("pobi"));
    }

    @DisplayName("시도할 횟수가 문자면 예외가 발생한다")
    @Test
    void validateTryCountIsNotNumber() {
        assertThatThrownBy(() -> Validator.validateTryCount("a"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("시도할 횟수가 정수가 아니면 예외가 발생한다")
    @Test
    void validateTryCountIsNotInteger() {
        assertThatThrownBy(() -> Validator.validateTryCount("1.1"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("시도할 횟수가 자연수가 아니면 예외가 발생한다")
    @Test
    void validateTryCountIsNotNaturalNumber() {
        assertThatThrownBy(() -> Validator.validateTryCount("-1"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("이름을 중복 입력하면 예외가 발생한다")
    @Test
    void validateDuplicateName() {
        List<String> duplicateNames = List.of("pobi", "woni", "pobi");

        assertThatThrownBy(() -> Validator.validateDuplicateNames(duplicateNames))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
