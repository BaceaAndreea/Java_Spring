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

public class Disease {
    @Id
    private int diseaseID;
    private String name;

    public void setDiseaseID(int diseaseID) {
        this.diseaseID = diseaseID;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Disease{" +
                "diseaseID=" + diseaseID +
                ", name='" + name + '\'' +
                '}';
    }
}