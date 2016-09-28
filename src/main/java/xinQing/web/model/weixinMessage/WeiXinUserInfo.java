package xinQing.web.model.weixinMessage;

/**
 * Created by xinQing on 2016/9/28.
 */
public class WeiXinUserInfo {

    private String subscribe;

    private String openid;

    private String nickname;

    private Integer sex;

    private String city;

    private String country;

    private String province;

    private String language;

    private String headimgurl;

    private Long subscribe_time;

    public String getSubscribe() {
        return subscribe;
    }

    public void setSubscribe(String subscribe) {
        this.subscribe = subscribe;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getHeadimgurl() {
        return headimgurl;
    }

    public void setHeadimgurl(String headimgurl) {
        this.headimgurl = headimgurl;
    }

    public Long getSubscribe_time() {
        return subscribe_time;
    }

    public void setSubscribe_time(Long subscribe_time) {
        this.subscribe_time = subscribe_time;
    }

    @Override
    public String toString() {
        return "WeiXinUserInfo{" +
                "subscribe='" + subscribe + '\'' +
                ", openid='" + openid + '\'' +
                ", nickname='" + nickname + '\'' +
                ", sex=" + sex +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                ", province='" + province + '\'' +
                ", language='" + language + '\'' +
                ", headimgurl='" + headimgurl + '\'' +
                ", subscribe_time=" + subscribe_time +
                '}';
    }
}
