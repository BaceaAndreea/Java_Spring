package map.project.demo.Domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

@Getter
@Entity
@Table
@NoArgsConstructor
@AllArgsConstructor
@Setter
@ToString

public class Surgery {
    @Id
    private int patientID, doctorID;
    @Id
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private String date;
    @Id
    private int diseaseID;
    private String name;
    private int medicationID;

}