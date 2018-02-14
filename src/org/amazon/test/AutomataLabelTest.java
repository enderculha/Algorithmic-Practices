package org.amazon.test;

import org.amazon.src.AutomataLabel;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.*;


public class AutomataLabelTest {
    final  AutomataLabel automataLabel = new AutomataLabel();

    @Test
    public void labelProductBruteForceTestCase1(){
        List<String> tagList = new ArrayList<>(Arrays.asList("made", "in", "spain"));
        List<String> availableTagList = new ArrayList<>(Arrays.asList("made", "weather","Forecast" ,
                "says", "that" , "made" , "rain" , "in" , "Spain" , "stays"));
        List<Integer> actual = automataLabel.labelProductBruteForce(tagList, availableTagList);
        List<Integer> expected = new ArrayList<>(Arrays.asList(5,8));

        assertThat("Expected and actual should be equal", actual, equalTo(expected));
    }

    @Test
    public void labelProductBruteForceTestCase2(){
        List<String> tagList = new ArrayList<>(Arrays.asList("2abc", "bcd", "cab"));
        List<String> availableTagList = new ArrayList<>(Arrays.asList("dbc", "2abc","cab" ,
                "bcd", "bcb"));
        List<Integer> actual = automataLabel.labelProductBruteForce(tagList, availableTagList);
        List<Integer> expected = new ArrayList<>(Arrays.asList(1,3));

        assertThat("Expected and actual should be equal", actual, equalTo(expected));
    }

    @Test
    public void labelProductBruteForceTestCase3(){
        List<String> tagList = new ArrayList<>(Arrays.asList("in", "the", "spain"));
        List<String> availableTagList = new ArrayList<>(Arrays.asList("the", "spain","that" ,
                "the", "rain" , "in" , "spain" , "stays" , "forecast" , "in", "the"));
        List<Integer> actual = automataLabel.labelProductBruteForce(tagList, availableTagList);
        List<Integer> expected = new ArrayList<>(Arrays.asList(3,6));

        assertThat("Expected and actual should be equal", actual, equalTo(expected));
    }

    @Test
    public void labelProductBruteForceTestCase4(){
        List<String> tagList = new ArrayList<>(Arrays.asList("in", "the", "spain"));
        List<String> availableTagList = new ArrayList<>(Arrays.asList("in", "the", "del", "ab"));
        List<Integer> actual = automataLabel.labelProductBruteForce(tagList, availableTagList);
        List<Integer> expected = new ArrayList<>(Arrays.asList(0));

        assertThat("Expected and actual should be equal", actual, equalTo(expected));
    }

    @Test
    public void labelProductEfficientTestCase1(){
        List<String> tagList = new ArrayList<>(Arrays.asList("made", "in", "spain"));
        List<String> availableTagList = new ArrayList<>(Arrays.asList("made", "weather","Forecast" ,
                "says", "that" , "made" , "rain" , "in" , "Spain" , "stays"));
        List<Integer> actual = automataLabel.labelProductEfficient(tagList, availableTagList);
        List<Integer> expected = new ArrayList<>(Arrays.asList(5,8));

        assertThat("Expected and actual should be equal", actual, equalTo(expected));
    }

    @Test
    public void labelProductEfficientTestCase2(){
        List<String> tagList = new ArrayList<>(Arrays.asList("2abc", "bcd", "cab"));
        List<String> availableTagList = new ArrayList<>(Arrays.asList("dbc", "2abc","cab" ,
                "bcd", "bcb"));
        List<Integer> actual = automataLabel.labelProductEfficient(tagList, availableTagList);
        List<Integer> expected = new ArrayList<>(Arrays.asList(1,3));

        assertThat("Expected and actual should be equal", actual, equalTo(expected));
    }

    @Test
    public void labelProductEfficientTestCase3(){
        List<String> tagList = new ArrayList<>(Arrays.asList("in", "the", "spain"));
        List<String> availableTagList = new ArrayList<>(Arrays.asList("the", "spain","that" ,
                "the", "rain" , "in" , "spain" , "stays" , "forecast" , "in", "the"));
        List<Integer> actual = automataLabel.labelProductEfficient(tagList, availableTagList);
        List<Integer> expected = new ArrayList<>(Arrays.asList(3,6));

        assertThat("Expected and actual should be equal", actual, equalTo(expected));
    }

    @Test
    public void labelProductEfficientTestCase4(){
        List<String> tagList = new ArrayList<>(Arrays.asList("in", "the", "spain"));
        List<String> availableTagList = new ArrayList<>(Arrays.asList("in", "the", "del", "ab"));
        List<Integer> actual = automataLabel.labelProductEfficient(tagList, availableTagList);
        List<Integer> expected = new ArrayList<>(Arrays.asList(0));

        assertThat("Expected and actual should be equal", actual, equalTo(expected));
    }




}
