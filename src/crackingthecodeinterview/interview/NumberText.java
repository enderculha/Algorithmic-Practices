package crackingthecodeinterview.interview;

public class NumberText {

    public static void main(String[] args) {

        int input = 510465315;

        //String result =new NumberText().convertToSpeech(input);

        new NumberText().convertToSpeech2(input);

        //System.out.println(result);
    }

    public void convertToSpeech2(int input){

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
