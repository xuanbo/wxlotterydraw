package xinQing.web.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import xinQing.web.entity.Activity;
import xinQing.web.service.ActivityService;

/**
 * Created by xinQing on 2016/9/27.
 */
@Service
@Transactional
public class ActivityServiceImpl extends BaseServiceImpl<Activity, Integer> implements ActivityService {
}
