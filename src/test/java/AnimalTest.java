import com.example.Animal;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class AnimalTest {

    @Test
    public void testGetFoodHerbivore() throws Exception {
        Animal animal = new Animal();
        List<String> food = animal.getFood("Травоядное");
        assertEquals(List.of("Трава", "Различные растения"), food);
    }

    @Test
    public void testGetFoodPredator() throws Exception {
        Animal animal = new Animal();
        List<String> food = animal.getFood("Хищник");
        assertEquals(List.of("Животные", "Птицы", "Рыба"), food);
    }

    @Test(expected = Exception.class)
    public void testGetFoodUnknownAnimalKindThrowsException() throws Exception {
        Animal animal = new Animal();
        animal.getFood("Неизвестный");
    }

    @Test
    public void testGetFamilyContainsKoshachie() {
        Animal animal = new Animal();
        String family = animal.getFamily();
        assertTrue(family.contains("кошачьи"));
    }

    @Test
    public void testGetFamilyStartsWithDescription() {
        Animal animal = new Animal();
        String family = animal.getFamily();
        assertTrue(family.startsWith("Существует несколько семейств"));
    }
}
