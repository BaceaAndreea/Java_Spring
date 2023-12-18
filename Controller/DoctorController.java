package map.project.demo.Controller;

import map.project.demo.Domain.Doctor;
import map.project.demo.Repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DoctorController {
    @Autowired
    private final DoctorRepository doctorRepository;

    public DoctorController(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    @PostMapping("/add")
    public void add(@RequestBody Doctor doctor) {
        doctorRepository.save(doctor);
    }

    @GetMapping("/findByIdentifier/{doctorID}")
    public Doctor findDoctorByIdentifier(@PathVariable int doctorID) {
        return doctorRepository.findByIdentifier(doctorID);
    }

    @GetMapping("/getAll")
    public List<Doctor> getAll() {
        return (List<Doctor>) doctorRepository.findAll();
    }

    @GetMapping("/printAll")
    public void printAll() {
        List<Doctor> doctors = (List<Doctor>) doctorRepository.findAll();
        doctors.forEach(doctor -> System.out.println(doctor.toString()));
    }

    @GetMapping("/delete/{doctorID}")
    public void delete(@PathVariable int doctorID) {
        Doctor doctor = doctorRepository.findByIdentifier(doctorID);
        if (doctor != null) {
            doctorRepository.delete(doctor);
        } else {
            throw new IllegalArgumentException("Nothing was found for the provided identifier.");
        }
    }


    @GetMapping("/update/{doctorID}")
    public void update(@PathVariable int doctorID, @RequestBody Doctor newObject) {
        Doctor existingDoctor = doctorRepository.findByIdentifier(doctorID);
        if (existingDoctor != null) {
            delete(doctorID);
            add(newObject);
        } else {
            throw new IllegalArgumentException("Nothing was found for the provided identifier.");
        }
    }
}
