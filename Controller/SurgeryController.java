package map.project.demo.Controller;

import map.project.demo.Domain.Surgery;
import map.project.demo.Repository.SurgeryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SurgeryController {
    @Autowired
    private final SurgeryRepository surgeryRepository;

    public SurgeryController(SurgeryRepository surgeryRepository) {
        this.surgeryRepository = surgeryRepository;
    }

    @PostMapping("/add")
    public void add(@RequestBody Surgery surgery) {
        surgeryRepository.save(surgery);
    }

    @GetMapping("/findByIdentifier/{patientID, doctorID, date, diseaseID}")
    public Surgery findSurgeryByIdentifier(@PathVariable int patientID, int doctorID, String date, int diseaseID) {
        return surgeryRepository.findByIdentifier(patientID, doctorID, date, diseaseID);
    }

    @GetMapping("/getAll")
    public List<Surgery> getAll() {
        return (List<Surgery>) surgeryRepository.findAll();
    }

    @GetMapping("/printAll")
    public void printAll() {
        List<Surgery> surgeries = (List<Surgery>) surgeryRepository.findAll();
        surgeries.forEach(surgery -> System.out.println(surgery.toString()));
    }

    @GetMapping("/delete/{patientID, doctorID, date, diseaseID}")
    public void delete(@PathVariable int patientID, int doctorID, String date, int diseaseID) {
        Surgery surgery = surgeryRepository.findByIdentifier(patientID, doctorID, date, diseaseID);
        if (surgery != null) {
            surgeryRepository.delete(surgery);
        } else {
            throw new IllegalArgumentException("Nothing was found for the provided identifier.");
        }
    }

    @GetMapping("/update/{patientID, doctorID, date, diseaseID}")
    public void update(@PathVariable int patientID, int doctorID, String date, int diseaseID, @RequestBody Surgery newObject) {
        Surgery existingSurgery = surgeryRepository.findByIdentifier(patientID, doctorID, date, diseaseID);
        if (existingSurgery != null) {
            delete(patientID, doctorID, date, diseaseID);
            add(newObject);
        } else {
            throw new IllegalArgumentException("Nothing was found for the provided identifier.");
        }
    }
}
