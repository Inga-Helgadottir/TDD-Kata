import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GreetingTest {
    private Greeting g;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        g = new Greeting();
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
    }

    @Test
    public void greet(){
        String[] arr = {"Bob"};
        String actual = g.greet(arr);
        String expected = "Hello, Bob.";
        assertEquals(expected, actual);
    }

    @Test
    public void greetStandIn(){
        String actual = g.greet(null);
        String expected = "Hello, friend.";
        assertEquals(expected, actual);
    }

    @Test
    public void greetingShout(){
        String[] arr = {"BOB"};
        String actual = g.greet(arr);
        String expected = "HELLO, BOB.";
        assertEquals(expected, actual);
    }

    @Test
    public void greetingArray(){
        String[] arr = {"Jill", "Jane"};
        String actual = g.greet(arr);
        String expected = "Hello, Jill and Jane.";
        assertEquals(expected, actual);
    }

    @Test
    public void greetingArrayUnknownNumber(){
        String[] arr = {"Jill", "Jane", "Amy"};
        String actual = g.greet(arr);
        String expected = "Hello, Jill, Jane and Amy.";
        assertEquals(expected, actual);
    }

    @Test
    public void greetingSomeShout(){
        String[] arr = {"Jill", "AMY", "Jane"};
        String actual = g.greet(arr);
        String expected = "Hello, Jill and Jane. AND HELLO AMY!";
        assertEquals(expected, actual);
    }

    @Test
    public void greetingComma(){
        String[] arr = {"Bob", "Charlie, Dianne"};
        String actual = g.greet(arr);
        String expected = "Hello, Bob, Charlie, and Dianne.";
        assertEquals(expected, actual);
    }

    @Test
    public void greetingCommaWorkAround(){
        String[] arr = {"Bob", "\"Charlie, Dianne\""};
        String actual = g.greet(arr);
        String expected = "Hello, Bob and Charlie, Dianne.";
        assertEquals(expected, actual);
    }
}
