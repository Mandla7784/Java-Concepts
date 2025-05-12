package main.java;


import java.util.Objects;

/**
 * I was just preparing for a test im gonna write next week
 * about java syntax
 */
public class Practice {
    public static void main(String[] args) {
  //defining a string
        String string = "Big block nums";
        int count ;

        // converts string to lowercase
        string =string.toLowerCase();
        // splits
        String words[] = string.split(" ");

        for(int i = 0 ; i < words.length ; i ++){
            count = 1;
            for(int j = i + 1 ; j < words.length ; j ++){
                if(words[i].equals(words[j])){
                    count ++ ;
                    words[i] = "0";
                }
            }
            // displaying
            if(count > 1 && !Objects.equals(words[i], "0")){
                System.out.println(words[i]);
            }
        }



    }
}
