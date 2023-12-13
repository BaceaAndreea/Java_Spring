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

public class Cabinet {
    @Id
    private int cabinetID;
    private String name;

    public void setCabinetID(int cabinetID) {
        this.cabinetID = cabinetID;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Cabinet{" +
                "cabinetID=" + cabinetID +
                ", name='" + name + '\'' +
                '}';
    }
}