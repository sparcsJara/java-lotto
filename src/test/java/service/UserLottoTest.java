package service;

import domain.Lotto;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import repository.UserLottoRepository;
import service.UserLottoService;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class UserLottoTest {
    UserLottoRepository userLottoRepository;
    UserLottoService userLottoService;

    @BeforeEach
    public void beforeEach() {
        userLottoRepository = new UserLottoRepository();
        userLottoService = new UserLottoService(userLottoRepository);
    }

    @AfterEach
    public void afterEach(){
        userLottoRepository.clearStore();
    }

    @Test
    @DisplayName("구입한 티켓 갯수에 맞춰 로또를 생성한다.")
    void generateLottoTest() {
        userLottoService.buyRandomLottoTickets(2000);
        List<Lotto> lottoTickets = userLottoService.getAllLottoTickets();

        for (Lotto lotto : lottoTickets) {
            System.out.println("lotto1.getLottoNumbers() = " + lotto.getLottoNumbers());
        }
        assertThat(lottoTickets.size()).isEqualTo(2);
    }
    @Test
    @DisplayName("1000원 미만을 입력하는 경우 IllegalArgumentException throw 테스트")
    void lessMoneyExceptionTest() {
        assertThrows(IllegalArgumentException.class, () -> userLottoService.buyRandomLottoTickets(900));
    }
}
