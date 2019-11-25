package dssc.calculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StringCalculator {






    public static int add(String numbers) {

        String delimiter = ",";

        if(numbers.contains("//")){
            delimiter = Character.toString(numbers.charAt(2));
            numbers = numbers.substring(4);
        }

        numbers = numbers.replace("\n", delimiter);



        if(numbers.isEmpty()){
            return 0;
        }
        else if(numbers.contains(delimiter)){
            String[] tokens = numbers.split(delimiter);
            checkForNegatives(tokens);
            int tot = 0;
            for(String num : tokens){
                Integer val = Integer.valueOf(num);
                if(val <= 1000) tot += val;
            }
            return tot;
        }
        else{
            Integer val = Integer.valueOf(numbers);
            try{
                if(val<0) throw new Exception();


            } catch (Exception e) {
                System.out.println("Negatives not allowed \nYou inserted the following negative number:");
                System.out.println(val);
            }

            return val;

        }


    }

    private static void checkForNegatives(String[] tokens)  {
        Stream<String> elem = Arrays.stream(tokens);
        List<String> negatives = elem.filter(x -> Integer.valueOf(x)<0).collect(Collectors.toList());
        try{
            if(!negatives.isEmpty()) throw new Exception();
        } catch (Exception e) {
            System.out.println("Negatives not allowed \nYou inserted the following negative numbers:");
            for(String num: negatives){
                System.out.println(num);
            }
        }
    }

}
