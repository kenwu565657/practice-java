import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.regex.Pattern;

/**
 * Learning Regular Expressions Chapter 2
 *
 */
public class LearningRegexChapter2 {

    @Test
    public void test1() {
        // . can match any single character
        final Pattern pattern1 = Pattern.compile("c.t");
        Assertions.assertTrue(pattern1.matcher("cat").matches());
        Assertions.assertFalse(pattern1.matcher("caat").matches());
    }

    @Test
    public void test2() {
        // use \. to match .
        final Pattern pattern1 = Pattern.compile("c\\.t");
        Assertions.assertFalse(pattern1.matcher("cat").matches());
        Assertions.assertFalse(pattern1.matcher("caat").matches());
        Assertions.assertTrue(pattern1.matcher("c.t").matches());
    }
}
