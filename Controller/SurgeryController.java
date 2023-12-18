package map.project.demo.Controller;

import map.project.demo.Domain.Surgery;
import map.project.demo.Service.SurgeryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SurgeryController {
    @Autowired private SurgeryService service;
    @PostMapping("/addSurgery")
    public void add(@RequestBody Surgery surgery) {
        service.save(surgery);
    }

    @GetMapping("/findByIdentifierSurgery/{surgeryID}")
    public Surgery findSurgeryByIdentifier(@PathVariable int surgeryID) {
        return service.get(surgeryID);
    }

    @GetMapping("/getAllSurgery")
    public List<Surgery> getAll() {
        return (List<Surgery>) surgeryRepository.findAll();
    }

    @GetMapping("/printAllSurgery")
    public void printAll() {
        List<Surgery> surgeries = service.listAll();
        surgeries.forEach(surgery -> System.out.println(surgery.toString()));
    }

    @GetMapping("/delete/{patientID, doctorID, date, diseaseID}")
    public void delete(@PathVariable int patientID, int doctorID, String date, int diseaseID) {
        Surgery surgery = surgeryRepository.findByIdentifier(patientID, doctorID, date, diseaseID);
        if (surgery != null) {
            service.delete(surgeryID);
        } else {
            throw new IllegalArgumentException("Nothing was found for the provided identifier.");
        }
    }

    @GetMapping("/updateSurgery/{surgeryID}/{newObject}")
    public void update(@PathVariable int surgeryID, @RequestBody Surgery newObject) {
        Surgery existingSurgery = service.get(surgeryID);
        if (existingSurgery != null) {
            delete(patientID, doctorID, date, diseaseID);
            add(newObject);
        } else {
            throw new IllegalArgumentException("Nothing was found for the provided identifier.");
        }
    }
}
