package xinQing.web.controller;

import org.apache.log4j.Logger;
import org.dom4j.DocumentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import xinQing.web.model.WeiXinValidation;
import xinQing.web.service.WeiXinService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;

/**
 * Created by xinQing on 2016/9/27.
 */
@Controller
@RequestMapping("/api/weixin")
public class WeiXinController {

    private static final Logger log = Logger.getLogger(WeiXinController.class);

    @Autowired
    private WeiXinService weiXinService;

    @RequestMapping(value = "/check", method = RequestMethod.GET)
    @ResponseBody
    public String checkSignature(@Valid WeiXinValidation validation, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            log.error(bindingResult);
        }
        if (weiXinService.check(validation)) {
            return validation.getEchostr();
        }
        return "error";
    }

    @RequestMapping(value = "/check", method = RequestMethod.POST)
    public void handlerMessage(HttpServletRequest request, HttpServletResponse response) {
        try {
            weiXinService.handlerMessage(request, response);
        } catch (IOException | DocumentException e) {
            e.printStackTrace();
        }
    }

}
