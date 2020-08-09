package com.example.alumniapp;

public class details {
    private String name,email,phoneNo,profession,institution,address,batch;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String getInstitution() {
        return institution;
    }

    public void setInstitution(String institution) {
        this.institution = institution;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getBatch() {
        return batch;
    }

    public void setBatch(String batch) {
        this.batch = batch;
    }


    public details(String name, String email, String phoneNo, String profession, String institution, String address,String batch) {
        this.name = name;
        this.email = email;
        this.phoneNo = phoneNo;
        this.profession = profession;
        this.institution = institution;
        this.address = address;
        this.batch=batch;
    }
}
