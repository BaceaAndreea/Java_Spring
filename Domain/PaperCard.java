package map.project.demo.Domain;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Table
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter

public class PaperCard extends HealthCard {
    @Id
    private int writtenID;

    public PaperCard(String expirationDate, int pin, int writtenID) {
        super(expirationDate, pin);
        this.writtenID = writtenID;
    }

    @Override
    public String toString() {
        return "PaperCard{" +
                "writtenID=" + writtenID +
                "expirationDate=" + getExpirationDate() +
                "pin=" + getPin() +
                '}';
    }
}
