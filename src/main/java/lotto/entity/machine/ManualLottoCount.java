package lotto.entity.machine;

import lotto.entity.LottoMoney;

import java.util.List;

public class ManualLottoCount {

    private ManualLottoCount() {

    }

    public static void validate(int inputMoney, int manualCount, List<String[]> texts) {

        validateManualCount(inputMoney, manualCount);
        validateManualSize(manualCount, texts);
    }

    private static void validateManualCount(int inputMoney, int manualCount) {
        int lottoCount = LottoMoney.getLottoCount(inputMoney);

        if (manualCount > lottoCount) {
            throw new IllegalArgumentException("로또 금액 보다 수동 갯수가 더 큽니다");
        }
    }

    private static void validateManualSize(int manualCount, List<String[]> manualTexts) {
        if (manualCount != manualTexts.size()) {
            throw new IllegalArgumentException("수동입력 갯수와 수동 번호 리스트 갯수가 맞지 않습니다");
        }
    }
}
