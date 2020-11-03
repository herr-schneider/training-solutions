package week2;

public class Phone {
    String type;
    int mem;


    public String getType() {
        return type;
    }

    public int getMem() {
        return mem;
    }

    public Phone (String type, int mem) {
        this.type = type;
        this.mem = mem;
    }

    public void setMem(int mem) {
        this.mem = mem;
    }

    public void setType(String type) {
        this.type = type;
    }
}

