package xinQing.web.model;

import xinQing.web.entity.Admin;

/**
 * Created by xinQing on 2016/9/27.
 */
public class AdminInfo {

    private Admin admin;

    private String verificationCode;

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    public String getVerificationCode() {
        return verificationCode;
    }

    public void setVerificationCode(String verificationCode) {
        this.verificationCode = verificationCode;
    }

    @Override
    public String toString() {
        return "AdminInfo{" +
                "admin=" + admin +
                ", verificationCode='" + verificationCode + '\'' +
                '}';
    }
}
