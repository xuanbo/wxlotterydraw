package xinQing.web.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import xinQing.web.entity.Rule;
import xinQing.web.service.BaseService;
import xinQing.web.service.RuleService;

/**
 * Created by xinQing on 2016/9/27.
 */
@Service
@Transactional
public class RuleServiceImpl extends BaseServiceImpl<Rule, Integer> implements RuleService {
}
