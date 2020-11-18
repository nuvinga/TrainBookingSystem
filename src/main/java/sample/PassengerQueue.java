package sample;

import java.util.Scanner;

public class PassengerQueue {

    private Passenger[] queueArray = new Passenger[10];
    private int first;
    private int last;
    private int maxStayInQueue;
    private int maxLength;
    private int shortestStay=1000;
    private int longestStay=0;
    private int totalTime;
    private int longestLength;

    public void add (Passenger next){ //Setter
        if (isFull()){
            System.out.println("Train queue is full");
        }else{
            for (int numOne = 0; numOne < maxLength-1; numOne++) {  // Using classical bubble sort
                for (int numTwo = numOne + 1; numTwo < maxLength-1; numTwo++) {
                    // comparing adjacent strings
                    int one= Integer.parseInt(queueArray[numOne].getSeat());
                    int two= Integer.parseInt(queueArray[numTwo].getSeat());
                    if (two<one) {
                        Passenger cache = queueArray[numTwo];  // sorting the seats according to
                        queueArray[numTwo] = queueArray[numOne];
                        queueArray[numOne] = cache;
                    }
                }
            }
            queueArray[last] = next;
            last++;
            maxLength++;
            longestLength++;
        }
    }

    public Passenger remove(){  //Setter
        Passenger current = queueArray[first];
        if (isEmpty()) {
            System.out.println("Train queue is empty");
        }else{
            for (int numOne = 0; numOne < 9; numOne++) {  // Using classical bubble sort
                if (queueArray[numOne+1]!=null) {
                    queueArray[numOne] = queueArray[numOne + 1];
                    queueArray[numOne + 1]=null; // passing the null value to the next available slot
                }else{
                    queueArray[numOne]=null;
                }
            }
            maxLength--;
            last--;
        }
        return current;
    }

    public String accessName(int index){
        return queueArray[index].getFullName();  // accessing the full name through the queue array
    }

    public boolean delete(String name){
        Scanner input = new Scanner(System.in);
        for (int traverse=0;traverse<10;traverse++){
            if (queueArray[traverse]!=null) {
                if (queueArray[traverse].getName().toLowerCase().contains(name) || queueArray[traverse].getId().contains(name)) {
                    System.out.println("Your name/Unique ID has been detected on seat number "+queueArray[traverse].getSeat());
                    System.out.println("Are you sure to delete the entry? (Yes/No)");
                    String choice = input.next().toLowerCase();
                    switch (choice){
                        case "yes":
                            System.out.println("Process:Successful- Deleted");
                            queueArray[traverse].setAdded(false);
                            queueArray[traverse]=null;
                            for (int numOne = traverse; numOne < 9; numOne++) {  // Using classical bubble sort
                                if (queueArray[numOne+1]!=null) {
                                    queueArray[numOne] = queueArray[numOne + 1];
                                    queueArray[numOne + 1]=null;
                                }
                            }
                            maxLength--;
                            last--;
                            return true;
                        case "no":
                            System.out.println("Process:Terminated- Not Deleted");
                            return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean isEmpty(){  //Getter
        return last == first;
    }

    public boolean isFull(){  //Getter
        return maxLength == 10;
    }

    public void display(){  //Getter
        if (isEmpty()) {
            System.out.println("Empty Train Queue.");
        }else{
            System.out.println("Items:  ");
            for (int i=0;i<maxLength;i++){
                System.out.println(queueArray[i].getName());
            }
        }
        System.out.println(" ");
    }

    public int getLength(){
        return maxLength;
    }

    public int getMaxStay(){  //Getter
        return totalTime;
    }

    public Object getQueue(){
        return queueArray;
    }

    public void setQueue(Passenger[] temp){
        queueArray = temp;
        int count=0;
        for (Passenger passenger : queueArray) {
            if (passenger != null) {
                count++;
            }
        }
        maxLength=count;
        last=maxLength-1;
    }

    public void setTime(int time){
        maxStayInQueue+=time;
        queueArray[last-1].setSecondsInQueue(maxStayInQueue);

        if (time>longestStay){
            longestStay=time;
        }
        if (time<shortestStay){
            shortestStay=time;
        }
    }

    public int getShortestStay(){
        return shortestStay;
    }

    public int getLongestStay(){
        totalTime=longestStay;
        return longestStay;
    }

    public int getLongestLength(){
        return longestLength;
    }

    public int getAverage(){
        return longestStay/longestLength;
    }

    public Object storeAdditionalAll(){
        int[] essentials = new int[8];
        essentials[0]=first;
        essentials[1]=last;
        essentials[2]=maxStayInQueue;
        essentials[3]=maxLength;
        essentials[4]=shortestStay;
        essentials[5]=longestStay;
        essentials[6]=totalTime;
        essentials[7]=longestLength;
        return essentials;
    }

    public void initialize(int[] essentials){
        first=essentials[0];
        last=essentials[1];
        maxStayInQueue=essentials[2];
        maxLength=essentials[3];
        shortestStay=essentials[4];
        longestStay=essentials[5];
        totalTime=essentials[6];
        longestLength=essentials[7];
    }

}