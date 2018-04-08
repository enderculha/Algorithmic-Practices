package ctci.arrays;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class MatrixRotationTest {

    private final MatrixRotation matrixRotation = new MatrixRotation();

    @Test
    public void matrixShouldBeRotated90degreesClockwise(){
        int [][] matrix = createInputMatrix();

        int[][] actual = matrixRotation.rotateMatrix90ClockWise(matrix);
        int[][] expected = createOutputMatrix();

        for(int i=0;i<matrix.length;i++){
            assertArrayEquals("rows should be equal", actual[i], expected[i]);
        }

    }

    private int[][] createInputMatrix() {
        int[][] matrix = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};

        return matrix;
    }

    private int[][] createOutputMatrix() {
        int[][] matrix = new int[][]{{7,4,1}, {8,5,2}, {9,6,3}};

        return matrix;
    }


}