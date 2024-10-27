package lotto.entity.machine;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ManualLottoCountTest {

    @Test
    void 로또_금액_보다_수동_갯수가_많으면_예외(){
        List<String[]> texts = new ArrayList<>();
        texts.add(new String[]{"1", "2", "3", "4", "5", "6"});
        texts.add(new String[]{"1", "2", "3", "4", "5", "7"});
        texts.add(new String[]{"1", "2", "3", "4", "5", "8"});

        assertThatThrownBy(
                ()->ManualLottoCount.validate(1000,3,texts)
        );
    }

    @Test
    void 수동_갯수와_리스트가_같지않으면_예외(){
        List<String[]> texts = new ArrayList<>();
        texts.add(new String[]{"1", "2", "3", "4", "5", "6"});
        texts.add(new String[]{"1", "2", "3", "4", "5", "7"});
        texts.add(new String[]{"1", "2", "3", "4", "5", "8"});

        assertThatThrownBy(
                ()->ManualLottoCount.validate(5000,4,texts)
        );
    }
}
