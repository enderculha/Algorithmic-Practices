package datastructures.sorting;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Created by lenovo on 24.02.2018.
 */
public class GroupAnagrams {

    public static void main(String[] args) {

    }

    public static void groupAnagrams(String[] strings){

        Arrays.sort(strings, (s1,s2) -> sortChars(s1).compareToIgnoreCase(sortChars(s2)));
    }

    public static String sortChars(String input){
        char[] charInput = input.toCharArray();
        Arrays.sort(charInput);
        return new String(charInput);
    }

    public static void groupAnagramsbyHashMap(String[] strings){
        HashMap<String,List<String>> map = new HashMap<>();
        for(String s:strings){
            String key = sortChars(s);
            if(map.containsKey(key)){
                List<String> temp = map.get(key);
                temp.add(s);
                map.put(key,temp);
            }else{
                List<String> temp = new ArrayList<String>();
                temp.add(s);
                map.put(key,temp);
            }
        }
    }

}
