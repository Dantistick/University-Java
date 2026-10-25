package Lab7.StreamAPI;

import java.util.List;

public class User {
    private String name;
    private int age;
    private String city;
    private List<Tags> tags;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public List<Tags> getTags() {
        return tags;
    }

    public void setTags(List<Tags> tags) {
        this.tags = tags;
    }

    public User(String name, int age, String city, List<Tags> tags) {
        this.name = name;
        this.age = age;
        this.city = city;
        this.tags = tags;
    }
}
