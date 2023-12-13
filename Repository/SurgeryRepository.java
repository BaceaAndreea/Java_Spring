package map.project.demo.Repository;
import map.project.demo.Domain.Surgery;
import org.springframework.data.repository.CrudRepository;
import java.util.ArrayList;

public interface SurgeryRepository extends CrudRepository<Surgery, Integer> {

    public Surgery findByIdentifier(ArrayList<String> identifier);

}
