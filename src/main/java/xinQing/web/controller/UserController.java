package xinQing.web.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import xinQing.web.entity.User;
import xinQing.web.model.WeiXinAccess;
import xinQing.web.model.weixinMessage.WeiXinUserInfo;
import xinQing.web.service.UserService;
import xinQing.web.service.WeiXinService;

import java.io.IOException;

/**
 * Created by xinQing on 2016/9/28.
 */
@Controller
@RequestMapping("/user")
public class UserController {

    private static final Logger log = Logger.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @Autowired
    private WeiXinService weiXinService;

    /**
     * 公众号用户访问
     * 如果没有填写自己的信息就填写add
     * 如果以前填写过就查看信息index
     *
     * @param openid
     * @return
     */
    @RequestMapping(value = "/{openid}", method = RequestMethod.GET)
    public String index(@PathVariable String openid, ModelMap modelMap) {
        User user = new User();
        user.setOpenid(openid);
        User persistUser = userService.selectOne(user);
        if (persistUser != null && persistUser.getTel() != null) {
            modelMap.addAttribute("user", persistUser);
            return "user/index";
        }
        WeiXinAccess access = null;
        try {
            access = weiXinService.access();
            log.debug(access);
            WeiXinUserInfo weiXinUserInfo = weiXinService.getWeiXinUserInfo(access, openid);
            log.debug(weiXinUserInfo);
            user = new User();
            user.setOpenid(openid);
            user.setUsername(weiXinUserInfo.getNickname());
            // 其他信息暂时不需要
            userService.insert(user);
            log.debug(user);
            modelMap.addAttribute("user", user);
            return "user/add";
        } catch (IOException e) {
            e.printStackTrace();
            return "redirect:/{openid}";
        }
    }

    @RequestMapping(value = "/{openid}", method = RequestMethod.POST)
    @ResponseBody
    public int insert(@PathVariable String openid, @RequestBody User user) {
        user.setOpenid(openid);
        User persistUser = userService.selectOne(user);
        persistUser.setTel(user.getTel());
        return userService.update(persistUser);
    }

}
