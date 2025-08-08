import com.example.Cat;
import com.example.Feline;
import com.example.Predator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

@RunWith(Parameterized.class)
public class CatSoundParamTest {

    private final Predator predatorMock;

    public CatSoundParamTest(Predator predatorMock) {
        this.predatorMock = predatorMock;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> testData() {
        Predator mock1 = mock(Feline.class);
        Predator mock2 = mock(Feline.class);
        Predator mock3 = mock(Feline.class);
        return Arrays.asList(new Object[][]{
                {mock1},
                {mock2},
                {mock3}
        });
    }

    @Test
    public void testCatAlwaysMeows() {
        Cat cat = new Cat((Feline) predatorMock);
        assertEquals("Мяу", cat.getSound());
    }

}
