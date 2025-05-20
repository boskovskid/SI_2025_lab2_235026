import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

public class SILab2Test {

    @Test
    public void testEveryStatement() {

        RuntimeException ex1 = assertThrows(RuntimeException.class, () ->
                SILab2.checkCart(null, "1234567890123456"));
        assertEquals("allItems list can't be null!", ex1.getMessage());

        Item item2 = new Item("Milk", 1, 150, 0.0);
        double result2 = SILab2.checkCart(List.of(item2), "1234567890123456");
        assertEquals(150.0, result2);

        Item item3 = new Item("Bread", 2, 60, 0.1);
        double result3 = SILab2.checkCart(List.of(item3), "1234567890123456");
        assertEquals(78.0, result3);

        Item item4 = new Item("Eggs", 20, 10, 0.0);
        RuntimeException ex4 = assertThrows(RuntimeException.class, () ->
                SILab2.checkCart(List.of(item4), "123456789012AA56"));
        assertEquals("Invalid character in card number!", ex4.getMessage());

        Item item5 = new Item(null, 1, 100, 0.0);
        RuntimeException ex5 = assertThrows(RuntimeException.class, () ->
                SILab2.checkCart(List.of(item5), "1234567890123456"));
        assertEquals("Invalid item!", ex5.getMessage());

        Item item6 = new Item("Juice", 1, 80, 0.0);
        RuntimeException ex6 = assertThrows(RuntimeException.class, () ->
                SILab2.checkCart(List.of(item6), "12345678"));
        assertEquals("Invalid card number!", ex6.getMessage());
    }

    @Test
    public void testMultipleCondition() {

        Item FFF = new Item("Lemons", 5, 100, 0.0);
        assertEquals(500.0, SILab2.checkCart(List.of(FFF), "1234567890123456"));

        Item TFF = new Item("Watermelon", 1, 350, 0.0);
        assertEquals(320.0, SILab2.checkCart(List.of(TFF), "1234567890123456")); // 350 - 30

        Item FTF = new Item("Bread", 3, 90, 0.1);
        double expectedFTF = (90 * 0.9 * 3) - 30;
        assertEquals(expectedFTF, SILab2.checkCart(List.of(FTF), "1234567890123456"));

        Item FFT = new Item("Eggs", 20, 10, 0.0);
        assertEquals(170.0, SILab2.checkCart(List.of(FFT), "1234567890123456")); // (200 - 30)

        Item TTF = new Item("Steak", 3, 400, 0.3);
        double expectedTTF = (400 * 0.7 * 3) - 30;
        assertEquals(expectedTTF, SILab2.checkCart(List.of(TTF), "1234567890123456"));

        Item TFT = new Item("Strawberry", 20, 400, 0.0);
        assertEquals(7970.0, SILab2.checkCart(List.of(TFT), "1234567890123456")); // (8000 - 30)

        Item FTT = new Item("Apple", 10, 250, 0.2);
        double expectedFTT = (250 * 0.8 * 10) - 30;
        assertEquals(expectedFTT, SILab2.checkCart(List.of(FTT), "1234567890123456"));

        Item TTT = new Item("Burger", 10, 2000, 0.3);
        double expectedTTT = (2000 * 0.7 * 10) - 30;
        assertEquals(expectedTTT, SILab2.checkCart(List.of(TTT), "1234567890123456"));
    }
}
