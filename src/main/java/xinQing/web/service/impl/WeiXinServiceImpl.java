package xinQing.web.service.impl;

import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;
import org.dom4j.DocumentException;
import org.springframework.stereotype.Service;
import xinQing.web.model.WeiXinValidation;
import xinQing.web.model.weixinMessage.Message;
import xinQing.web.model.weixinMessage.TextMessage;
import xinQing.web.service.WeiXinService;
import xinQing.web.util.MessageUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * Created by xinQing on 2016/9/27.
 */
@Service
public class WeiXinServiceImpl implements WeiXinService {

    private static final Logger log = Logger.getLogger(WeiXinServiceImpl.class);

    @Override
    public boolean check(WeiXinValidation weiXinValidation) {
        return weiXinValidation.check();
    }

    @Override
    public void handlerMessage(HttpServletRequest request, HttpServletResponse response) throws IOException, DocumentException {
        String xml = IOUtils.toString(request.getInputStream(), "UTF-8");
        Map<String, Object> messages = MessageUtil.parse(xml);
        // 文本消息
        if (Message.TEXT_MSG_TYPE.equals(messages.get(Message.TEXT_MSG_TYPE))) {
            TextMessage message = new TextMessage();
            message.setToUserName((String) messages.get("FromUserName"));
            message.setFromUserName((String) messages.get("TOUserName"));
            message.setCreateTime(System.currentTimeMillis());
            message.setContent("你发的消息为：" + messages.get("Content"));
            String xmlMessage = MessageUtil.parse(message);
            log.debug(xmlMessage);
            response.setCharacterEncoding("UTF-8");
            response.getWriter().print(xmlMessage);
        }
    }

}
