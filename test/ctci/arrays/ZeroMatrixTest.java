package ctci.arrays;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
public class ZeroMatrixTest {

    private final ZeroMatrix zeroMatrix = new ZeroMatrix();

    private int[][] input1x1 = {{1}};
    private int[][] expected1x1 = {{1}};

    private int[][] input2x2 = {{1,0},{1,1}};
    private int[][] expected2x2 = {{0,0},{1,0}};

    private int[][] input2x3 = {{1,0,1},{1,1,1}};
    private int[][] expected2x3 = {{0,0,0},{1,0,1}};

    private int[][] input3x3 = {{1,1,1},{1,1,1},{1,1,1}};
    private int[][] expected3x3 = {{1,1,1},{1,1,1},{1,1,1}};

    private int[][] input4x3 = {{1,1,1},{0,1,1},{1,1,0},{1,1,1}};
    private int[][] expected4x3 = {{0,1,0},{0,0,0},{0,0,0},{0,1,0}};

    @Test
    public void input1x1ShouldReturnExpected1x1(){
        int[][] actual = zeroMatrix.findZeroesMatrix(input1x1);
        assertArrayEquals("Expected should be equal to actual",expected1x1,actual);
    }


    @Test
    public void input2x2ShouldReturnExpected2x2(){
        int[][] actual = zeroMatrix.findZeroesMatrix(input2x2);
        assertArrayEquals("Expected should be equal to actual",expected2x2,actual);
    }

    @Test
    public void input2x3ShouldReturnExpected2x3(){
        int[][] actual = zeroMatrix.findZeroesMatrix(input2x3);
        assertArrayEquals("Expected should be equal to actual",expected2x3,actual);
    }

    @Test
    public void input3x3ShouldReturnExpected3x3(){
        int[][] actual = zeroMatrix.findZeroesMatrix(input3x3);
        assertArrayEquals("Expected should be equal to actual",expected3x3,actual);
    }

    @Test
    public void input4x3ShouldReturnExpected4x3(){
        int[][] actual = zeroMatrix.findZeroesMatrix(input4x3);
        assertArrayEquals("Expected should be equal to actual",expected4x3,actual);
    }

}