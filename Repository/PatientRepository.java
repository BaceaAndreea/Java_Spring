package map.project.demo.Repository;
import map.project.demo.Domain.Patient;
import org.springframework.data.repository.CrudRepository;
import java.util.ArrayList;

public interface PatientRepository extends CrudRepository<Patient, Integer> {

    public Patient findByIdentifier(ArrayList<String> identifier);

}
