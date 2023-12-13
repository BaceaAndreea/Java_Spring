package map.project.demo.Controller;

import map.project.demo.Domain.Cabinet;
import map.project.demo.Repository.CabinetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


import java.util.ArrayList;
import java.util.List;

@Controller
public class CabinetController {
    @Autowired
    private final CabinetRepository cabinetRepository ;

    public CabinetController(CabinetRepository cabinetRepository) {
        this.cabinetRepository = cabinetRepository;
    }


    @PostMapping("/add")
    public void add(@RequestBody Cabinet cabinet) {
        cabinetRepository.save(cabinet);

    }

    @GetMapping("/findByIdentifier/{identifier}")
    public Cabinet findCabinetByIdentifier(@PathVariable String identifier) {
        return cabinetRepository.findByIdentifier(identifier);
    }

    @GetMapping("/getAll")
    public List<Cabinet> getAll() {
        return (List<Cabinet>) cabinetRepository.findAll();
    }

    @GetMapping("/printAll")
    public void printAll() {
        List<Cabinet> cabinets = (List<Cabinet>) cabinetRepository.findAll();
        cabinets.forEach(cabinet -> System.out.println(cabinet.toString()));
    }

    @GetMapping("/delete/{identifier}")
    public void delete(@PathVariable String identifier) {
        Cabinet cabinet = cabinetRepository.findByIdentifier(identifier);
        if (cabinet != null) {
            cabinetRepository.delete(cabinet);
        } else {
            throw new IllegalArgumentException("Nothing was found for the provided identifier.");
        }
    }
    @GetMapping("/update/{identifier}")
    public void update(String identifier, Cabinet newObject) {
        if(cabinetRepository.findByIdentifier(identifier) != null) {
            delete(String.valueOf(identifier));
            add(newObject);
        }
        else{
            throw new IllegalArgumentException("Nothing was found for the provided identifier.");
        }
    }

}