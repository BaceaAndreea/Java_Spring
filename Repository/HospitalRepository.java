package map.project.demo.Repository;
import map.project.demo.Domain.Hospital;
import org.springframework.data.repository.CrudRepository;
import java.util.ArrayList;

public interface HospitalRepository extends CrudRepository<Hospital, Integer> {

    public Hospital findByIdentifier(ArrayList<String> identifier);

}
