import org.junit.Test;

import java.util.Deque;

import static org.junit.Assert.*;

public class TestPalindrome {
    // You must use this palindrome, and not instantiate
    // new Palindromes, or the autograder might be upset.
    static Palindrome palindrome = new Palindrome();

    @Test
    public void testWordToDeque() {
        Deque d = palindrome.wordToDeque("persiflage");
        String actual = "";
        for (int i = 0; i < "persiflage".length(); i++) {
            actual += d.removeFirst();
        }
        assertEquals("persiflage", actual);
    }

    @Test
    public void testisPalindrome(){
        Palindrome test = new Palindrome();
        String temp1 = "abaaba";
        String temp2 = "2";
        String temp3 = "";
        String temp4 = "Palindrome";
        assertTrue(test.isPalindrome(temp1));
        assertTrue(test.isPalindrome(temp2));
        assertTrue(test.isPalindrome(temp3));
        assertFalse(test.isPalindrome(temp4));
    }
}