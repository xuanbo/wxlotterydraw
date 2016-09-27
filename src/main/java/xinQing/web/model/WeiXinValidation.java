package xinQing.web.model;

import org.hibernate.validator.constraints.NotEmpty;

import java.security.MessageDigest;
import java.util.Arrays;

/**
 * Created by xinQing on 2016/9/27.
 */
public class WeiXinValidation {

    public static final String TOKEN = "xuanbo";

    @NotEmpty
    private String signature;

    @NotEmpty
    private String timestamp;

    @NotEmpty
    private String nonce;

    @NotEmpty
    private String echostr;

    /**
     * 自然排序后与signature相等则返回true
     *
     * @return
     */
    public boolean check() {
        if (timestamp == null || nonce == null)
            return false;
        String[] array = {TOKEN, timestamp, nonce};
        Arrays.sort(array);
        StringBuilder content = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            content.append(array[i]);
        }
        return signature.equals(getSha1(content.toString()));
    }

    /**
     * sha1加密
     *
     * @param str
     * @return
     */
    public static String getSha1(String str) {
        if (null == str || 0 == str.length()) {
            return null;
        }
        char[] hexDigits = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
                'a', 'b', 'c', 'd', 'e', 'f'};
        try {
            MessageDigest mdTemp = MessageDigest.getInstance("SHA1");
            mdTemp.update(str.getBytes("UTF-8"));
            byte[] md = mdTemp.digest();
            int j = md.length;
            char[] buf = new char[j * 2];
            int k = 0;
            for (int i = 0; i < j; i++) {
                byte byte0 = md[i];
                buf[k++] = hexDigits[byte0 >>> 4 & 0xf];
                buf[k++] = hexDigits[byte0 & 0xf];
            }
            return new String(buf);
        } catch (Exception e) {
            return null;
        }
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getNonce() {
        return nonce;
    }

    public void setNonce(String nonce) {
        this.nonce = nonce;
    }

    public String getEchostr() {
        return echostr;
    }

    public void setEchostr(String echostr) {
        this.echostr = echostr;
    }
}
