import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.regex.Pattern;

/**
 * Learning Regular Expressions Chapter 4
 *
 */
public class LearningRegexChapter4 {

    // \d match number, \D match non-number
    @Test
    public void test1() {
        final Pattern pattern = Pattern.compile("\\d");
        Assertions.assertTrue(pattern.matcher("8").matches());
        Assertions.assertTrue(pattern.matcher("9").matches());
        Assertions.assertFalse(pattern.matcher("xy").matches());
        Assertions.assertFalse(pattern.matcher("z").matches());

        final Pattern pattern2 = Pattern.compile("\\D");
        Assertions.assertFalse(pattern2.matcher("8").matches());
        Assertions.assertFalse(pattern2.matcher("9").matches());
        Assertions.assertTrue(pattern2.matcher("x").matches());
        Assertions.assertTrue(pattern2.matcher("z").matches());
    }

    // \w match number or A-z or _, \W match opposite
    @Test
    public void test2() {
        final Pattern pattern = Pattern.compile("\\w");
        Assertions.assertTrue(pattern.matcher("w").matches());
        Assertions.assertTrue(pattern.matcher("_").matches());
        Assertions.assertTrue(pattern.matcher("Q").matches());
        Assertions.assertTrue(pattern.matcher("4").matches());
        Assertions.assertFalse(pattern.matcher("@").matches());
        Assertions.assertFalse(pattern.matcher("!").matches());

        final Pattern pattern2 = Pattern.compile("\\W");
        Assertions.assertFalse(pattern2.matcher("w").matches());
        Assertions.assertFalse(pattern2.matcher("_").matches());
        Assertions.assertFalse(pattern2.matcher("Q").matches());
        Assertions.assertFalse(pattern2.matcher("4").matches());
        Assertions.assertTrue(pattern2.matcher("@").matches());
        Assertions.assertTrue(pattern2.matcher("!").matches());
    }
}
