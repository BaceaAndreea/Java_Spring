package map.project.demo.Controller;

import map.project.demo.Service.PatientService;
import map.project.demo.Domain.Patient;
import map.project.demo.Iterator.PatientIterator;
import map.project.demo.Domain.PatientIteratorImpl;
import map.project.demo.Repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class PatientController {
    @Autowired private PatientService service;

    @PostMapping("/addPatient")
    public void add(@RequestBody Patient patient) {
        service.save(patient);
    }

    @GetMapping("/findByIdentifierPatient/{patientID}")
    public Patient findPatientByIdentifier(@PathVariable int patientID) {
        return service.get(patientID);
    }

    @GetMapping("/getAllPatient")
    public List<Patient> getAll() {
        return (List<Patient>) service.listAll();
    }

    @GetMapping("/printAllPatient")
    public void printAll() {
        List<Patient> patients = (List<Patient>) service.listAll();
        patients.forEach(patient -> System.out.println(patient.toString()));
    }

    @GetMapping("/deletePatient/{patientID}")
    public void delete(@PathVariable int patientID) {
        Patient patient = service.get(patientID);
        if (patient != null) {
            service.delete(patientID);
        } else {
            throw new IllegalArgumentException("Nothing was found for the provided identifier.");
        }
    }

    @GetMapping("/updatePatient/{patientID}/{newObject}")
    public void update(@PathVariable int patientID, @RequestBody Patient newObject) {
        Patient existingPatient = service.get(patientID);
        if (existingPatient != null) {
            delete(patientID);
            add(newObject);
        } else {
            throw new IllegalArgumentException("Nothing was found for the provided identifier.");
        }
    }
    @GetMapping("createIterator")
    public PatientIterator createIterator() {
        Iterable<Patient> patients = getAll();
        PatientIteratorImpl iterator = new PatientIteratorImpl(patients);
        return iterator;
    }


    @GetMapping("iteratePatients")
    public void iteratePatients() {
        PatientIterator<Patient> iterator = service.createIterator();
        while (iterator.hasNext()) {
            Patient patient = iterator.next();
            System.out.println(patient);
        }
    }
}
