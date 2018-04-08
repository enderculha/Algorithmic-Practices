package geeksforgeeks;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class MinimumSizeSubArraySizeTest {

    private final MinimumSizeSubArraySize minimumSizeSubArraySize = new MinimumSizeSubArraySize();

    @Test
    public void testForInputSet1AndTarget51(){
        int[] input = createInputSet1();
        int target = 51;
        int[] expected = new int[]{4,45,6};
        int[] actual = minimumSizeSubArraySize.findMinimumSubarraySumsToTarget(input,target);
        assertArrayEquals("Arrays should be equal", expected,actual);

    }

    @Test
    public void testForInputSet2AndTarget9(){
        int[] input = createInputSet2();
        int target = 9;
        int[] expected = new int[]{10};
        int[] actual = minimumSizeSubArraySize.findMinimumSubarraySumsToTarget(input,target);
        assertArrayEquals("Arrays should be equal", expected,actual);

    }

    @Test
    public void testForInputSet3AndTarget280(){
        int[] input = createInputSet3();
        int target = 280;
        int[] expected = new int[]{100,1,0,200};
        int[] actual = minimumSizeSubArraySize.findMinimumSubarraySumsToTarget(input,target);
        assertArrayEquals("Arrays should be equal", expected,actual);

    }

    @Test
    public void testForInputSet4AndTarget8(){
        int[] input = createInputSet4();
        int target = 8;
        int[] expected = new int[]{0};
        int[] actual = minimumSizeSubArraySize.findMinimumSubarraySumsToTarget(input,target);
        assertArrayEquals("Arrays should be equal", expected,actual);

    }

    @Test
    public void testForInputSet5AndTarget1000(){
        int[] input = createInputSet5();
        int target = 1000;
        int[] expected = new int[]{0};
        int[] actual = minimumSizeSubArraySize.findMinimumSubarraySumsToTarget(input,target);
        assertArrayEquals("Arrays should be equal", expected,actual);

    }

    private int[] createInputSet1(){
        int[] arr = new int[]{1, 4, 45, 6, 0, 19};
        return arr;
    }

    private int[] createInputSet2(){
        int[] arr = new int[]{1, 10, 5, 2, 7};
        return arr;
    }

    private int[] createInputSet3(){
        int[] arr = new int[]{1, 11, 100, 1, 0, 200, 3, 2, 1, 250};
        return arr;
    }

    private int[] createInputSet4(){
        int[] arr = new int[]{1, 2, 4};
        return arr;
    }

    private int[] createInputSet5(){
        int[] arr = new int[]{1, 2, 4,8,10,22,67};
        return arr;
    }







}