package xinQing.web.model;

/**
 * https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=wxa194c412ff6030f6&secret=d0c3f3e94d90b0e92d27f0f5cf4d5f92
 *
 *
 * Created by xinQing on 2016/9/28.
 */
public class WeiXinAccess {

    private String access_token;

    private String expires_in;

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public String getExpires_in() {
        return expires_in;
    }

    public void setExpires_in(String expires_in) {
        this.expires_in = expires_in;
    }

    @Override
    public String toString() {
        return "WeiXinAccess{" +
                "access_token='" + access_token + '\'' +
                ", expires_in='" + expires_in + '\'' +
                '}';
    }
}
