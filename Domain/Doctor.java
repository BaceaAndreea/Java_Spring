package map.project.demo.Domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;



@Entity
@Table
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter


public class Doctor {
    @Id
    private int doctorID;
    private String name, firstName;
    private String birthdate;
    private int hospitalID;
    private String contactPhone;
    private int specializationID;
    private int cabinetID;

    private Doctor(Builder builder) {
        this.doctorID = builder.doctorID;
        this.name = builder.name;
        this.firstName = builder.firstName;
        this.birthdate = builder.birthdate;
        this.hospitalID = builder.hospitalID;
        this.contactPhone = builder.contactPhone;
        this.specializationID = builder.specializationID;
        this.cabinetID = builder.cabinetID;
    }

    public static class Builder {

        private int doctorID;
        private String name, firstName;
        @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
        private String birthdate;
        private int hospitalID;
        private String contactPhone;
        private int specializationID;
        private int cabinetID;

        public Builder(int doctorID, String name, String firstName) {
            this.doctorID = doctorID;
            this.name = name;
            this.firstName = firstName;
        }

        public Builder birthdate(String birthdate) {
            this.birthdate = birthdate;
            return this;
        }

        public Builder hospitalID(int hospitalID) {
            this.hospitalID = hospitalID;
            return this;
        }

        public Builder contactPhone(String contactPhone) {
            this.contactPhone = contactPhone;
            return this;
        }

        public Builder specializationID(int specializationID) {
            this.specializationID = specializationID;
            return this;
        }

        public Builder cabinetID(int cabinetID) {
            this.cabinetID = cabinetID;
            return this;
        }

        public Doctor build() {
            return new Doctor(this);
        }
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "doctorID=" + doctorID +
                ", name='" + name + '\'' +
                ", firstName='" + firstName + '\'' +
                ", birthdate='" + birthdate + '\'' +
                ", hospitalID=" + hospitalID +
                ", contactPhone='" + contactPhone + '\'' +
                ", specializationID=" + specializationID +
                ", cabinetID=" + cabinetID +
                '}';
    }

    public void setDoctorID(int doctorID) {
        this.doctorID = doctorID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public void setHospitalID(int hospitalID) {
        this.hospitalID = hospitalID;
    }

    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone;
    }

    public void setSpecializationID(int specializationID) {
        this.specializationID = specializationID;
    }

    public void setCabinetID(int cabinetID) {
        this.cabinetID = cabinetID;
    }
}
