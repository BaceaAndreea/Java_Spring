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

public class Medication {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int medicationID;
    private String name;
    private String administrationRoute;
    private int storageAmount;
    private String expirationDate;

}
