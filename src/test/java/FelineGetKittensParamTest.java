import com.example.Feline;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class FelineGetKittensParamTest {

    private final int inputCount;
    private final int expectedCount;

    public FelineGetKittensParamTest(int inputCount, int expectedCount) {
        this.inputCount = inputCount;
        this.expectedCount = expectedCount;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> getTestData(){
        return Arrays.asList(new Object[][]{
                {1, 1},
                {3, 3},
                {7, 7}
        });
    }

    @Test
    public void testGetKittensWithParameters() {
        Feline feline = new Feline();
        assertEquals(expectedCount, feline.getKittens(inputCount));
    }


}
