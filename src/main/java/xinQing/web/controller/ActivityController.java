package xinQing.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import xinQing.web.service.ActivityService;
import xinQing.web.service.RuleService;

/**
 * Created by xinQing on 2016/9/27.
 */
@Controller
public class ActivityController {

    @Autowired
    private RuleService ruleService;

    @Autowired
    private ActivityService activityService;

}
