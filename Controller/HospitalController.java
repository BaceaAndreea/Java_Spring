package map.project.demo.Controller;

import map.project.demo.Domain.Hospital;
import map.project.demo.Repository.HospitalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class HospitalController {
    @Autowired
    private final HospitalRepository hospitalRepository;

    public HospitalController(HospitalRepository hospitalRepository) {
        this.hospitalRepository = hospitalRepository;
    }

    @PostMapping("/add")
    public void add(@RequestBody Hospital hospital) {
        hospitalRepository.save(hospital);
    }

    @GetMapping("/findByIdentifier/{hospitalID}")
    public Hospital findHospitalByIdentifier(@PathVariable int hospitalID) {
        return hospitalRepository.findByIdentifier(hospitalID);
    }

    @GetMapping("/getAll")
    public List<Hospital> getAll() {
        return (List<Hospital>) hospitalRepository.findAll();
    }

    @GetMapping("/printAll")
    public void printAll() {
        List<Hospital> hospitals = (List<Hospital>) hospitalRepository.findAll();
        hospitals.forEach(hospital -> System.out.println(hospital.toString()));
    }

    @GetMapping("/delete/{hospitalID}}")
    public void delete(@PathVariable int hospitalID) {
        Hospital hospital = hospitalRepository.findByIdentifier(hospitalID);
        if (hospital != null) {
            hospitalRepository.delete(hospital);
        } else {
            throw new IllegalArgumentException("Nothing was found for the provided identifier.");
        }
    }

    @GetMapping("/update/{hospitalID}")
    public void update(@PathVariable int hospitalID, @RequestBody Hospital newObject) {
        Hospital existingHospital = hospitalRepository.findByIdentifier(hospitalID);
        if (existingHospital != null) {
            delete(hospitalID);
            add(newObject);
        } else {
            throw new IllegalArgumentException("Nothing was found for the provided identifier.");
        }
    }
}
