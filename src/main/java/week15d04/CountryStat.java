package week15d04;

public class CountryStat implements Comparable<CountryStat>{

    private String week;
    private int cases;

    public CountryStat(String week, int cases) {
        this.week = week;
        this.cases = cases;
    }

    public String getWeek() {
        return week;
    }

    public int getCases() {
        return cases;
    }

    @Override
    public String toString() {
        return "CountryStat{" +
                "week='" + week + '\'' +
                ", cases=" + cases +
                '}';
    }


    @Override
    public int compareTo(CountryStat o) {
        return o.getCases()-getCases();
    }
}
