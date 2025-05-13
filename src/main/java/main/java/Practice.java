package main.java;

import java.util.ArrayList;
import java.util.Random;

/**
 * I was just preparing for a test im gonna write next week
 * about java syntax
 */
public class Practice {
    public static void main(String[] args) {
//    duplicates();
//    missingNumber();
//    randomNumbers(1,100);
//    swapingTwoStrings();
  movingXeros(new int[]{1, 2, 0, 4, 3, 0, 5, 0});

    }
    public static   void duplicates(){
        String string = "Big black bug bit a big black dog on his big black nose";
        string = string.toLowerCase();

        String[] words = string.split(" ");
        int count;

        for (int i = 0; i < words.length; i++) {
            if (words[i].equals("0")) continue; // skip already marked
            count = 1;

            for (int j = i + 1; j < words.length; j++) {
                if (words[i].equals(words[j])) {
                    count++;
                    words[j] = "0"; // mark as counted
                }
            }
            if (count > 1) {
                System.out.println(words[i]);
            }

        }
    }

    public  static  void missingNumber(){
      int numbers []  =new int[]{1,2,3,4,6,7,8};
      int n = 8; // last number
        int exepected_sum = n *((n + 1) / 2);

        short actual_sum = 0;

        for(int i = 0 ; i < numbers.length ; i ++){
            actual_sum += numbers[i];
        }
          int missing_num = exepected_sum - actual_sum;
        System.out.println(missing_num);
    }


    public  static  void  randomNumbers(int min_range_num , int max_range){
        Random random = new Random();
        short random_num = 0;
        for(int  i = min_range_num ; i <= max_range; i++){
            random_num = (short) random.nextInt(i);
        }
        System.out.println("The random numebr between" + min_range_num +  " and" + max_range + " is :" + random_num);
    }
    public  static  void swapingTwoStrings(){
        String  str1,str2;
        str2 = "world";
        str1 = "hello";
       str1  = str1 + str2;
       str2 = str1.substring(0 , str1.length() - str2.length());
       /// //
        str1 = str1.substring(str2.length());
        System.out.println("Strings after swap: a = " + str1 + " and b = " + str2);
    }
    public  static void   movingXeros(int arr[]){
           ArrayList<Integer > cloned_arr = new ArrayList<>();
        for(int i = 0 ; i  < arr.length ; i ++){
            cloned_arr.add(arr[i]);
        }
        System.out.println(cloned_arr);
        ArrayList<Integer> temp_arr = new ArrayList<Integer>();
        for(int i = 0 ; i  < cloned_arr.size() ; i ++){
            if(cloned_arr.get(i) == 0){
                cloned_arr.remove(cloned_arr.get(i));
                temp_arr.add(i);

            }else{
                break;
            }
        }
        System.out.println(temp_arr);


    }

}
