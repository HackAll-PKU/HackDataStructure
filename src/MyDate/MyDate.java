package MyDate;

import java.util.Date;

/**
 * Created by Sample on 2016/4/10.
 */
public class MyDate implements Comparable<MyDate> {
    private long unixDate;

    /**
     * 根据当前时间初始化
     */
    public MyDate() {
        unixDate = System.currentTimeMillis() / 86400000L;
    }

    /**
     * 根据年月日初始化
     * @param y 年
     * @param m 月
     * @param d 日
     */
    public MyDate(int y, int m, int d) {
        unixDate = new Date(y, m, d).getTime() / 86400000L;
    }

    /**
     * 根据年月初始化
     * @param y 年
     * @param m 月
     */
    public MyDate(int y, int m) {
        unixDate = new Date(y, m, 1).getTime() / 86400000L;
    }

    /**
     * 根据unixDate初始化
     * @param unixDate unixDate
     */
    public MyDate(long unixDate) {
        this.unixDate = unixDate;
    }

    /**
     * 加减一定的天数
     * @param n 加减的天数
     * @return 返回自己
     */
    public MyDate add(int n) {
        unixDate += n;
        return this;
    }

    /**
     * 在此实例天数的基础上加减一定的天数所得的值
     * @param n 加减的天数
     * @return 加减之后所得的值
     */
    public MyDate getOffset(int n) {
        return new MyDate(unixDate + n);
    }

    /**
     * 获取星期几,以周日为0,周一为1
     * @return 星期几
     */
    public long getWeekday() {
        return (unixDate + 2) % 7;
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
