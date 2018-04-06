package geeksforgeeks;


import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class RottenOrangeTest {

    private final RottenOrange rottenOrange = new RottenOrange();

    @Test
    public void OrangesCanNotBeRottenWhenNullInputSet(){
        int[][] input = createInputSetNull();
        int result = rottenOrange.calculateMinTimeToRotAllOranges(input);
        assertThat("Result should be equal To -1",result, equalTo(-1));
    }

    @Test
    public void OrangesShouldBeRottenIn2RoundsForInputSet1(){

        int[][] input = createInputSet1();
        int result = rottenOrange.calculateMinTimeToRotAllOranges(input);
        assertThat("Result should be equal To 2",result, equalTo(2));
    }

    @Test
    public void OrangesCanNotBeRottenForInputSet2(){
        int[][] input = createInputSet2();
        int result = rottenOrange.calculateMinTimeToRotAllOranges(input);
        assertThat("Result should be equal To -1",result, equalTo(-1));
    }

    @Test
    public void OrangesShouldBeRottenIn8RoundsForInputSet3(){

        int[][] input = createInputSet3();
        int result = rottenOrange.calculateMinTimeToRotAllOranges(input);
        assertThat("Result should be equal To 8",result, equalTo(8));
    }




    private int[][] createInputSetNull(){
        int[][] arr = new int[][]{};

        return arr;
    }

    private int[][] createInputSet1(){
        int[][] arr = new int[][]{
                {2, 1, 0, 2, 1},
                {1, 0, 1, 2, 1},
                {1, 0, 0, 2, 1}};

        return arr;
    }

    private int[][] createInputSet2(){
        int[][] arr = new int[][]{
                {2, 1, 0, 2, 1},
                {0, 0, 1, 2, 1},
                {1, 0, 0, 2, 1}};

        return arr;
    }

    private int[][] createInputSet3(){
        int[][] arr = new int[][]{
                {2, 1, 1, 1, 1},
                {1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1}};

        return arr;
    }




}