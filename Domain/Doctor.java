package map.project.demo.Domain;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;



@Entity
@Table
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
@ToString

public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int doctorID;
    private String name, firstName;
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private String birthdate;
    private int hospitalID;
    private String contactPhone;
    private int specializationID;
    private int cabinetID;
}
