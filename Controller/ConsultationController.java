package map.project.demo.Controller;

import map.project.demo.Domain.Consultation;
import map.project.demo.Repository.ConsultationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ConsultationController {
    @Autowired
    private final ConsultationRepository consultationRepository;

    public ConsultationController(ConsultationRepository consultationRepository) {
        this.consultationRepository = consultationRepository;
    }

    @PostMapping("/add")
    public void add(@RequestBody Consultation consultation) {
        consultationRepository.save(consultation);
    }

    @GetMapping("/findByIdentifier/{patientID, doctorID, date}")
    public Consultation findConsultationByIdentifier(@PathVariable int patientID, int doctorID, String date) {
        return consultationRepository.findByIdentifier(patientID, doctorID, date);
    }

    @GetMapping("/getAll")
    public List<Consultation> getAll() {
        return (List<Consultation>) consultationRepository.findAll();
    }

    @GetMapping("/printAll")
    public void printAll() {
        List<Consultation> consultations = (List<Consultation>) consultationRepository.findAll();
        consultations.forEach(consultation -> System.out.println(consultation.toString()));
    }

    @DeleteMapping("/delete/{consultationID}")
    public void delete(@PathVariable int consultationID) {
        Consultation consultation = service.get(consultationID);
        if (consultation != null) {
            consultationRepository.delete(consultation);
        } else {
            throw new IllegalArgumentException("Nothing was found for the provided identifier.");
        }
    }

    @GetMapping("/update/{consultationID, newObject}")
    public void update(@PathVariable int consultationID, @RequestBody Consultation newObject) {
        Consultation existingConsultation = service.get(consultationID);
        if (existingConsultation != null) {
            delete(patientID, doctorID, date);
            add(newObject);
        } else {
            throw new IllegalArgumentException("Nothing was found for the provided identifier.");
        }
    }
}
