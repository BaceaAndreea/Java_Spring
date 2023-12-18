package map.project.demo.Controller;

import map.project.demo.Domain.Medication;
import map.project.demo.Repository.MedicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import map.project.demo.Service.MedicationService;

import java.util.List;

@RestController
public class MedicationController {
    @Autowired private MedicationService service;

    @PostMapping("/addMedication")
    public void add(@RequestBody Medication medication) {
        service.save(medication);
    }

    @GetMapping("/findByIdentifierMedication/{medicationID}")
    public Medication findMedicationByIdentifier(@PathVariable int medicationID) {
        return service.get(medicationID);
    }

    @GetMapping("/getAllMedication")
    public List<Medication> getAll() {
        return service.listAll();
    }

    @GetMapping("/printAllMedication")
    public void printAll() {
        List<Medication> medications = service.listAll();
        medications.forEach(medication -> System.out.println(medication.toString()));
    }

    @GetMapping("/deleteMedication/{medicationID}")
    public void delete(@PathVariable int medicationID) {
        Medication medication = service.get(medicationID);
        if (medication != null) {
            service.delete(medicationID);
        } else {
            throw new IllegalArgumentException("Nothing was found for the provided identifier.");
        }
    }

    @GetMapping("/updateMedication/{medicationID}/ {newObject}")
    public void update(@PathVariable int medicationID, @RequestBody Medication newObject) {
        Medication existingMedication = service.get(medicationID);
        if (existingMedication != null) {
            delete(medicationID);
            add(newObject);
        } else {
            throw new IllegalArgumentException("Nothing was found for the provided identifier.");
        }
    }
}
