package map.project.demo.Controller;

import map.project.demo.Domain.Medication;
import map.project.demo.Repository.MedicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MedicationController {
    @Autowired
    private final MedicationRepository medicationRepository;

    public MedicationController(MedicationRepository medicationRepository) {
        this.medicationRepository = medicationRepository;
    }

    @PostMapping("/add")
    public void add(@RequestBody Medication medication) {
        medicationRepository.save(medication);
    }

    @GetMapping("/findByIdentifier/{medicationID}")
    public Medication findMedicationByIdentifier(@PathVariable int medicationID) {
        return medicationRepository.findByIdentifier(medicationID);
    }

    @GetMapping("/getAll")
    public List<Medication> getAll() {
        return (List<Medication>) medicationRepository.findAll();
    }

    @GetMapping("/printAll")
    public void printAll() {
        List<Medication> medications = (List<Medication>) medicationRepository.findAll();
        medications.forEach(medication -> System.out.println(medication.toString()));
    }

    @GetMapping("/delete/{medicationID}")
    public void delete(@PathVariable int medicationID) {
        Medication medication = medicationRepository.findByIdentifier(medicationID);
        if (medication != null) {
            medicationRepository.delete(medication);
        } else {
            throw new IllegalArgumentException("Nothing was found for the provided identifier.");
        }
    }

    @GetMapping("/update/{medicationID}")
    public void update(@PathVariable int medicationID, @RequestBody Medication newObject) {
        Medication existingMedication = medicationRepository.findByIdentifier(medicationID);
        if (existingMedication != null) {
            delete(medicationID);
            add(newObject);
        } else {
            throw new IllegalArgumentException("Nothing was found for the provided identifier.");
        }
    }
}
