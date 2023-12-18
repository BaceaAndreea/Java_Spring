package map.project.demo.Controller;

import map.project.demo.Domain.Consultation;
import map.project.demo.Repository.ConsultationRepository;
import map.project.demo.Service.ConsultationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ConsultationController {
    @Autowired
    private ConsultationService service;

    @PostMapping("/addConsultation")
    public void add(@RequestBody Consultation consultation) {
        service.save(consultation);
    }

    @GetMapping("/findByIdentifierConsultation/{consultationID}")
    public Consultation findConsultationByIdentifier(@PathVariable int consultationID) {
        return service.get(consultationID);
    }

    @GetMapping("/getAllConsultation")
    public List<Consultation> getAll() {
        return service.listAll();
    }

    @GetMapping("/printAllConsultation")
    public void printAll() {
        List<Consultation> consultations = service.listAll();
        consultations.forEach(consultation -> System.out.println(consultation.toString()));
    }

    @DeleteMapping("/deleteConsultation/{consultationID}")
    public void delete(@PathVariable int consultationID) {
        Consultation consultation = service.get(consultationID);
        if (consultation != null) {
            service.delete(consultationID);
        } else {
            throw new IllegalArgumentException("Nothing was found for the provided identifier.");
        }
    }

    @GetMapping("/updateConsultation/{consultationID}/ {newObject}")
    public void update(@PathVariable int consultationID, @RequestBody Consultation newObject) {
        Consultation existingConsultation = service.get(consultationID);
        if (existingConsultation != null) {
            delete(consultationID);
            add(newObject);
        } else {
            throw new IllegalArgumentException("Nothing was found for the provided identifier.");
        }
    }
}
