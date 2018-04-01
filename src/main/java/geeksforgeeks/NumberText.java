package geeksforgeeks;

public class NumberText {

    public static void main(String[] args) {

        long input = 124905123315L;

        String result = null;
        try {
            result = new NumberText().convertToWord(input);
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println(result);
    }

    public String convertToWord(long input) throws Exception {

        String[] arrayTwenty = {"", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten", "eleven", "twelve", "thirteen","fourteen","fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};
        String[] arrayTenPowers ={"", "ten", "twenty", "thirty", "fourty", "fifty", "sixty", "seventy", "eighty", "ninety"};

        if(input ==0)
            return "zero";

        if(input<0)
            throw new Exception();

        if(input<20){
            return arrayTwenty[(int) input];
        } else if(input <100){
            return arrayTenPowers[(int) (input/10)] +  " " + convertToWord(input%10) ;
        } else if(input <1000){
            return arrayTwenty[(int) (input/100)] + " hundred " + convertToWord(input%100);
        } else if(input <1000000){
            return convertToWord(input/1000) +  " thousand " + convertToWord(input%1000);
        } else if(input<1000000000){
            return convertToWord(input/1000000) + " million " + convertToWord(input%1000000);
        } else if(input<1000000000000L)
            return convertToWord(input/1000000000L) + " billion " + convertToWord(input%1000000000L);
        return null;

    }

    public String convertToSpeech(int input){
        String inputStr = String.valueOf(input);
        inputStr = new StringBuilder(inputStr).reverse().toString();
        StringBuilder sb = new StringBuilder();
        boolean isInTens = false;
        for(int i=inputStr.length()-1;i>=0;i--){
            char ch = inputStr.charAt(i);
            if(i%3 == 2){
                sb.append(convertADigitToText(ch));
                sb.append("hundred ");
            } else if(i%3==1){
                if(ch != '1')
                    sb.append(convertTensDigit(ch));
                else
                    isInTens = true;
            } else{
                if(!isInTens)
                    sb.append(convertADigitToText(ch));
                else
                    sb.append(convertSecondTenDigit(ch));
                sb.append(addSuffix(i));
                isInTens = false;
            }
        }

        return sb.toString();
    }

    private String addSuffix(int i){

        switch(i){
            case 9 : return "billion ";
            case 6 : return "million ";
            case 3 : return "thousand ";
            default: return "";
        }

    }

    private String convertADigitToText(char ch){
        switch (ch){
            case '1' : return "one ";

            case '2' : return "two ";

            case '3' : return "three ";

            case '4' : return "four ";

            case '5' : return "five ";

            case '6' : return "six ";

            case '7' : return "seven ";

            case '8' : return "eight ";

            case '9' : return "nine ";

        }
        return "";
    }


    private String convertTensDigit(char ch){

        switch (ch){

            case '2' : return "twenty ";

            case '3' : return "thirty ";

            case '4' : return "forthy ";

            case '5' : return "fifty ";

            case '6' : return "sixty ";

            case '7' : return "seventy ";

            case '8' : return "eighty ";

            case '9' : return "ninty ";

        }
        return "";
    }

    private String convertSecondTenDigit(char ch){

        switch (ch){

            case '0' : return "ten ";

            case '1' : return "eleven ";

            case '2' : return "twelve ";

            case '3' : return "thirteen ";

            case '4' : return "fourteen ";

            case '5' : return "fifteen ";

            case '6' : return "sixteen ";

            case '7' : return "seventeen ";

            case '8' : return "eighteen ";

            case '9' : return "nineteen ";


        }
        return "";
    }

}
