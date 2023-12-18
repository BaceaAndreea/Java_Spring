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
    @Autowired private DoctorService service;

    @PostMapping("/add")
    public void add(@RequestBody Doctor doctor) {
        service.save(doctor);
    }

    @GetMapping("/findByIdentifier/{doctorID}")
    public Doctor findDoctorByIdentifier(@PathVariable int doctorID) {
        return service.get(doctorID);
    }

    @GetMapping("/getAll")
    public List<Doctor> getAll() {
        return (List<Doctor>) service.listAll();
    }

    @GetMapping("/printAll")
    public void printAll() {
        List<Doctor> doctors = (List<Doctor>) service.listAll();
        doctors.forEach(doctor -> System.out.println(doctor.toString()));
    }

    @GetMapping("/delete/{doctorID}")
    public void delete(@PathVariable int doctorID) {
        Doctor doctor = service.get(doctorID);
        if (doctor != null) {
            service.delete(doctorID);
        } else {
            throw new IllegalArgumentException("Nothing was found for the provided identifier.");
        }
    }


    @GetMapping("/update/{doctorID}")
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
