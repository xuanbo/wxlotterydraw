package xinQing.web.controller;

import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import xinQing.web.entity.Rule;
import xinQing.web.service.RuleService;

/**
 * Created by xinQing on 2016/9/27.
 */
@Controller
public class RuleController {

    @Autowired
    private RuleService ruleService;

    @RequestMapping(value = "/rule", method = RequestMethod.POST)
    @ResponseBody
    public int insert(@RequestBody Rule rule) {
        return ruleService.insert(rule);
    }

    @RequestMapping(value = "/rules", method = RequestMethod.GET)
    @ResponseBody
    public PageInfo<Rule> selectByPage(@RequestParam(required = false, defaultValue = "1") Integer current,
                            @RequestParam(required = false, defaultValue = "10") Integer size) {
        return ruleService.getByPage(current, size);
    }

    @RequestMapping(value = "/rule", method = RequestMethod.PUT)
    @ResponseBody
    public int update(@RequestBody Rule rule) {
        return ruleService.update(rule);
    }

    @RequestMapping(value = "/rule/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public int update(@PathVariable Integer id) {
        return ruleService.delete(id);
    }
}
