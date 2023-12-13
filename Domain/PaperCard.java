package map.project.demo.Domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class PaperCard extends HealthCard {
    @Id
    private int writtenID;
    public void setWrittenID(int writtenID) {
        this.writtenID = writtenID;
    }

    @Override
    public String toString() {
        return "PaperCard{" +
                "writtenID=" + writtenID +
                '}';
    }
}
