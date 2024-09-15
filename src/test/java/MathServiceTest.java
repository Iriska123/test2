import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
public class MathServiceTest {

    private final MathService mathService = new MathService();

    @Test
    void getAnswer_whenDiscriminantIsNegative_shouldThrowNotFoundAnswerException() {
        Assertions.assertThrows(NotFoundAnswerException.class, () -> mathService.getAnswer(1, 2, 3));
    }

    @Test
    void getAnswer_whenDiscriminantIsZero_shouldReturnSingleRoot() throws NotFoundAnswerException {
        Pair answer = mathService.getAnswer(1, -2, 1);
        Assertions.assertEquals(1.0, answer.first);
        Assertions.assertEquals(1.0, answer.second);
    }

    @Test
    void getAnswer_whenDiscriminantIsPositive_shouldReturnTwoRoots() throws NotFoundAnswerException {
        Pair answer = mathService.getAnswer(1, -3, 2);
        Assertions.assertEquals(1.3333333333333333, answer.first);
        Assertions.assertEquals(0.6666666666666666, answer.second);
    }
    @Test
    void getD_shouldCalculateDiscriminant() {
        int discriminant = mathService.getD(1, -3, 2);
        Assertions.assertEquals(1, discriminant);
    }


}
