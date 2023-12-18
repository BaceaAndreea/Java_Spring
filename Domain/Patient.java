package map.project.demo.Domain;
import jakarta.persistence.*;
import lombok.*;
import map.project.demo.Iterator.PatientIterator;
import map.project.demo.Observers.Observer;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.ArrayList;
@Getter
@Entity
@Table
@NoArgsConstructor
@AllArgsConstructor
@Setter
@ToString

public class Patient{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int patientID;
    private String name;
    private String firstName;
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private String birthdate;
    private String contactPhone;
    private int cardID;

}