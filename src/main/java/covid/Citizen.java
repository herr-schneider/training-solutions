package covid;

import java.time.LocalTime;

public class Citizen {
    private LocalTime time;
    private String citizen_name;
    private int zip;
    private int age;
    private String email;
    private String taj;

    public Citizen() {
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public void setCitizen_name(String citizen_name) {
        this.citizen_name = citizen_name;
    }

    public void setZip(int zip) {
        this.zip = zip;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setTaj(String taj) {
        this.taj = taj;
    }

    @Override
    public String toString() {
        return time.toString() + ';' +
                citizen_name + ';' +
                zip + ';' +
                age + ';' +
                email + ';' +
                taj + "\n";
    }
}
