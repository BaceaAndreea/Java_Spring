package map.project.demo.Repository;
import map.project.demo.Domain.Consultation;
import org.springframework.data.repository.CrudRepository;
import java.util.ArrayList;

public interface ConsultationRepository extends CrudRepository<Consultation, Integer> {

    public Consultation findByIdentifier(ArrayList<String> identifier);

}
