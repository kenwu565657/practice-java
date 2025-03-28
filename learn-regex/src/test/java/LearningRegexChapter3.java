import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.regex.Pattern;

/**
 * Learning Regular Expressions Chapter 3
 *
 */
public class LearningRegexChapter3 {

    // use [xy] to match x or y
    @Test
    public void test1() {
        final Pattern pattern = Pattern.compile("[xy]");
        Assertions.assertTrue(pattern.matcher("x").matches());
        Assertions.assertTrue(pattern.matcher("y").matches());
        Assertions.assertFalse(pattern.matcher("xy").matches());
        Assertions.assertFalse(pattern.matcher("z").matches());
    }

    // use [0-9] to match number
    @Test
    public void test2() {
        final Pattern pattern = Pattern.compile("[0-9]");
        Assertions.assertTrue(pattern.matcher("0").matches());
        Assertions.assertTrue(pattern.matcher("9").matches());
        Assertions.assertFalse(pattern.matcher("xy").matches());
        Assertions.assertFalse(pattern.matcher("99").matches());
    }

    // use [^0-9] to exclude number
    @Test
    public void test3() {
        final Pattern pattern = Pattern.compile("[^0-9]");
        Assertions.assertFalse(pattern.matcher("0").matches());
        Assertions.assertFalse(pattern.matcher("9").matches());
    }
}
