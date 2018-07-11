package com.baizhi.cmfz.entity;

import java.io.Serializable;

/**
 * @Description 活跃用户
 * @Author Administrator
 * @Time 2018/7/9 19:28
 */
public class Statistics implements Serializable{

    private Integer counts;
    private String time;

    public Statistics(Integer counts, String time) {
        this.counts = counts;
        this.time = time;
    }

    public Integer getCounts() {
        return counts;
    }

    public void setCounts(Integer counts) {
        this.counts = counts;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Statistics() {
        super();
    }

    @Override
    public String toString() {
        return "Statistics{" +
                "counts=" + counts +
                ", time='" + time + '\'' +
                '}';
    }

}
