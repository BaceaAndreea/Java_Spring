package map.project.demo.Controller;

import map.project.demo.Domain.Cabinet;
import map.project.demo.Repository.CabinetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import map.project.demo.Service.CabinetService;
import java.util.List;

@RestController
public class CabinetController {
    @Autowired private CabinetService service ;

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
        return service.listAll();
    }

    @GetMapping("/printAll")
    public void printAll() {
        List<Cabinet> cabinets = service.listAll();
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
    @GetMapping("/updateCabinet/{cabinetID}/{newObject}")
    public void update(@PathVariable int cabinetID,@RequestBody Cabinet newObject) {
        if(service.get(cabinetID) != null) {
            delete(cabinetID);
            add(newObject);
        }
        else{
            throw new IllegalArgumentException("Nothing was found for the provided identifier.");
        }
    }

}