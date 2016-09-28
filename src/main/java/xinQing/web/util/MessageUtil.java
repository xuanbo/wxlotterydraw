package xinQing.web.util;

import com.thoughtworks.xstream.XStream;
import org.apache.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import xinQing.web.model.weixinMessage.Message;
import xinQing.web.model.weixinMessage.TextMessage;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by xinQing on 2016/9/28.
 */
public class MessageUtil {

    private static final Logger log = Logger.getLogger(MessageUtil.class);

    /**
     * xml字符串转map
     *
     * @param xml
     * @return
     */
    public static Map<String, Object> parse(String xml) throws DocumentException {
        Map<String, Object> map = new HashMap<>();
        Document document = DocumentHelper.parseText(xml);
        List<Element> elements = document.getRootElement().elements();
        elements.forEach(element -> map.put(element.getName(), element.getText()));
        return map;
    }

    /**
     * Message转xml字符串
     *
     * @return
     */
    public static String parse(Message message) {
        XStream xStream = new XStream();
        xStream.alias("xml", message.getClass());
        return xStream.toXML(message);
    }


    /**
     * 处理帮助消息
     *
     * @param messages
     * @param response
     */
    public static void handlerHelpMessage(Map<String, Object> messages, HttpServletResponse response) throws IOException {
        String content = "当公众号开启抽奖后，你可以回复：抽奖 抽奖的序列。来进行抽奖。例如回复：抽奖 123";
        handlerMessage(content, messages, response);
    }

    public static void handlerErrorMessage(Map<String, Object> messages, HttpServletResponse response) throws IOException {
        String content = "你发送的消息格式不合法，请输入【帮助】来查看帮助信息";
        handlerMessage(content, messages, response);
    }

    /**
     * 处理消息
     *
     * @param content
     * @param messages
     * @param response
     * @throws IOException
     */
    public static void handlerMessage(String content, Map<String, Object> messages, HttpServletResponse response) throws IOException {
        TextMessage message = new TextMessage();
        message.setToUserName((String) messages.get("FromUserName"));
        message.setFromUserName((String) messages.get("ToUserName"));
        message.setCreateTime(System.currentTimeMillis());
        message.setContent(content);
        message.setMsgType(Message.TEXT_MSG_TYPE);
        String xmlMessage = MessageUtil.parse(message);
        log.debug("发送消息" + xmlMessage);
        response.setCharacterEncoding("UTF-8");
        response.getWriter().print(xmlMessage);
    }

}
