package week07d04;

import java.time.LocalDate;

public class Lab {
    String title;
    boolean completed;
    LocalDate completedAt;

    public Lab(String title) {
        this.title = title;
        this.completed = false;
    }

    public Lab(String title, LocalDate completedAt) {
        this.title = title;
        this.completed = true;
        this.completedAt = completedAt;
    }

    public void completed (LocalDate completedAt) {
        this.completed = true;
        this.completedAt = completedAt;
    }

    public void completed () {
        this.completed = true;
        this.completedAt = LocalDate.now();
    }

    @Override
    public String toString() {
        return completed ? "Feladat: " + title + "Kész van?" + completed + "Mikor készült el:" + completedAt : "Feladat: " + title + "Kész van?" + completed;
    }

}
