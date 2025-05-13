package main.java;

public class TaskEvenOdd  {
    private  int number = 1;
    private  final  int limit;

    public  TaskEvenOdd(int limit){
        this.limit = limit;

    }

    public  synchronized  void  printEven(){
        while (number <= limit){
            if(number %2 == 0){
                System.out.println("Eben: " + number);
                number++;
                notify();
            }else{
                try {
                    wait();
                }catch (InterruptedException e){
                    Thread.currentThread().interrupt();
                }

            }
        }
    }
    public  synchronized  void  printOdd(){
        while(number <= limit){
            if(number %2 != 0){
                System.out.println("Odd : " + number);
                number ++;
                notify();
            }else{
                try {
                    wait();
                }catch (InterruptedException e){
                    Thread.currentThread().interrupt();
                }
            }
        }
    }

}

