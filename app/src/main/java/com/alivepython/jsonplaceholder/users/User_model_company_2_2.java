package com.alivepython.jsonplaceholder.users;

public class User_model_company_2_2 {
    private String name;
    private String catchPhrase;
    private String bs;

    public User_model_company_2_2() {
    }

    public User_model_company_2_2(String name, String catchPhrase, String bs) {
        this.name = name;
        this.catchPhrase = catchPhrase;
        this.bs = bs;
    }

    public String getName() {
        return name;
    }

    public String getCatchPhrase() {
        return catchPhrase;
    }

    public String getBs() {
        return bs;
    }
}
