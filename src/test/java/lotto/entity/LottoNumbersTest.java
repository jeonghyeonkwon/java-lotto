package lotto.entity;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

public class LottoNumbersTest {

    @Test
    void 로또_생성_시_범위_외_번호_예외() {
        assertThatThrownBy(() -> new LottoNumbers(List.of(1, 2, 3, 4, 5, 66))).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 당첨_갯수_검증() {
        LottoNumbers lotto = new LottoNumbers(Arrays.asList(1, 2, 3, 10, 5, 6));

        assertAll(
                () -> assertThat(lotto.matchCount(Arrays.asList(1, 43, 42, 30, 31, 33))).isEqualTo(1),
                () -> assertThat(lotto.matchCount(Arrays.asList(1, 2, 3, 11, 12, 13))).isEqualTo(3),
                () -> assertThat(lotto.matchCount(Arrays.asList(1, 2, 3, 5, 12, 13))).isEqualTo(4),
                () -> assertThat(lotto.matchCount(Arrays.asList(1, 2, 3, 5, 12, 10))).isEqualTo(5),
                () -> assertThat(lotto.matchCount(Arrays.asList(1, 2, 3, 10, 5, 6))).isEqualTo(6)
        );
    }

    @Test
    void 중복() {
        assertThatThrownBy(() -> new LottoNumbers(Arrays.asList(10, 4, 9, 2, 4, 1))).isInstanceOf(IllegalArgumentException.class);
    }

}
