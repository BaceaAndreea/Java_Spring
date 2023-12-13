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

public class Hospital {
    @Id
    private int hospitalID;
    private String name;
    private int capacity;

    public void setHospitalID(int hospitalID) {
        this.hospitalID = hospitalID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return "Hospital{" +
                "hospitalID=" + hospitalID +
                ", name='" + name + '\'' +
                ", capacity=" + capacity +
                '}';
    }
}