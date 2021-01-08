package exam02.cv;

import java.util.ArrayList;
import java.util.List;

public class Cv {
    private String name;
    private List<Skill> skills = new ArrayList<>();

    public Cv(String name) {
        this.name = name;
    }

    public void addSkills(String... newSkills) {
        String nameOfSkill;
        int levelOfSkill = 0;
        for (String newSkill : newSkills) {
            nameOfSkill = newSkill.trim().substring(0, newSkill.indexOf("(") - 1);
            levelOfSkill = Integer.parseInt(newSkill.trim().substring(newSkill.indexOf("(") + 1, newSkill.indexOf(")")));
            skills.add(new Skill(nameOfSkill, levelOfSkill));
        }

    }

    public int findSkillLevelByName(String nameOfSkill) throws SkillNotFoundException {
        if (skills.size() < 1) {throw new SkillNotFoundException("");}
        for (Skill skill : skills) {
            if (skill.getName().equals(nameOfSkill)) {
                return skill.getLevel();
            }
        }
        return 0;
    }

    public List<Skill> getSkills() {
        return skills;
    }

    public String getName() {
        return name;
    }
}
