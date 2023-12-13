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
public class Specialization {
    @Id
    private int specializationID;
    private String name;

    public void setSpecializationID(int specializationID) {
        this.specializationID = specializationID;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Specialization{" +
                "specializationID=" + specializationID +
                ", name='" + name + '\'' +
                '}';
    }
}