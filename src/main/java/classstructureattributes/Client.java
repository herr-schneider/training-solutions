package classstructureattributes;

public class Client {


    String name;
    int yearOfBirth;
    String address;

    public String getName() {
        return name;
    }

    public int getYear() {
        return yearOfBirth;
    }

    public String getAddress() {
        return name;
    }

    public int getAge (int thisyear) {
        return  thisyear - yearOfBirth;
    }

    public void changeName (String name) {
       this.name = name;
    }



}
