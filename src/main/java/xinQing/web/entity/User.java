package xinQing.web.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by xinQing on 2016/9/27.
 */
@Table(name = "user")
public class User implements Serializable {

    @Id
    private Integer id;

    @Column
    private String openid;// 微信openid

    @Column
    private String username;// 微信昵称

    private String tel;// 手机号

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openId) {
        this.openid = openId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", openid='" + openid + '\'' +
                ", username='" + username + '\'' +
                ", tel='" + tel + '\'' +
                '}';
    }
}
