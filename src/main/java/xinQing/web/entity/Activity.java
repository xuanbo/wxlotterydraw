package xinQing.web.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 某个微信号参与某次抽奖
 *
 * Created by xinQing on 2016/9/27.
 */
@Table(name = "activity")
public class Activity {

    @Id
    private Integer id;

    @Column
    private Integer ruleId; // 规则id

    @Column
    private String loginName; // 微信号

    @Column
    private boolean status; // 是否中奖

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRuleId() {
        return ruleId;
    }

    public void setRuleId(Integer ruleId) {
        this.ruleId = ruleId;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Activity{" +
                "id=" + id +
                ", ruleId=" + ruleId +
                ", loginName='" + loginName + '\'' +
                ", status=" + status +
                '}';
    }
}
