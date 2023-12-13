package map.project.demo.Repository;
import map.project.demo.Domain.Doctor;
import org.springframework.data.repository.CrudRepository;
import java.util.ArrayList;

public interface DoctorRepository extends CrudRepository<Doctor, Integer> {

    public Doctor findByIdentifier(ArrayList<String> identifier);

}
