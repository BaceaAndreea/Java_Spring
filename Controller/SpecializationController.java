package map.project.demo.Controller;

import map.project.demo.Domain.Specialization;
import map.project.demo.Repository.SpecializationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SpecializationController {
    @Autowired
    private final SpecializationRepository specializationRepository;

    public SpecializationController(SpecializationRepository specializationRepository) {
        this.specializationRepository = specializationRepository;
    }

    @PostMapping("/add")
    public void add(@RequestBody Specialization specialization) {
        specializationRepository.save(specialization);
    }

    @GetMapping("/findByIdentifier/{specializationID}")
    public Specialization findSpecializationByIdentifier(@PathVariable int specializationID) {
        return specializationRepository.findByIdentifier(specializationID);
    }

    @GetMapping("/getAll")
    public List<Specialization> getAll() {
        return (List<Specialization>) specializationRepository.findAll();
    }

    @GetMapping("/printAll")
    public void printAll() {
        List<Specialization> specializations = (List<Specialization>) specializationRepository.findAll();
        specializations.forEach(specialization -> System.out.println(specialization.toString()));
    }

    @GetMapping("/delete/{specializationID}")
    public void delete(@PathVariable int specializationID) {
        Specialization specialization = specializationRepository.findByIdentifier(specializationID);
        if (specialization != null) {
            specializationRepository.delete(specialization);
        } else {
            throw new IllegalArgumentException("Nothing was found for the provided identifier.");
        }
    }

    @GetMapping("/updateSpecialization/{specializationID}/{newObject}")
    public void update(@PathVariable int specializationID, @RequestBody Specialization newObject) {
        Specialization existingSpecialization = specializationRepository.findByIdentifier(specializationID);
        if (existingSpecialization != null) {
            delete(specializationID);
            add(newObject);
        } else {
            throw new IllegalArgumentException("Nothing was found for the provided identifier.");
        }
    }
}
