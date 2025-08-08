import com.example.Alex;
import com.example.Feline;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class AlexTest {

    private Feline felineMock;

    @Before
    public void setUp() {
        felineMock = mock(Feline.class);
    }

    @Test
    public void testGetFriends() throws Exception {
        Alex alex = new Alex(felineMock);
        List<String> expected = Arrays.asList("Марти", "Глория", "Мелман");
        assertEquals(expected, alex.getFriends());
    }

    @Test
    public void testGetPlaceOfLiving() throws Exception {
        Alex alex = new Alex(felineMock);
        assertEquals("Нью-Йоркский зоопарк", alex.getPlaceOfLiving());
    }

    @Test
    public void testGetKittens() throws Exception {
        Alex alex = new Alex(felineMock);
        assertEquals(0, alex.getKittens());
    }

    @Test
    public void testGetFood() throws Exception {
        List<String> meatFood = Arrays.asList("Животные", "Птицы", "Рыба");
        when(felineMock.getFood("Хищник")).thenReturn(meatFood);

        Alex alex = new Alex(felineMock);
        assertEquals(meatFood, alex.getFood());
        verify(felineMock, times(1)).getFood("Хищник");
    }
}
