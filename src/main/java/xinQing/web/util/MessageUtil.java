package xinQing.web.util;

import com.thoughtworks.xstream.XStream;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import xinQing.web.model.weixinMessage.Message;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by xinQing on 2016/9/28.
 */
public class MessageUtil {

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

}
