package ctci.arrays;

/**
 * Given an image represented by an NxN matrix, where each pixel in the image is 4 bytes, write a method to rotate to rotate
 * image by 90 degrees
 */
public class MatrixRotation {

    public int[][] rotateMatrix90ClockWise(int [][] matrix){

        int[][] transposed = transposeMatrix(matrix);
        int[][] reflected = reflectVertically(transposed);

        return reflected;

    }

    private int[][] reflectVertically(int[][] matrix) {
        int start = 0;
        int end = matrix.length-1;

        while(start<end){
            for(int i=0;i<matrix.length;i++){
                int temp =matrix[i][start];
                matrix[i][start] = matrix[i][end];
                matrix[i][end] = temp;
            }
            start++;
            end--;
        }
        return matrix;
    }

    private int[][] transposeMatrix(int[][] matrix) {
        for(int i=0;i<matrix.length;i++){
            for(int j=i+1;j<matrix.length;j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        return matrix;
    }
}
