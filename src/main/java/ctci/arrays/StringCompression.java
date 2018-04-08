package ctci.arrays;

/**
 * Implement a method to perform basic string compression using the counts of repeated characters. For example,
 * the string aabccccaaa would become a2b1c5a3. If the compressed string would not become smaller than the originial string,
 * your method should return the original string. You can assume the string has only uppoercase and lowercase letters(a-z).
 */
public class StringCompression {

    public String compressString(String input){

        if(input==null)
            return null;

        int finalLength = countCompressionStringLength(input);
        if(input.length()<finalLength)
            return input;

        StringBuilder sb = new StringBuilder(finalLength);

        int index = 0;
        while(index<input.length()){
            char ch = input.charAt(index);
            sb.append(ch);
            int count = 1;
            while(index+1<input.length() && ch==input.charAt(index+1)){
                count++;
                index++;
            }
            sb.append(count);
            index++;
        }

        return sb.toString();


    }

    private int countCompressionStringLength(String input) {
        int compressedStringLength = 0;
        int index = 0;
        while(index<input.length()){
            char ch = input.charAt(index);
            compressedStringLength++;
            while(index+1<input.length() && ch==input.charAt(index+1)){
                index++;
            }
            compressedStringLength++;
            index++;
        }
        return compressedStringLength;
    }
}
