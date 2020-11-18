package sample;

import java.io.Serializable;

public class Passenger implements Serializable {

    private String firstName;
    private String surname;
    private String uniqueId;
    private String seatNumber;
    private boolean addedQueue;
    private int secondsInQueue=1;

    public Passenger(String firstName, String surname, String uniqueId, String seatNumber) {
        super();
        this.uniqueId=uniqueId;
        this.seatNumber=seatNumber;
        setName(firstName, surname);
    }


    public String getName() {
        return firstName;
    }

    public String getId(){
        return uniqueId;
    }

    public String getSeat(){
        return seatNumber;
    }

    public String getFullName(){
        firstName=firstName.substring(0,1).toUpperCase()+firstName.substring(1);
        surname=surname.substring(0,1).toUpperCase()+surname.substring(1);
        return firstName+" "+surname;
    }

    public void setName(String name, String secondName) {
        this.firstName=name;
        this.surname=secondName;
    }

    public void setAdded(boolean addedQueue){
        this.addedQueue=addedQueue;
    }

    public boolean getAdded(){
        return addedQueue;
    }

    public int getSeconds() {
        return secondsInQueue;
    }

    public void setSecondsInQueue(int sec) {
        this.secondsInQueue=sec;
    }

    public void display() {

    }

}
