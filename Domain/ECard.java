package map.project.demo.Domain;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Getter
@Entity
@Table
@NoArgsConstructor
@AllArgsConstructor
@Setter

public class ECard extends HealthCard{
    @Id
    private int electronicID;

    public ECard(String expirationDate, int pin, int electronicID) {
        super(expirationDate, pin);
        this.electronicID = electronicID;
    }

    @Override
    public String toString() {
        return "ECard{" +
                "electronicID=" + electronicID +
                "expirationDate=" + getExpirationDate() +
                "pin=" + getPin() +
                '}';
    }
}