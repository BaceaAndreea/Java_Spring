package map.project.demo.Domain;

import map.project.demo.Iterator.PatientIterator;

import java.util.ArrayList;
import java.util.List;


public class PatientIteratorImpl implements PatientIterator<Patient> {
    private List<Patient> patients;
    private int index;

    public PatientIteratorImpl(List<Patient> patients) {
        this.patients = patients;
        this.index = 0;
    }

    @Override
    public boolean hasNext() {
        return index < patients.size();
    }

    @Override
    public Patient next() {
        if (this.hasNext()) {
            return patients.get(index++);
        }
        return null;
    }
}
