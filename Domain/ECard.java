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

public class ECard extends HealthCard{
    @Id
    private int electronicID;

    public void setCardID(int cardID) {
        this.electronicID = cardID;
    }

    @Override
    public String toString() {
        return "ECard{" +
                "electronicID=" + electronicID +
                '}';
    }
}