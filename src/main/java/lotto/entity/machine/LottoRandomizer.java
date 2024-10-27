package lotto.entity.machine;

import lotto.entity.LottoNumber;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoRandomizer {


    public LottoRandomizer() {


    }

    public List<LottoNumber> lottoShuffle() {
        Collections.shuffle(LottoCache.NUMBERS);
        return LottoCache.NUMBERS;
    }

    private static class LottoCache {
        private static final int MIN_LOTTO_NUMBER = 1;
        private static final int MAX_LOTTO_NUMBER = 45;

        private static final List<LottoNumber> NUMBERS = new ArrayList<>();

        static {
            for (int i = MIN_LOTTO_NUMBER; i <= MAX_LOTTO_NUMBER; i++) {
                NUMBERS.add(new LottoNumber(i));
            }
        }
    }
}


