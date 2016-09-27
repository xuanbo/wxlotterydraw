package xinQing.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by xinQing on 2016/9/27.
 */
@Controller
public class AdminController {

    @RequestMapping(value = "/admin/index", method = RequestMethod.GET)
    public String index() {
        return "admin/index";
    }
}
