import com.example.Alex;
import com.example.Feline;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class AlexFriendsParamTest {

    private final String expectedFriend;
    private Alex alex;

    public AlexFriendsParamTest(String expectedFriend) {
        this.expectedFriend = expectedFriend;
    }

    @Before
    public void setUp() throws Exception {
        alex = new Alex(new Feline());
    }

    @Parameterized.Parameters(name = "{index}: друг = {0}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"Марти"},
                {"Глория"},
                {"Мелман"}
        });
    }

    @Test
    public void testFriendInList() {
        List<String> friends = alex.getFriends();
        assertEquals(true, friends.contains(expectedFriend));
    }
}
