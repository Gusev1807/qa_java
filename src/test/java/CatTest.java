
import com.example.Cat;
import com.example.Feline;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

public class CatTest {

    private Feline felineMock;

    @Before
    public void setUp() {
        felineMock = mock(Feline.class); // ✅ мок именно Feline
    }

    @Test
    public void testGetSound() {
        Cat cat = new Cat(felineMock);
        assertEquals("Мяу", cat.getSound());
    }

    @Test
    public void testGetFood() throws Exception {
        List<String> meatFood = Arrays.asList("Животные", "Птицы", "Рыба");
        when(felineMock.eatMeat()).thenReturn(meatFood); // настройка поведения мока

        Cat cat = new Cat(felineMock);
        assertEquals(meatFood, cat.getFood());
        verify(felineMock, times(1)).eatMeat(); // проверка вызова
    }
}

