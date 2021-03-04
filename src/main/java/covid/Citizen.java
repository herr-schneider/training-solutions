package covid;

public class Citizen {
    private String citizen_name;
    private int zip;
    private int age;
    private String email;
    private String taj;

    public Citizen() {
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
        return citizen_name + ';' +
                zip + ';' +
                age + ';' +
                email + ';' +
                taj + "\n";
    }
}
