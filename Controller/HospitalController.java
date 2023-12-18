package map.project.demo.Controller;

import map.project.demo.Domain.Hospital;
import map.project.demo.Repository.HospitalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import map.project.demo.Service.HospitalService;

import java.util.List;

@RestController
public class HospitalController {
    @Autowired private HospitalService service;

    @PostMapping("/add")
    public void add(@RequestBody Hospital hospital) {
        service.save(hospital);
    }

    @GetMapping("/findByIdentifier/{hospitalID}")
    public Hospital findHospitalByIdentifier(@PathVariable int hospitalID) {
        return service.get(hospitalID);
    }

    @GetMapping("/getAll")
    public List<Hospital> getAll() {
        return service.listAll();
    }

    @GetMapping("/printAll")
    public void printAll() {
        List<Hospital> hospitals = (List<Hospital>) service.listAll();
        hospitals.forEach(hospital -> System.out.println(hospital.toString()));
    }

    @GetMapping("/delete/{hospitalID}}")
    public void delete(@PathVariable int hospitalID) {
        Hospital hospital = service.get(hospitalID);
        if (hospital != null) {
            service.delete(hospitalID);
        } else {
            throw new IllegalArgumentException("Nothing was found for the provided identifier.");
        }
    }

    @GetMapping("/update/{hospitalID}")
    public void update(@PathVariable int hospitalID, @RequestBody Hospital newObject) {
        Hospital existingHospital = service.get(hospitalID);
        if (existingHospital != null) {
            delete(hospitalID);
            add(newObject);
        } else {
            throw new IllegalArgumentException("Nothing was found for the provided identifier.");
        }
    }
}
