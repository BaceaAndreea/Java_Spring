package map.project.demo.Domain;

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
@ToString

public class Specialization {
    @Id
    private int specializationID;
    private String name;
}