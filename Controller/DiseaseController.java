package map.project.demo.Controller;

import map.project.demo.Domain.Disease;
import map.project.demo.Repository.DiseaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController 
@RequestMapping("/api/diseases")
public class DiseaseController {

    @Autowired
    private final DiseaseRepository diseaseRepository;

    public DiseaseController(DiseaseRepository diseaseRepository) {
        this.diseaseRepository = diseaseRepository;
    }

    @PostMapping("/add")
    public void add(@RequestBody Disease disease) {
        diseaseRepository.save(disease);
    }

    @GetMapping("/findByIdentifier/{diseaseID}")
    public Disease findDiseaseByIdentifier(@PathVariable int diseaseID) {
        return diseaseRepository.findByIdentifier(diseaseID);
    }

    @GetMapping("/getAll")
    public List<Disease> getAll() {
        return (List<Disease>) diseaseRepository.findAll();
    }

    @GetMapping("/printAll")
    public void printAll() {
        List<Disease> diseases = (List<Disease>) diseaseRepository.findAll();
        diseases.forEach(disease -> System.out.println(disease.toString()));
    }

    @GetMapping("/delete/{diseaseID}")
    public void delete(@PathVariable int diseaseID) {
        Disease disease = diseaseRepository.findByIdentifier(diseaseID);
        if (disease != null) {
            diseaseRepository.delete(disease);
        } else {
            throw new IllegalArgumentException("Nothing was found for the provided identifier.");
        }
    }

    @GetMapping("/update/{diseaseID}")
    public void update(@PathVariable int diseaseID, @RequestBody Disease newObject) {
        Disease existingDisease = diseaseRepository.findByIdentifier(diseaseID);
        if (existingDisease != null) {
            delete(diseaseID);
            add(newObject);
        } else {
            throw new IllegalArgumentException("Nothing was found for the provided identifier.");
        }
    }
}
