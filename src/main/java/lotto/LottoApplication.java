package lotto;

import lotto.backend.controller.LottoController;

public class LottoApplication {

    public static void main(String[] args) {
        LottoController lottoController = new LottoController();
        lottoController.start();
    }
}
