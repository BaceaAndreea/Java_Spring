package map.project.demo.Domain;

import lombok.*;
import map.project.demo.Observers.Observable;
import map.project.demo.Observers.Observer;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString

public class Consultation{// implements Observable {
    @Id
    private int patientID;
    @Id
    private int doctorID;
    @Id
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private String date;
    private int diseaseID;
    private boolean card;
    private int price;


//    //private ArrayList<Observer> observers = new ArrayList<>();
//
//    @Override
//    public void addObserver(Observer observer) {
//        observers.add(observer);
//    }
//
//    @Override
//    public void removeObserver(Observer observer){
//        observers.remove(observer);
//    }
//
//    @Override
//    public void notifyObservers(){
//        for(Observer observer  : observers){
//            observer.updateObservers(this.patientID);
//        }
//    }
}
