package fr.norsys.stringcalculator;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

class Clazz{
    int add(String numbers) throws Exception {
        if(numbers.isEmpty()){
            return 0;
        }
        if(numbers.length() == 1){
            return Integer.parseInt(numbers);
        }
        else{
            if(numbers.substring(0, 2).equals("//")){
                String[] str1 = numbers.split("\n");
                if(str1.length == 2){
                    String[] strDelimiter = str1[0].split("//");
                    String delimeter = strDelimiter[0];
                    System.out.println(strDelimiter[0]);
                    String[] str3 = str1[1].split(delimeter);
                    int[] integers = new int[str3.length];
                    int sum = 0;
                    List<Integer> list = new ArrayList<>();
                    for(int i=0; i<str3.length; i++){
                        integers[i] = Integer.parseInt(str3[i]);
                        if(integers[i] < 0){
                            list.add(integers[i]);
                        }
                        sum += integers[i];
                    }
                    if(list.size() != 0){
                        String result = list.stream()
                                .map(Object::toString) // Convertir chaque nombre en chaîne de caractères
                                .collect(Collectors.joining(","));
                        throw new Exception("negatives not allowed"+ result);
                    }
                    return sum;
                }
                else{
                    return 0;
                }

            }
            else{
                String[] str = numbers.split("[,\n]");
                int[] integers = new int[str.length];
                int sum = 0;
                for(int i=0; i<str.length; i++){
                    integers[i] = Integer.parseInt(str[i]);
                    sum += integers[i];
                }
                return sum;
            }

        }

    }
}