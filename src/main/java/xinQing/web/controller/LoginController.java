package xinQing.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import xinQing.web.model.AdminInfo;
import xinQing.web.model.Info;
import xinQing.web.service.AdminService;

import javax.servlet.http.HttpSession;

/**
 * Created by xinQing on 2016/9/27.
 */
@Controller
public class LoginController {

    @Autowired
    private AdminService adminService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public Info login(@RequestBody AdminInfo adminInfo, HttpSession session) {
        return adminService.validation(adminInfo, session);
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }
}
