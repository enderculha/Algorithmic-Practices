package ctci.arrays;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class OneAwayTest {

    private final OneAway oneAway = new OneAway();

    @Test
    public void oneAwayShouldReturnTrueWhenForPaleAndPle(){
        String inp1 ="pale";
        String inp2 = "ple";

        boolean actual = oneAway.isOneAway(inp1,inp2);

        assertThat("Should return true", actual, equalTo(true));
    }

    @Test
    public void oneAwayShouldReturnTrueWhenForpalesAndpale(){
        String inp1 ="pales";
        String inp2 = "pale";

        boolean actual = oneAway.isOneAway(inp1,inp2);

        assertThat("Should return true", actual, equalTo(true));
    }

    @Test
    public void oneAwayShouldReturnTrueWhenForpaleAndbale(){
        String inp1 ="pale";
        String inp2 = "bale";

        boolean actual = oneAway.isOneAway(inp1,inp2);

        assertThat("Should return true", actual, equalTo(true));
    }

    @Test
    public void oneAwayShouldReturnFalseWhenForpaleAndbake(){
        String inp1 ="pale";
        String inp2 = "bake";

        boolean actual = oneAway.isOneAway(inp1,inp2);

        assertThat("Should return true", actual, equalTo(false));
    }


    @Test
    public void oneAwayShouldReturnFalseWhenForpaleAndpalete(){
        String inp1 ="pale";
        String inp2 = "palete";

        boolean actual = oneAway.isOneAway(inp1,inp2);

        assertThat("Should return false", actual, equalTo(false));
    }

    @Test
    public void oneAwayShouldReturnTrueWhenBothInputsAreNull(){
        boolean actual = oneAway.isOneAway(null,null);

        assertThat("Should return false", actual, equalTo(true));
    }

    @Test
    public void oneAwayShouldReturnfalseWhenOnlyOneInputIsNull(){

        boolean actual = oneAway.isOneAway("plea",null);

        assertThat("Should return false", actual, equalTo(false));

        actual = oneAway.isOneAway(null,"plea");

        assertThat("Should return false", actual, equalTo(false));
    }

    @Test
    public void oneAwayShouldReturnTrueWhenForeeefAndeeed(){
        String inp1 ="eeef";
        String inp2 = "eeed";

        boolean actual = oneAway.isOneAway(inp1,inp2);

        assertThat("Should return true", actual, equalTo(true));
    }

    @Test
    public void oneAwayShouldReturnFalseWhenForalepAndpale(){
        String inp1 ="alep";
        String inp2 = "pale";

        boolean actual = oneAway.isOneAway(inp1,inp2);

        assertThat("Should return true", actual, equalTo(false));
    }

    @Test
    public void oneAwayShouldReturnFalseWhenForalepaAndpale(){
        String inp1 ="alepa";
        String inp2 = "pale";

        boolean actual = oneAway.isOneAway(inp1,inp2);

        assertThat("Should return true", actual, equalTo(false));
    }


}