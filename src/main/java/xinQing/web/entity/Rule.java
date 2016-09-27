package xinQing.web.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * 管理员开启的抽奖活动规则
 *
 * Created by xinQing on 2016/9/27.
 */
@Table(name = "rule")
public class Rule implements Serializable {

    @Id
    private Integer id;

    @Column
    private String name;//抽奖名

    @Column
    private String description;//描述

    @Column
    private Date startTime;// 抽奖开始时间

    @Column
    private Date endTime;// 抽奖截止时间

    @Column
    private Integer max;// 抽奖限制的人数

    @Column
    private Integer pickerNum;// 抽奖抽取的人数

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Integer getMax() {
        return max;
    }

    public void setMax(Integer max) {
        this.max = max;
    }

    public Integer getPickerNum() {
        return pickerNum;
    }

    public void setPickerNum(Integer pickerNum) {
        this.pickerNum = pickerNum;
    }

    @Override
    public String toString() {
        return "Rule{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", max=" + max +
                ", pickerNum=" + pickerNum +
                '}';
    }
}
