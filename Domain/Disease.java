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

public class Disease {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int diseaseID;
    private String name;
}