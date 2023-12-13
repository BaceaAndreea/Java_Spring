package map.project.demo.Domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Entity
@Table
@NoArgsConstructor
@AllArgsConstructor
@Setter

public class Surgery {
    @Id
    private int patientID, doctorID;
    @Id
    private String date;
    @Id
    private int diseaseID;
    private String name;
    private int medicationID;

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

    public void setName(String name) {
        this.name = name;
    }

    public void setMedicationID(int medicationID) {
        this.medicationID = medicationID;
    }

    @Override
    public String toString() {
        return "Surgery{" +
                "patientID=" + patientID +
                ", doctorID=" + doctorID +
                ", date='" + date + '\'' +
                ", diseaseID=" + diseaseID +
                ", name='" + name + '\'' +
                ", medicationID=" + medicationID +
                '}';
    }
}