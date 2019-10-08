import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class IsoscelesTriangleTest {
    @Test
    public void testCheckIsoscelesMax() {
        assertEquals(60.499999999999986, IsoscelesTriangle.CheckIsoscelesMax("-1 -1 10 -1 -1 10"));
        assertEquals(60.499999999999986, IsoscelesTriangle.CheckIsoscelesMax("-1 -1 10 -1 -1 10 "));
        assertEquals(60.499999999999986, IsoscelesTriangle.CheckIsoscelesMax("-1 -1 10 -1 -1 10  "));
        assertEquals(-1, IsoscelesTriangle.CheckIsoscelesMax(" -1 -1 10 -1 -1 10 "));
        assertEquals(-1, IsoscelesTriangle.CheckIsoscelesMax("-1 -1 11 -1 -1 10 "));
        assertEquals(-1, IsoscelesTriangle.CheckIsoscelesMax("-1  -1 10 -1 -1 10"));
        assertEquals(-1, IsoscelesTriangle.CheckIsoscelesMax("-1 -1 10q -1 -1 10"));
        assertEquals(-1, IsoscelesTriangle.CheckIsoscelesMax("-1 -1 10 -1 -1 10 10"));
        assertEquals(-1, IsoscelesTriangle.CheckIsoscelesMax("-1 -1 10 -1 -1"));
        assertEquals(-1, IsoscelesTriangle.CheckIsoscelesMax(""));
        assertEquals(-1, IsoscelesTriangle.CheckIsoscelesMax(" "));
        assertEquals(-1, IsoscelesTriangle.CheckIsoscelesMax("0 0 0 0 0 0"));
        assertEquals(-1, IsoscelesTriangle.CheckIsoscelesMax("1 1 3 1 5 1"));
    }
}
