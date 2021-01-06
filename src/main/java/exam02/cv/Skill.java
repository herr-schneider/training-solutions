package exam02.cv;

import java.util.List;

public class Skill {
    private String name;
    private int level;

    public Skill(String nameOfSkill, int levelOfSkill) {
        this.name = nameOfSkill;
        this.level = levelOfSkill;
    }

    public String getName() {
        return name;
    }

    public int getLevel() {
        return level;
    }
}
