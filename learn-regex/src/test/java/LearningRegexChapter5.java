import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.regex.Pattern;

/**
 * Learning Regular Expressions Chapter 5
 *
 */
public class LearningRegexChapter5 {
    // + for one or more
    @Test
    public void test1() {
        final Pattern pattern = Pattern.compile("\\w+");
        Assertions.assertTrue(pattern.matcher("8").matches());
        Assertions.assertTrue(pattern.matcher("946456").matches());
        Assertions.assertFalse(pattern.matcher("").matches());
        Assertions.assertFalse(pattern.matcher("@@").matches());
    }

    // * for zero or more
    @Test
    public void test2() {
        final Pattern pattern = Pattern.compile("\\w*");
        Assertions.assertTrue(pattern.matcher("8").matches());
        Assertions.assertTrue(pattern.matcher("946456").matches());
        Assertions.assertTrue(pattern.matcher("").matches());
        Assertions.assertFalse(pattern.matcher("@@").matches());
    }

    // ? for zero or one
    @Test
    public void test3() {
        final Pattern pattern = Pattern.compile("\\w?");
        Assertions.assertTrue(pattern.matcher("8").matches());
        Assertions.assertFalse(pattern.matcher("946456").matches());
        Assertions.assertTrue(pattern.matcher("").matches());
        Assertions.assertFalse(pattern.matcher("@@").matches());
    }

    // {6} for 6 times
    @Test
    public void test4() {
        final Pattern pattern = Pattern.compile("#\\p{XDigit}{6}");
        Assertions.assertTrue(pattern.matcher("#654345").matches());
        Assertions.assertTrue(pattern.matcher("#65AA45").matches());
        Assertions.assertFalse(pattern.matcher("546657").matches());
        Assertions.assertFalse(pattern.matcher("@tr546").matches());
    }

    // {2,4} for 2 - 4 times
    @Test
    public void test5() {
        final Pattern pattern = Pattern.compile("#\\p{XDigit}{2,4}");
        Assertions.assertTrue(pattern.matcher("#6543").matches());
        Assertions.assertTrue(pattern.matcher("#655").matches());
        Assertions.assertFalse(pattern.matcher("#654345").matches());
        Assertions.assertFalse(pattern.matcher("@tr546").matches());
    }

    // {2,} for at least 2 times
    @Test
    public void test6() {
        final Pattern pattern = Pattern.compile("#\\p{XDigit}{2,}");
        Assertions.assertTrue(pattern.matcher("#6554").matches());
        Assertions.assertTrue(pattern.matcher("#655").matches());
        Assertions.assertTrue(pattern.matcher("#65").matches());
        Assertions.assertFalse(pattern.matcher("#6").matches());
        Assertions.assertFalse(pattern.matcher("@tr546").matches());
    }
}
