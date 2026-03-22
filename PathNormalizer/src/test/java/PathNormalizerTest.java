import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PathNormalizerTest {

    @Test
    void test1() {
        assertEquals(".", PathNormalizer.normalize(".//"));
    }

    @Test
    void test2() {
        assertEquals("./home..", PathNormalizer.normalize("./home../"));
    }

    @Test
    void test3() {
        assertEquals("./home/algo", PathNormalizer.normalize("./home/utils/../algo"));
    }

    @Test
    void test4() {
        assertEquals(null, PathNormalizer.normalize("algo"));
    }

    @Test
    void test5() {
        assertEquals("./a..b.c", PathNormalizer.normalize("./a..b.c"));
    }

    @Test
    void test6() {
        assertEquals("./a/b/c", PathNormalizer.normalize("././a//b/./c//"));
    }
}
