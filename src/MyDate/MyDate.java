package MyDate;

import java.util.Date;

/**
 * Created by Sample on 2016/4/10.
 */
public class MyDate implements Comparable<MyDate> {
    private long unixDate;

    public MyDate() {
        unixDate = System.currentTimeMillis() / 86400000L;
    }

    public MyDate(int y, int m, int d) {
        unixDate = new Date(y, m, d).getTime() / 86400000L;
    }

    public MyDate(int y, int m) {
        unixDate = new Date(y, m, 1).getTime() / 86400000L;
    }

    public MyDate(long unixDate) {
        this.unixDate = unixDate;
    }

    public MyDate add(int n) {
        unixDate += n;
        return this;
    }

    public MyDate getOffset(int n) {
        return new MyDate(unixDate + n);
    }

    public long getWeek() {
        return (unixDate + 4) % 7;
    }

    @Override
    public int compareTo(MyDate rVal) {
        if (unixDate == rVal.unixDate) return 0;
        if (unixDate < rVal.unixDate) return -1;
        return 1;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (null == obj) return false;
        if (getClass() != obj.getClass()) return false;
        MyDate rVal = (MyDate) obj;
        return rVal.unixDate == this.unixDate;
    }

    @Override
    public int hashCode() {
        return (int) unixDate;
    }

}
