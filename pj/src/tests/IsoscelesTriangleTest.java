package tests;

import classes.IsoscelesTriangle;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class IsoscelesTriangleTest {
    @Test
    public void testCheckValues() {
        int[] expected1 = {0, 0, 1, 0, 0, 1};
        int[] expected2 = {-1, -1, 10, -1, -1, 10};
        assertArrayEquals(expected1, IsoscelesTriangle.checkValues("0 0 1 0 0 1"));
        assertArrayEquals(expected2, IsoscelesTriangle.checkValues("-1 -1 10 -1 -1 10"));
        assertArrayEquals(expected2, IsoscelesTriangle.checkValues("-1 -1 10 -1 -1 10 "));
        assertArrayEquals(expected2, IsoscelesTriangle.checkValues("-1 -1 10 -1 -1 10  "));
        assertNull(IsoscelesTriangle.checkValues(" -1 -1 10 -1 -1 10"));
        assertNull(IsoscelesTriangle.checkValues("-1 -1  10 -1 -1 10"));
        assertNull(IsoscelesTriangle.checkValues("-1 -1 10 -1 -1 10 10"));
        assertNull(IsoscelesTriangle.checkValues("-1 -1 10 -1 -1"));
        assertNull(IsoscelesTriangle.checkValues("-1 -1 10 -1 -1 10q"));
        assertNull(IsoscelesTriangle.checkValues(""));
        assertNull(IsoscelesTriangle.checkValues(" "));
    }

    @Test
    public void testCalculateIsoscelesTriangleArea() {
        assertEquals(60.499999999999986, IsoscelesTriangle.calculateIsoscelesTriangleArea(new int[] {-1, -1, 10, -1, -1, 10}));
        assertEquals(0.49999999999999983, IsoscelesTriangle.calculateIsoscelesTriangleArea(new int[] {0, 0, 1, 0, 0, 1}));
        assertEquals(-1, IsoscelesTriangle.calculateIsoscelesTriangleArea(new int[] {1, 1, 10, 1, 11, 1}));
        assertEquals(-1, IsoscelesTriangle.calculateIsoscelesTriangleArea(new int[] {1, 1, 10, 1, 13, 1}));
        assertEquals(-1, IsoscelesTriangle.calculateIsoscelesTriangleArea(new int[] {1, 1, 1, 1, 1, 1}));
        assertEquals(-1, IsoscelesTriangle.calculateIsoscelesTriangleArea(new int[] {1, 1, 2, 3, 4, 5}));
        assertEquals(-1, IsoscelesTriangle.calculateIsoscelesTriangleArea(new int[] {-1, -1, 3, 3, 6, 8}));
    }
}
