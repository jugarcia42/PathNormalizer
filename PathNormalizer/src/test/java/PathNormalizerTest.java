import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PathNormalizerTest {

    @Test
    void test1() {
        PathNormalizer Normalizer = new PathNormalizer();
        assertEquals(".", Normalizer.normalize(".//"));
    }
    @Test
    void test2() {
        PathNormalizer Normalizer = new PathNormalizer();
        assertEquals("./home..", Normalizer.normalize("./home../"));
    }
    @Test
    void test3() {
        PathNormalizer Normalizer = new PathNormalizer();
        assertEquals("./home/algo", Normalizer.normalize("./home/utils/../algo"));
    }
    @Test
    void test4() {
        PathNormalizer Normalizer = new PathNormalizer();
        assertEquals(null, Normalizer.normalize("algo"));
    }
    @Test
    void test5() {
        PathNormalizer Normalizer = new PathNormalizer();
        assertEquals("./a..b.c", Normalizer.normalize("./a..b.c"));
    }
    @Test
    void test6() {
        PathNormalizer Normalizer = new PathNormalizer();
        assertEquals("./a/b/c", Normalizer.normalize("././a//b/./c//"));
    }
}

