package xinQing.web.model.weixinMessage;

/**
 * 文本消息
 *
 * <xml>
 *     <ToUserName><![CDATA[toUser]]></ToUserName>
 *     <FromUserName><![CDATA[fromUser]]></FromUserName>
 *     <CreateTime>1348831860</CreateTime>
 *     <MsgType><![CDATA[text]]></MsgType>
 *     <Content><![CDATA[this is a test]]></Content>
 *     <MsgId>1234567890123456</MsgId>
 * </xml>
 *
 * Created by xinQing on 2016/9/27.
 */
public class TextMessage implements Message {

    private String ToUserName;// 开发者微信号
    private String FromUserName;// 发送方帐号（一个OpenID）
    private Long CreateTime;// 消息创建时间(整型)
    private String MsgType = Message.TEXT_MSG_TYPE;// text
    private String Content;// 文本消息内容
    private Long MsgId;// 消息id，64位整型

    public String getToUserName() {
        return ToUserName;
    }

    public void setToUserName(String toUserName) {
        ToUserName = toUserName;
    }

    public String getFromUserName() {
        return FromUserName;
    }

    public void setFromUserName(String fromUserName) {
        FromUserName = fromUserName;
    }

    public Long getCreateTime() {
        return CreateTime;
    }

    public void setCreateTime(Long createTime) {
        CreateTime = createTime;
    }

    public String getMsgType() {
        return MsgType;
    }

    public void setMsgType(String msgType) {
        MsgType = msgType;
    }

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }

    public Long getMsgId() {
        return MsgId;
    }

    public void setMsgId(Long msgId) {
        MsgId = msgId;
    }

    @Override
    public String toString() {
        return "TextMessage{" +
                "ToUserName='" + ToUserName + '\'' +
                ", FromUserName='" + FromUserName + '\'' +
                ", CreateTime=" + CreateTime +
                ", MsgType='" + MsgType + '\'' +
                ", Content='" + Content + '\'' +
                ", MsgId=" + MsgId +
                '}';
    }
}
