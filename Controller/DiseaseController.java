package map.project.demo.Controller;

import map.project.demo.Domain.Disease;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import map.project.demo.Service.DiseaseService;

import java.util.List;

@RestController
public class DiseaseController {
    @Autowired private DiseaseService service;

    @PostMapping("/addDisease")
    public void add(@RequestBody Disease disease) {
        service.save(disease);
    }

    @GetMapping("/findDiseaseByIdDisease/{diseaseID}")
    public Disease findDiseaseByIdentifier(@PathVariable int diseaseID) {
        return service.get(diseaseID);
    }

    @GetMapping("/getAllDiseases")
    public List<Disease> getAll() {
        return service.listAll();
    }

    @GetMapping("/printAllDiseases")
    public void printAll() {
        List<Disease> diseases = service.listAll();
        diseases.forEach(disease -> System.out.println(disease.toString()));
    }

    @GetMapping("/deleteDisease/{diseaseID}")
    public void delete(@PathVariable int diseaseID) {
        Disease disease = service.get(diseaseID);
        if (disease != null) {
            service.delete(diseaseID);
        } else {
            throw new IllegalArgumentException("Nothing was found for the provided disease identifier.");
        }
    }

    @PostMapping("/updateDisease/{diseaseID}/ {newObject}")
    public void update(@PathVariable int diseaseID, @RequestBody Disease newObject) {
        if (service.get(diseaseID) != null) {
            delete(diseaseID);
            add(newObject);
        } else {
            throw new IllegalArgumentException("Nothing was found for the provided disease identifier.");
        }
    }
}
