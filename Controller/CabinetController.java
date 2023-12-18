package map.project.demo.Controller;

import map.project.demo.Domain.Cabinet;
import map.project.demo.Repository.CabinetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
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

    @GetMapping("/findByIdentifier/{cabinetID}")
    public Cabinet findCabinetByIdentifier(@PathVariable int cabinetID) {
        return cabinetRepository.findByIdentifier(cabinetID);
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

    @GetMapping("/delete/{cabinetID}")
    public void delete(@PathVariable int cabinetID) {
        Cabinet cabinet = cabinetRepository.findByIdentifier(cabinetID);
        if (cabinet != null) {
            cabinetRepository.delete(cabinet);
        } else {
            throw new IllegalArgumentException("Nothing was found for the provided identifier.");
        }
    }
    @GetMapping("/update/{cabinetID}")
    public void update(@PathVariable int cabinetID,@RequestBody Cabinet newObject) {
        if(cabinetRepository.findByIdentifier(cabinetID) != null) {
            delete(cabinetID);
            add(newObject);
        }
        else{
            throw new IllegalArgumentException("Nothing was found for the provided identifier.");
        }
    }

}