package geeksforgeeks;


import java.util.LinkedList;
import java.util.Queue;

/**
 * My solution to Rotten Orange Problem
 *
 * You are given a matrix of dimensions m*n where each cell in the matrix can have values 0,1 or 2 which has the following meaning :

 0:empty cell

 1:cells have fresh oranges

 2:cells have rotten oranges

 So we have to determine what is the minimum time required so that all the oranges will be rotten,assuming it takes one second to rot the immediate neighbours. A rotten orange at index [i,j] can rot other fresh orange at indexes [i+1,j] ,[i,j+1] ,[i-1,j] ,[i,j-1]. If it is impossible to rot every orange then simply return -1
 */

public class RottenOrange {

    public int calculateMinTimeToRotAllOranges(int[][] matrix){

        int rowSize = matrix.length;
        if(rowSize==0){
            //matrix is null
            return -1;
        }
        int columnSize = matrix[0].length;
        Queue<Cell> queue = new LinkedList<>();
        int minRound = -1;
        
        initializeQueue(queue, matrix);

        while(queue.peek()!=null){
            Cell temp = queue.poll();
            minRound = temp.round;
            if(temp.x-1>=0 && isCellFresh(temp.x-1, temp.y, matrix)){
                //Check right neighbor
                matrix = rottenCell(new Cell(temp.x-1,temp.y,temp.round+1),matrix,queue);
            }
            if(temp.y-1>=0 && isCellFresh(temp.x, temp.y-1, matrix)){
                //Check upper neighbor
                matrix = rottenCell(new Cell(temp.x,temp.y-1,temp.round+1),matrix,queue);
            }
            if(temp.x+1<rowSize && isCellFresh(temp.x+1, temp.y, matrix)){
                //Check left neighbor
                matrix = rottenCell(new Cell(temp.x+1,temp.y,temp.round+1),matrix,queue);
            }
            if(temp.y+1<columnSize && isCellFresh(temp.x, temp.y+1,matrix)){
                //Check down neighbor
                matrix = rottenCell(new Cell(temp.x,temp.y+1,temp.round+1),matrix,queue);
            }


        }

        return checkAll(matrix)?minRound:-1;
    }

    /**
     * Adds all rotten cells in the queue
     * @param queue
     * @param matrix
     *
     */
    private void initializeQueue(Queue<Cell> queue, int[][] matrix) {
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j]==CellEnum.ROTTEN.getEnumVal()){
                    Cell cell = new Cell(i,j);
                    queue.add(cell);
                }
            }
        }
    }

    private boolean isCellFresh(int xCord, int yCord, int[][] matrix){
        return matrix[xCord][yCord]==CellEnum.FRESH.getEnumVal();
    }

    /**
     * Rotten Cell and add to queue
     * @param cell
     * @param matrix
     * @param queue
     * @return
     */
    private int[][] rottenCell(Cell cell, int[][] matrix, Queue<Cell> queue ){
        queue.add(cell);
        matrix[cell.x][cell.y] = CellEnum.ROTTEN.getEnumVal();
        return matrix;
    }

    /**
     *  Check all matrix to control any fresh orange left
     * @param matrix
     * @return
     */
    private boolean checkAll(int[][] matrix){

        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j]==CellEnum.FRESH.getEnumVal()){
                    return  false;
                }
            }
        }
        return true;
    }
}

class Cell{

    public Cell(int x, int y){
        this.x = x;
        this.y = y;
    }

    public Cell(int x, int y, int round){
        this.x = x;
        this.y = y;
        this.round = round;
    }

    //coordinates
    int x;
    int y;

    //iteration round
    int round;
}

enum CellEnum{
    EMPTY(0), FRESH(1), ROTTEN(2);

    private final int enumVal;

    CellEnum(int val){
        enumVal = val;
    }

    public int getEnumVal(){
        return this.enumVal;
    }

}
