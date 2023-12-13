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
public class Medication {
    @Id
    private int medicationID;
    private String name;
    private String administrationRoute;
    private int storageAmount;
    private String expirationDate;

    public void setMedicationID(int medicationID) {
        this.medicationID = medicationID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAdministrationRoute(String administrationRoute) {
        this.administrationRoute = administrationRoute;
    }

    public void setStorageAmount(int storageAmount) {
        this.storageAmount = storageAmount;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    @Override
    public String toString() {
        return "Medication{" +
                "medicationID=" + medicationID +
                ", name='" + name + '\'' +
                ", administrationRoute='" + administrationRoute + '\'' +
                ", storageAmount=" + storageAmount +
                ", expirationDate='" + expirationDate + '\'' +
                '}';
    }
}
