package map.project.demo.Repository;
import map.project.demo.Domain.Surgery;
import org.springframework.data.repository.CrudRepository;

public interface SurgeryRepository extends CrudRepository<Surgery, Integer> {

    public Surgery findByIdentifier(int patientID, int doctorID, String date, int diseaseID);

}
