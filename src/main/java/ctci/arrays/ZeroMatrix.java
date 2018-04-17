package ctci.arrays;

/**
 * Write an algorithm such that if an element in an MxN matrix is 0, its entire row and column are set to 0.
 */
public class ZeroMatrix {

    /**
     * O(1) Space Solution
     * Use first row and column as a replacement rows and columns
     * Check first row and column if there is a 0, since we will be changing it.
     * Iterate through the matrix, if there is 0, set first column and row of this matrix 0.
     * Iterate through the matrix again, if first column or zero is 0, set 0.
     * if first row and/or column is 0, set all first row and/or column zero.
     * @param input
     * @return
     */
    public int[][] findZeroesMatrix(int[][] input){
        int rowSize = input.length;
        int columnSize = input[0].length;
        boolean setFirstColumnZero = false;
        boolean setFirstRowZero = false;

        for(int i=0;i<rowSize;i++){
            if(input[i][0]==0){
                setFirstColumnZero = true;
                break;
            }
        }

        for(int i=0;i<columnSize;i++){
            if(input[0][i]==0){
                setFirstRowZero = true;
                break;
            }
        }

        for(int i=1;i<rowSize;i++){
            for(int j=1;j<columnSize;j++){
                if(input[i][j] == 0){
                    input[0][j] = 0;
                    input[i][0] = 0;
                }
            }
        }

        for(int i=1;i<rowSize;i++){
            for(int j=1;j<columnSize;j++){
                if(input[0][j]==0 || input[i][0]==0)
                    input[i][j] = 0;
            }
        }

        if(setFirstColumnZero){
            for(int i=0;i<rowSize;i++){
                input[i][0] = 0;
            }
        }

        if(setFirstRowZero){
            for(int i=0;i<columnSize;i++){
                input[0][i] = 0;
            }
        }
        return  input;
    }

    public int[][] findZeroesMatrixWorse(int[][] input){
        int rowSize = input.length;
        int columnSize = input[0].length;

        boolean[] rowsZero = new boolean[rowSize];
        boolean[] columnZero = new boolean[columnSize];

        for(int i=0;i<rowSize;i++){
            for(int j=0;j<columnSize;j++){
                if(input[i][j]==0){
                    rowsZero[i] = true;
                    columnZero[j] = true;
                }
            }
        }

        for(int i=0;i<rowSize;i++){
            if(rowsZero[i])
                input = nullifyColumns(input, i);
        }

        for(int i=0;i<columnSize;i++){
            if(columnZero[i])
                input = nullifyRows(input, i);
        }
        return input;
    }

    private int[][] nullifyColumns(int[][] input, int row) {
        for(int i=0;i<input[0].length;i++){
            input[row][i] = 0;
        }
        return input;
    }

    private int[][] nullifyRows(int[][] input, int column) {

        for(int i=0;i<input.length;i++){
            input[i][column] = 0;
        }
        return input;
    }
}
