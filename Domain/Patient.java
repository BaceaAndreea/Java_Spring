package map.project.demo.Domain;
import Iterator.PatientIterator;
import Observers.Observer;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
@Getter
@Entity
@Table
@NoArgsConstructor
@AllArgsConstructor
@Setter
public class Patient{
    @Id
    private int patientID;
    private String name;
    private String firstName;
    private String birthdate;
    private String contactPhone;
    private int cardID;

    public void setCardID(int cardID) {
        this.cardID = cardID;
    }

    public void setPatientID(int patientID) {
        this.patientID = patientID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "patientID=" + patientID +
                ", name='" + name + '\'' +
                ", firstName='" + firstName + '\'' +
                ", birthdate='" + birthdate + '\'' +
                ", contactPhone='" + contactPhone + '\'' +
                ", cardID=" + cardID +
                '}';
    }

}