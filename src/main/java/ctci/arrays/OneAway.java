package ctci.arrays;

/**
 * Is One Away:
 * There are three types of edits that can be performed on strings: insert a character, remove a character, or replace a character
 * Given two strings, write a function to check if they are one edit or zero edits away
 *
 * pale, ple -> true
 * pales, pale -> true
 * pale, bale -> true
 * pale, bake -> false
 *
 * Solution Complexity:
 * inp1 length = m
 * inp2 length = n
 * O(m+n)
 * */
public class OneAway {

    public boolean isOneAway(String inp1, String inp2) {
        if(inp1==null&& inp2 ==null)
            return true;

        if(inp1== null & inp2!= null)
            return false;

        if(inp2==null && inp1!=null)
            return false;

        if(inp1.length() == inp2.length())
            return checkOneReplace(inp1,inp2);
         else if(inp1.length() + 1 == inp2.length())
            return checkOneInsert(inp1, inp2);
        else if (inp1.length() == inp2.length()+1)
            return checkOneInsert(inp2, inp1);

        return false;
    }

    private boolean checkOneReplace(String inp1, String inp2) {
        boolean found = false;
        for(int i=0;i<inp2.length();i++){
            if(inp1.charAt(i)!= inp2.charAt(i)) {
                if (found)
                    return false;
                found = true;
            }
        }
        return true;
    }

    private boolean checkOneInsert(String inp1, String inp2) {
        int index1 = 0;
        int index2 = 0;
        while(index2<inp1.length()){
            if(inp1.charAt(index1)!=inp2.charAt(index2)){
                if(index1!= index2)
                    return false;
                index2 ++;
            }else{
                index1++;
                index2++;
            }
        }
        return true;
    }
}
