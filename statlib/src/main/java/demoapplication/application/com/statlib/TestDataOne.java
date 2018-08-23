package demoapplication.application.com.statlib;

import com.google.gson.annotations.SerializedName;

public class TestDataOne {

    @SerializedName("name")
    private String name;
    @SerializedName("age")
    private String age;
    @SerializedName("address")
    private String address;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
