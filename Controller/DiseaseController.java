package map.project.demo.Controller;

import map.project.demo.Domain.Cabinet;
import map.project.demo.Domain.Disease;
import map.project.demo.Repository.DiseaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
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

    @GetMapping("/findByIdentifier/{identifier}")
    public Disease findDiseaseByIdentifier(@PathVariable String identifier) {
        return diseaseRepository.findByIdentifier(identifier);
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

    @GetMapping("/delete/{identifier}")
    public void delete(@PathVariable String identifier) {
        Disease disease = diseaseRepository.findByIdentifier(identifier);
        if (disease != null) {
            diseaseRepository.delete(disease);
        } else {
            throw new IllegalArgumentException("Nothing was found for the provided identifier.");
        }
    }

    @GetMapping("/update/{identifier}")
    public void update(@PathVariable String identifier, @RequestBody Disease newObject) {
        Disease existingDisease = diseaseRepository.findByIdentifier(identifier);
        if (existingDisease != null) {
            delete(identifier);
            add(newObject);
        } else {
            throw new IllegalArgumentException("Nothing was found for the provided identifier.");
        }
    }
}
