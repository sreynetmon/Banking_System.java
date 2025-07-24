package kh.edu.net.model;

//Model store data application
//POJO CLASS stand for Plain Old Java project  (Getter, Setter, Constructor)

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Customer {
    private UUID uuid;
    private String fullName;
    private String gender;
    private String email;
    private String phone;
    private Boolean isDeleted;

    public Customer(){};

    public Customer(UUID uuid, String fullName, String gender, String email, String phone, Boolean isDeleted) {
        this.uuid = uuid;
        this.fullName = fullName;
        this.gender = gender;
        this.email = email;
        this.phone = phone;
        this.isDeleted = isDeleted;
    }

//    public Customer (){
//        List<Customer> customers = new ArrayList<>();
//        customers.add(new Customer());
//    }


    public UUID getUuid() {
        return uuid;
    }
    public void setId(UUID uuid){
        this.uuid = uuid;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Boolean getDeleted() {
        return isDeleted;
    }

    public void setDeleted(Boolean deleted) {
        isDeleted = deleted;
    }
}
