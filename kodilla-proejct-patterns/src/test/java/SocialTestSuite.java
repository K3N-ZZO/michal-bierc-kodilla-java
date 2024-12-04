import com.kodilla.patterns.strategy.social.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SocialTestSuite {
    @Test
    void testDefaultSharingStrategies(){
        //Given
        User steven = new Milenials("Steven post");
        User michael = new ZGeneration("Michael post");
        User tom = new YGeneration("Tom post");
        //When
        String stevenPublish = steven.sharePost();
        System.out.println("Steven publish: " + stevenPublish);
        String michaelPublish = michael.sharePost();
        System.out.println("Michael publish: " + michaelPublish);
        String tomPublish = tom.sharePost();
        System.out.println("Tom publish: " + tomPublish);
        //Then
        assertEquals("[Facebook Publisher] Publishing post on Facebook", stevenPublish);
        assertEquals("[Snapchat Publisher] Publishing post on Snapchat", michaelPublish);
        assertEquals("[Twitter publisher] Publishing post on Twitter", tomPublish);

    }
    @Test
    void testIndividualSharingStrategy(){
        //Given
        User steven = new Milenials("Steven Hawkins");
        //When
        String stevenPublish = steven.sharePost();
        System.out.println("Steven publish: " + stevenPublish);
        steven.setSocialPublisher(new SnapchatPublisher());
        stevenPublish = steven.sharePost();
        System.out.println("Steven publish: " + stevenPublish);
        //Then
        assertEquals("[Snapchat Publisher] Publishing post on Snapchat", stevenPublish);
    }
}
