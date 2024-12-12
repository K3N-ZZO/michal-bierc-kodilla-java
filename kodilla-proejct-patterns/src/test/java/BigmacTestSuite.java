import com.kodilla.patterns.builder.bigmac.Bigmac;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BigmacTestSuite {
    @Test
    void testBigmacBuilder(){
        //Given
        Bigmac bigmac = new Bigmac.BigmacBuilder()
                .bun("sesamed")
                .burgers(2)
                .sauce("barbecue")
                .ingredient("lettuce")
                .ingredient("onion")
                .ingredient("bacon")
                .ingredient("cheese")
                .build();
        System.out.println(bigmac);

        //When
        int numberOfIngredients = bigmac.getIngredients().size();

        //Then
        assertEquals("sesamed", bigmac.getBun());
        assertEquals("barbecue", bigmac.getSauce());
        assertEquals(2,bigmac.getBurgers());
        assertEquals(4,numberOfIngredients);
        }
    }

