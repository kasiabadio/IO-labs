package put.io.testing.audiobooks;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AudiobookPriceCalculatorTest {

    @Test
    public void testSubscriber(){
        Customer customer = new Customer("Adam", Customer.LoyaltyLevel.GOLD, true);
        Audiobook audiobook = new Audiobook("Audiobook", 10);
        AudiobookPriceCalculator calculater = new AudiobookPriceCalculator();
        assertEquals(0, calculater.calculate(customer, audiobook));
    }
}