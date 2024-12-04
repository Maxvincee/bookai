package bookai;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;




class ISBNValidatorTest {

    private final ISBNValidator validator = new ISBNValidator();

    @Test
    void testValidISBN10() {
        assertTrue(validator.isValidISBN10("0306406152"));
        assertTrue(validator.isValidISBN10("097522980X"));
        assertTrue(validator.isValidISBN10("020161622X"));
        assertTrue(validator.isValidISBN10("0321125215"));
    }

    @Test
    void testInvalidISBN10() {
        assertFalse(validator.isValidISBN10("0306406153"));
        assertFalse(validator.isValidISBN10("0975229800"));
        assertFalse(validator.isValidISBN10("123456789"));
        assertFalse(validator.isValidISBN10(null));
        assertFalse(validator.isValidISBN10(""));
        assertFalse(validator.isValidISBN10("ABCDEFGHIJ"));
    }

    @Test
    void testValidISBN13() {
        assertTrue(validator.isValidISBN13("9780306406157"));
        assertTrue(validator.isValidISBN13("9780975229804"));
        assertTrue(validator.isValidISBN13("9780321146533"));
    }

    @Test
    void testInvalidISBN13() {
        assertFalse(validator.isValidISBN13("9780306406158"));
        assertFalse(validator.isValidISBN13("9780975229805"));
        assertFalse(validator.isValidISBN13("123456789012"));
        assertFalse(validator.isValidISBN13(null));
        assertFalse(validator.isValidISBN13(""));
        assertFalse(validator.isValidISBN13("ABCDEFGHIJKLM"));
    }
}