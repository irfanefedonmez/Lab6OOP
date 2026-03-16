package atu.ie.week8_reservations.model;

import jakarta.validation.constraints.*;

import java.time.LocalDate;

public class Reservation
{
    private long rezervationId;
    @NotBlank(message = "equipment tag is required")
    private String equipmentTag;
    @NotBlank(message = "student email is required")
    @Email(message = "student email must be valid")
    private String studentEmail;
    @NotNull(message = "Rezervation date is required")
    private LocalDate  rezervationDate;
    @Min(value = 0,message = "Start hour must be between 0-23")
    @Max(value = 24,message = "Start hour must be between 0-23")
    private int startHour;
    @Min(value = 1,message = "Duration hours must be between 1-24")
    @Max(value = 24,message = "Duration hours must be between 1-24")
    private int durationHours;

    public  Reservation()
    {}
    public Reservation(long rezervationId , String equipmentTag, String studentEmail, LocalDate rezervationDate, int startHour, int durationHours){
        this.rezervationId = rezervationId;
        this.equipmentTag = equipmentTag;
        this.studentEmail = studentEmail;
        this.rezervationDate = rezervationDate;
        this.startHour = startHour;
        this.durationHours = durationHours;

    }
    public long getRezervationId() {
        return rezervationId;
    }
    public void setRezervationId(long rezervationId) {
        this.rezervationId = rezervationId;
    }
    public String getEquipmentTag() {
        return equipmentTag;
    }
    public void setEquipmentTag(String equipmentTag) {
        this.equipmentTag = equipmentTag;
    }
    public String getStudentEmail() {
        return studentEmail;
    }
    public void setStudentEmail(String studentEmail) {
        this.studentEmail = studentEmail;
    }
    public LocalDate getRezervationDate() {
        return rezervationDate;
    }
    public void setRezervationDate(LocalDate rezervationDate) {
        this.rezervationDate = rezervationDate;
    }
    public int getStartHour() {
        return startHour;
    }
    public void setStartHour(int startHour) {
        this.startHour = startHour;
    }
    public int getDurationHours() {
        return durationHours;
    }
    public void setDurationHours(int durationHours) {
        this.durationHours = durationHours;
    }






}
