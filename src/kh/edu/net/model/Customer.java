package kh.edu.net.model;

//Model store data application
//POJO CLASS stand for Plain Old Java project  (Getter, Setter, Constructor)

public class Customer {
    private int id;
    private String fullName;
    private String gender;
    private String email;
    private String phone;
    private Boolean isDeleted;

    public Customer(){};

    public Customer (int id, String fullName, String gender, String email, String phone, Boolean isDeleted) {
        this.id = id;
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


    public int getId() {
        return id;
    }
    public void setId(int id){
        this.id = id;
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
