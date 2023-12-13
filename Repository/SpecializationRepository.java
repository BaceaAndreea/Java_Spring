package map.project.demo.Repository;
import map.project.demo.Domain.Specialization;
import org.springframework.data.repository.CrudRepository;
import java.util.ArrayList;

public interface SpecializationRepository extends CrudRepository<Specialization, Integer> {

    public Specialization findByIdentifier(ArrayList<String> identifier);

}
