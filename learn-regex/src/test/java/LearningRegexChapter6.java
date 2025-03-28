import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.regex.Pattern;

/**
 * Learning Regular Expressions Chapter 6
 *
 */
public class LearningRegexChapter6 {
    // \b for start or end
    @Test
    public void test() {
        Pattern pattern = Pattern.compile("\\byy\\b");
        Assertions.assertTrue(pattern.matcher("yy").matches());
        Assertions.assertFalse(pattern.matcher("y").matches());
        Assertions.assertFalse(pattern.matcher("yyy").matches());
    }
}
