package lotto.entity.machine;

import lotto.entity.Lotto;
import lotto.entity.LottoMoney;
import lotto.entity.LottoNumber;
import lotto.entity.LottoText;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class ManualLottoMachine {

    private ManualLottoMachine() {

    }

    public static List<Lotto> createLotto(List<String[]> manualTexts) {
        List<Lotto> result = new ArrayList<>();
        for (String[] manualText : manualTexts) {
            Set<LottoNumber> lottoNumbers = LottoText.ofValues(manualText);
            result.add(Lotto.valueOf(lottoNumbers));
        }
        return result;
    }
}
