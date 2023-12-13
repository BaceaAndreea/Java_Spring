package map.project.demo.Repository;
import map.project.demo.Domain.Medication;
import org.springframework.data.repository.CrudRepository;
import java.util.ArrayList;

public interface MedicationRepository extends CrudRepository<Medication, Integer> {

    public Medication findByIdentifier(ArrayList<String> identifier);

}
