package ctci.arrays;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
public class StringCompressionTest {

    private final StringCompression compression = new StringCompression();

    @Test
    public void nullInputShouldReturnNull(){
        String actual = compression.compressString(null);
        assertThat("null should return null", actual, equalTo(null));
    }

    @Test
    public void aShouldCompressToa(){
        String actual = compression.compressString("a");
        assertThat(" a should return a", actual, equalTo("a"));
    }

    @Test
    public void capitalAShouldCompressTocapitalA(){
        String actual = compression.compressString("A");
        assertThat(" A should return A", actual, equalTo("A"));
    }

    @Test
    public void aaaaaShouldCompressToa5(){
        String actual = compression.compressString("aaaaa");
        assertThat(" aaaaa should return a5", actual, equalTo("a5"));
    }

    @Test
    public void AAAAAShouldCompressToA5(){
        String actual = compression.compressString("AAAAA");
        assertThat(" AAAAA should return A5", actual, equalTo("A5"));
    }

    @Test
    public void aaaaabShouldCompressToa5b1(){
        String actual = compression.compressString("aaaaab");
        assertThat(" aaaaab should return a5b1", actual, equalTo("a5b1"));
    }

    @Test
    public void aabcccccaaaShouldCompressToa2b1c5a3(){
        String actual = compression.compressString("aabcccccaaa");
        assertThat(" aabcccccaaa should return a2b1c5a3", actual, equalTo("a2b1c5a3"));
    }

    @Test
    public void AABCCCCAAAShouldCompressToA2B1C5A3(){
        String actual = compression.compressString("AABCCCCCAAA");
        assertThat(" AABCCCCAAA should return A2B1C5A3", actual, equalTo("A2B1C5A3"));
    }


}