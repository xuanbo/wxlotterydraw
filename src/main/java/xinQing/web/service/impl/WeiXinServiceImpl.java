package xinQing.web.service.impl;

import com.google.gson.Gson;
import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;
import org.dom4j.DocumentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import xinQing.web.dao.ActivityMapper;
import xinQing.web.dao.RuleMapper;
import xinQing.web.dao.UserMapper;
import xinQing.web.entity.Activity;
import xinQing.web.entity.Rule;
import xinQing.web.entity.User;
import xinQing.web.model.WeiXinAccess;
import xinQing.web.model.WeiXinValidation;
import xinQing.web.model.weixinMessage.Message;
import xinQing.web.model.weixinMessage.WeiXinUserInfo;
import xinQing.web.service.WeiXinService;
import xinQing.web.util.MessageUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Map;

/**
 * Created by xinQing on 2016/9/27.
 */
@Service
@Transactional
public class WeiXinServiceImpl implements WeiXinService {

    private static final Logger log = Logger.getLogger(WeiXinServiceImpl.class);

    @Autowired
    private RuleMapper ruleMapper;

    @Autowired
    private ActivityMapper activityMapper;

    @Autowired
    private UserMapper userMapper;

    @Override
    public boolean check(WeiXinValidation weiXinValidation) {
        return weiXinValidation.check();
    }

    /**
     * 对用户发过来的指令，如何采取操作的信息应该存放在数据库，现在为了简单就硬编码写死了
     *
     * @param request
     * @param response
     * @throws IOException
     * @throws DocumentException
     */
    @Override
    public void handlerMessage(HttpServletRequest request, HttpServletResponse response) throws IOException, DocumentException {
        String xml = IOUtils.toString(request.getInputStream(), "UTF-8");
        log.debug("接收消息" + xml);
        Map<String, Object> messages = MessageUtil.parse(xml);
        // 文本消息
        if (Message.TEXT_MSG_TYPE.equals(messages.get("MsgType"))) {
            long currentTime = System.currentTimeMillis();
            String content = (String) messages.get("Content");
            // 用户参与抽奖
            if (content.matches("抽奖 \\d+")) {
                int ruleId = Integer.parseInt(content.split(" ")[1]);
                Rule persistRule = ruleMapper.selectByPrimaryKey(ruleId);
                if (persistRule == null) {
                    MessageUtil.handlerMessage("请不要乱抽奖啊小伙子！", messages, response);
                    return;
                }
                if (currentTime < persistRule.getStartTime().getTime()) {
                    MessageUtil.handlerMessage("现在还没到抽奖开始的时候啊小伙子！", messages, response);
                    return;
                }
                if (currentTime > persistRule.getEndTime().getTime()) {
                    MessageUtil.handlerMessage("抽奖的时间已经截止了，手速很慢啊小伙子，再去练个10年！", messages, response);
                    return;
                }
                Activity activity = new Activity();
                activity.setRuleId(ruleId);
                if (activityMapper.selectCount(activity) >= persistRule.getMax()) {
                    MessageUtil.handlerMessage("抽奖人数已经满了哦，手速很慢啊小伙子，再去练个10年！", messages, response);
                    return;
                }
                String openid = (String) messages.get("FromUserName");
                activity = new Activity();
                activity.setOpenid(openid);
                activity.setRuleId(ruleId);
                if (activityMapper.selectOne(activity) != null) {
                    MessageUtil.handlerMessage("少侠你已经参与了本次抽奖活啦!不要在展现你的手速了！", messages, response);
                    return;
                }

                activityMapper.insert(activity);
                User user = new User();
                user.setOpenid(openid);
                User persistUser = userMapper.selectOne(user);
                if (persistUser == null || persistUser.getTel() == null) {
                    MessageUtil.handlerMessage("少侠，好手速！你已经成功参与了本次抽奖活啦!你还没填写你的个人信息哦!请到如下的链接[http://penshower.com/user/" + openid + "]中填写你的信息，以便中奖号发送信息给你。", messages, response);
                } else {
                    MessageUtil.handlerMessage("少侠，好手速！你已经成功参与了本次抽奖活啦", messages, response);
                }
            } else if ("帮助".equals(content)) {// 帮助
                MessageUtil.handlerHelpMessage(messages, response);
            } else {// 不合法的消息
                MessageUtil.handlerErrorMessage(messages, response);
            }
        }
    }

    @Override
    public WeiXinAccess access() throws IOException {
        String url = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=wxa194c412ff6030f6&secret=d0c3f3e94d90b0e92d27f0f5cf4d5f92";
        Gson gson = new Gson();
        return gson.fromJson(readFromURL(url), WeiXinAccess.class);
    }

    @Override
    public WeiXinUserInfo getWeiXinUserInfo(WeiXinAccess weiXinAccess, String openId) throws IOException {
        String url = "https://api.weixin.qq.com/cgi-bin/user/info?access_token=" + weiXinAccess.getAccess_token() + "&openid=" + openId + "&lang=zh_CN";
        Gson gson = new Gson();
        return gson.fromJson(readFromURL(url), WeiXinUserInfo.class);
    }

    /**
     * 调用微信接口
     *
     * @param urlStr
     * @return
     * @throws IOException
     */
    public static String readFromURL(String urlStr) throws IOException {
        URL url = new URL(urlStr);
        URLConnection connection = url.openConnection();
        BufferedInputStream bufferedInputStream = new BufferedInputStream(connection.getInputStream());
        byte[] bytes = new byte[1024];
        int len = 0;
        StringBuilder sb = new StringBuilder();
        while ((len = bufferedInputStream.read(bytes)) != -1) {
            sb.append(new String(bytes, 0, len));
        }
        bufferedInputStream.close();
        return sb.toString();
    }

}
