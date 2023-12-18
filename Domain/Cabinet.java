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

public class Cabinet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cabinetID;
    private String name;
}