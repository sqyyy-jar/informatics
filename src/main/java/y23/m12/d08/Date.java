package y23.m12.d08;

public class Date implements Comparable<Date> {
    private final int year;
    private final int month;
    private final int day;

    public Date(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }

    @Override
    public int compareTo(Date o) {
        int i;
        if ((i = this.year - o.year) != 0) {
            return i;
        }
        if ((i = this.month - o.month) != 0) {
            return i;
        }
        return this.day - o.day;
    }
}
