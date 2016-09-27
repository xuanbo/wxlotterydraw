package xinQing.web.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import xinQing.web.entity.User;
import xinQing.web.service.UserService;

/**
 * Created by xinQing on 2016/9/27.
 */
@Service
@Transactional
public class UserServiceImpl extends BaseServiceImpl<User, Integer> implements UserService {
}
