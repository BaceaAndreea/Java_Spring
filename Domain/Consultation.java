package map.project.demo.Domain;

import Observers.Observable;
import Observers.Observer;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter

public class Consultation implements Observable {
    @Id
    private int patientID;
    @Id
    private int doctorID;
    @Id
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private String date;
    @Id
    private int diseaseID;
    private boolean card;
    private int price;
    private ArrayList<Observer> observers;

    public void setPatientID(int patientID) {
        this.patientID = patientID;
    }

    public void setDoctorID(int doctorID) {
        this.doctorID = doctorID;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setDiseaseID(int diseaseID) {
        this.diseaseID = diseaseID;
    }

    public boolean isCard() {
        return card;
    }

    public void setCard(boolean card) {
        this.card = card;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Consultation{" +
                "patientID=" + patientID +
                ", doctorID=" + doctorID +
                ", date='" + date + '\'' +
                ", diseaseID=" + diseaseID +
                ", card=" + card +
                ", price=" + price +
                '}';
    }


    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer){
        observers.remove(observer);
    }
    @Override
    public void notifyObservers(){
        for(Observer observer  : observers){
            observer.updateObservers(this.patientID);
        }
    }
}
