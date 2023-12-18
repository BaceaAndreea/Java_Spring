package map.project.demo.Domain;

import jakarta.persistence.*;
import lombok.*;


@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString

public class HealthCard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String expirationDate;
    private int pin;
}