package map.project.demo.Domain;

import jakarta.persistence.*;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int specializationID;
    private String name;
}