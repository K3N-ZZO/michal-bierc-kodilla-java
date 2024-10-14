package com.kodilla.testing.forum.tdd;
import com.kodilla.testing.forum.ForumComment;
import com.kodilla.testing.forum.ForumPost;
import com.kodilla.testing.forum.ForumUser;
import org.junit.jupiter.api.*;

@DisplayName("TDD: Forum Test Suite \uD83D\uDE31")
public class ForumTestSuite {
    private static int testCounter = 0;

    @BeforeAll
    public static void beforeAllTests() {
        System.out.println("This is the beginning of tests.");
    }
    @AfterAll
    public static void afterAllTests() {
        System.out.println("This is the end of tests.");
    }
    @BeforeEach
    public void beforeEachTest() {
        testCounter++;
        System.out.println("Preparing to execute test #" + testCounter);
    }
    @Test
    void testAddPost(){
        //Given
        ForumUser forumUser = new ForumUser("mrSmith","John Smith");
        //When
        forumUser.addPost("mrSmith", "Hello everyone this is my first post!");
        //Then
        Assertions.assertEquals(1,forumUser.getPostQuantity());
    }
    @Test
    void testAddComment(){
        //Given
        ForumUser forumUser = new ForumUser("mrSmith","John Smith");
        ForumPost thePost = new ForumPost("mrSmith", "Hello everyone this is my first post!");
        //When
        forumUser.addComment(thePost,"mrSmith","Thank you for all good words!");
        //Then
        Assertions.assertEquals(1,forumUser.getCommentQuantity());
    }
    @Test
    void testGetPost() {
        //Given
        ForumUser forumUser = new ForumUser("mrsmith", "John Smith");
        ForumPost thePost = new ForumPost("Hello everyone, " +
                "this is my first contribution here!", "mrsmith");
        forumUser.addPost(thePost.getAuthor(), thePost.getPostBody());

        //When
        ForumPost retrievedPost;
        retrievedPost = forumUser.getPost(0);

        //Then
       // Assertions.assertEquals(thePost, retrievedPost);
    }
    @Test
    void testRemovePostNonExisting(){
        //Given
        ForumUser forumUser = new ForumUser("mrSmith","John Smith");
        ForumPost thePost = new ForumPost("mrSmith", "Hello everyone this is my first post!");
        //When
        boolean result = forumUser.removePost(thePost);
        //Then
        Assertions.assertFalse(result);
    }
    @Test
    void testRemoveCommentNonExisting(){
        //Given
        ForumUser forumUser = new ForumUser("mrSmith","John Smith");
        ForumPost thePost = new ForumPost("mrSmith", "Hello everyone this is my first post!");
        ForumComment theComment = new ForumComment(thePost,"mrSmith","Thank you for all good words!");
        //When
        boolean result = forumUser.removeComment(theComment);
        //Then
        Assertions.assertFalse(result);
    }
    @Test
    void testRemovePost(){
        //Given
        ForumUser forumUser = new ForumUser("mrSmith","John Smith");
        ForumPost thePost = new ForumPost("mrSmith", "Hello everyone this is my first post!");
        forumUser.addPost(thePost.getAuthor(), thePost.getPostBody());
        //When
        boolean result = forumUser.removePost(thePost);
        //Then
        Assertions.assertFalse(result);
    }
    @Test
    void testRemoveComment() {
        //Given
        ForumUser forumUser = new ForumUser("mrsmith", "John Smith");
        ForumPost thePost = new ForumPost("Hello everyone, " +
                "this is my first contribution here!", "mrsmith");
        ForumComment theComment = new ForumComment(thePost, "mrsmith",
                "Thank you for all good words!");
        forumUser.addComment(thePost, theComment.getAuthor(),
                theComment.getCommentBody());

        //When
        boolean result = forumUser.removeComment(theComment);

        //Then
//        Assertions.assertEquals(0, forumUser.getCommentQuantity());
    }

}
