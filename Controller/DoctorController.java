package map.project.demo.Controller;

import map.project.demo.Domain.Doctor;
import map.project.demo.Repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import map.project.demo.Service.DoctorService;

import java.util.List;

@RestController
public class DoctorController {
    @Autowired
    private DoctorService service;

    @Autowired
    public DoctorController(DoctorService service) {
        this.service = service;
    }

    @PostMapping("/addDoctor")
    public void add(@RequestBody Doctor doctor) {
        service.save(doctor);
    }

    @GetMapping("/findByIdentifierDoctor/{doctorID}")
    public Doctor findDoctorByIdentifier(@PathVariable int doctorID) {
        return service.get(doctorID);
    }

    @GetMapping("/getAllDoctor")
    public List<Doctor> getAll() {
        return (List<Doctor>) service.listAll();
    }

    @GetMapping("/printAllDoctors")
    public void printAll() {
        List<Doctor> doctors =  service.listAll();
        doctors.forEach(doctor -> System.out.println(doctor.toString()));
    }

    @GetMapping("/deleteDoctor/{doctorID}")
    public void delete(@PathVariable int doctorID) {
        Doctor doctor = service.get(doctorID);
        if (doctor != null) {
            service.delete(doctorID);
        } else {
            throw new IllegalArgumentException("Nothing was found for the provided identifier.");
        }
    }


    @GetMapping("/update/{doctorID}/ {newObject}")
    public void update(@PathVariable int doctorID, @RequestBody Doctor newObject) {
        Doctor existingDoctor = service.get(doctorID);
        if (existingDoctor != null) {
            delete(doctorID);
            add(newObject);
        } else {
            throw new IllegalArgumentException("Nothing was found for the provided identifier.");
        }
    }
}
