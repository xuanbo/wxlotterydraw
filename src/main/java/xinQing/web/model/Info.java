package xinQing.web.model;

/**
 * Created by xinQing on 2016/9/27.
 */
public class Info {

    private boolean flag;
    private String msg;

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "Info{" +
                "flag=" + flag +
                ", msg='" + msg + '\'' +
                '}';
    }
}
