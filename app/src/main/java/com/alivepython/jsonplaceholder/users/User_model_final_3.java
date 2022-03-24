package com.alivepython.jsonplaceholder.users;

public class User_model_final_3 {
    private int id;
    private String name;
    private String username;
    private String email;
    private User_model_address_2_1 address;
    private String phone;
    private String website;
    private User_model_company_2_2 company;

    public User_model_final_3() {
    }

    public User_model_final_3(int id, String name, String username, String email, User_model_address_2_1 address, String phone, String website, User_model_company_2_2 company) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.email = email;
        this.address = address;
        this.phone = phone;
        this.website = website;
        this.company = company;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public User_model_address_2_1 getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public String getWebsite() {
        return website;
    }

    public User_model_company_2_2 getCompany() {
        return company;
    }
}
