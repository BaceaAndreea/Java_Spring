package Observers;
//
import Domain.Consultation;
import Domain.Patient;

import java.util.ArrayList;

public interface Observable {

    public void addObserver(Observer observer);
    public void removeObserver(Observer observer);

    void addObserver(Observers.Observer observer);

    void removeObserver(Observers.Observer observer);

    public void notifyObservers();
}
