package lotto.entity;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class LottoTest {


    @Test
    void 정렬() {
        List<Integer> numbers = Arrays.asList(10, 4, 9, 2, 5, 1);
        Lotto lotto = new Lotto(numbers);

        assertThat(lotto.getNumbers()).isSortedAccordingTo((s1, s2) -> s1.compareTo(s2));
    }

    @Test
    void 당첨_갯수_검증() {
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 10, 5, 6));

        assertAll(
                () -> assertThat(lotto.matchCount(Arrays.asList(1, 43, 42, 30, 31, 33))).isEqualTo(1),
                () -> assertThat(lotto.matchCount(Arrays.asList(1, 2, 3, 11, 12, 13))).isEqualTo(3),
                () -> assertThat(lotto.matchCount(Arrays.asList(1, 2, 3, 5, 12, 13))).isEqualTo(4),
                () -> assertThat(lotto.matchCount(Arrays.asList(1, 2, 3, 5, 12, 10))).isEqualTo(5),
                () -> assertThat(lotto.matchCount(Arrays.asList(1, 2, 3, 10, 5, 6))).isEqualTo(6)
        );
    }

}
