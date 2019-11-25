package dssc.calculator;

public class StringCalculator {

    public static int add(String numbers) {

        numbers = numbers.replace("\n", ",");

        if(numbers.isEmpty()){
            return 0;
        }
        else if(numbers.contains(",")){
            String[] tokens = numbers.split(",");
            int tot = 0;
            for(String num : tokens){
                tot += Integer.valueOf(num);
            }
            return tot;
        }
        else{
            return Integer.valueOf(numbers);
        }


    }
}
