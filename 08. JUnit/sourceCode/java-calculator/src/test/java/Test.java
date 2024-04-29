import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class) // Mockito를 사용하기 위해 선언
public class Test {
    @Mock
    public MarketServer marketServer;

    @BeforeEach
    public void init(){
        // Mockito -> marketServer.price() 호출이 되면, thenReturn에 있는 200을 반환함
        Mockito.lenient().when(marketServer.price()).thenReturn(200);
    }


    // 호출 테스트
    @org.junit.jupiter.api.Test
    public void hello(){
        System.out.println("hello");
    }

    // Mockito 없이 테스트
    @org.junit.jupiter.api.Test
    public void dollar(){
        MarketServer marketServer = new MarketServer();
        DollarCalculator dollarCalculator = new DollarCalculator(marketServer);
        dollarCalculator.init();

        Calculator calculator = new Calculator(dollarCalculator);
        int sum = calculator.sum(100, 100);
        Assertions.assertEquals(20000, sum);
    }

    // Mockito 사용 해서 테스트
    @org.junit.jupiter.api.Test
    public void mock(){
        DollarCalculator dollarCalculator = new DollarCalculator(marketServer);
        dollarCalculator.init();

        Calculator calculator = new Calculator(dollarCalculator);
        int sum = calculator.sum(100, 100);
        Assertions.assertEquals(40000, sum);
    }
}
