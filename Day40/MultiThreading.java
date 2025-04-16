// package Day40;

public class MultiThreading {
    public static void main(String[] args) {
        int[] arr={1,2,3,4};
        sortingThread sort = new sortingThread(arr);
        Thread t1 = new Thread(sort);
        t1.start();
        
        searchingThread search = new searchingThread(arr);
        Thread t2 = new Thread(search);
        t2.start();

        
        printingThread print = new printingThread(arr);
        Thread t3 = new Thread(print);
        t3.start();
    }

    
}
class sortingThread implements Runnable{
    int[] arr;
    sortingThread(int[] arr){
        this.arr=arr;
    }
    public void run(){
        System.out.println("Array sorted");
    }
}
class searchingThread implements Runnable{
    int[] arr;
    searchingThread(int[] arr){
        this.arr=arr;
    }
    public void run(){
        System.out.println("Array being searched");
    }
}
class printingThread implements Runnable{
    int[] arr;
    printingThread(int[] arr){
        this.arr=arr;
    }
    public void run(){
        System.out.println("ArrayPrin");
    }
}