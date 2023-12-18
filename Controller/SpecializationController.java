package map.project.demo.Controller;

import map.project.demo.Domain.Specialization;
import map.project.demo.Repository.SpecializationRepository;
import map.project.demo.Service.SpecializationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SpecializationController {
    @Autowired
    private SpecializationService service;

    @PostMapping("/addSpecialization")
    public void add(@RequestBody Specialization specialization) {
        service.save(specialization);
    }

    @GetMapping("/findByIdentifierSpecialization/{specializationID}")
    public Specialization findSpecializationByIdentifier(@PathVariable int specializationID) {
        return service.get(specializationID);
    }

    @GetMapping("/getAllSpecializations")
    public List<Specialization> getAll() {
        return service.listAll();
    }

    @GetMapping("/printAllSpecializations")
    public void printAll() {
        List<Specialization> specializations = service.listAll();
        specializations.forEach(specialization -> System.out.println(specialization.toString()));
    }

    @GetMapping("/deleteSpecialization/{specializationID}")
    public void delete(@PathVariable int specializationID) {
        Specialization specialization = service.get(specializationID);
        if (specialization != null) {
            service.delete(specializationID);
        } else {
            throw new IllegalArgumentException("Nothing was found for the provided identifier.");
        }
    }

    @GetMapping("/updateSpecialization/{specializationID}/{newObject}")
    public void update(@PathVariable int specializationID, @RequestBody Specialization newObject) {
        Specialization existingSpecialization = service.get(specializationID);
        if (existingSpecialization != null) {
            delete(specializationID);
            add(newObject);
        } else {
            throw new IllegalArgumentException("Nothing was found for the provided identifier.");
        }
    }
}
