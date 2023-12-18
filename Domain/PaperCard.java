package map.project.demo.Domain;

import jakarta.persistence.*;
import lombok.*;

@Table
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter

public class PaperCard extends HealthCard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
