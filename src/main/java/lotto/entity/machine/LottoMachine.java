package lotto.entity.machine;

import lotto.entity.Lotto;
import lotto.entity.LottoMoney;

import java.util.ArrayList;
import java.util.List;


public class LottoMachine {

    private LottoMachine() {

    }

    public static List<Lotto> createLotto(int inputMoney, int manualCount, List<String[]> manualTexts) {
        List<Lotto> result = new ArrayList<>();
        ManualLottoCount.validate(inputMoney, manualCount, manualTexts);
        List<Lotto> manualLottos = ManualLottoMachine.createLotto(manualTexts);
        result.addAll(manualLottos);
        List<Lotto> autoLottos = AutoLottoMachine.createLotto(getAutoCount(inputMoney, manualCount));
        result.addAll(autoLottos);
        return result;
    }

    private static int getAutoCount(int inputMoney, int manualCount) {
        return LottoMoney.getLottoCount(inputMoney) - manualCount;
    }

}
