package xinQing.web.service;

import xinQing.web.entity.Admin;
import xinQing.web.model.AdminInfo;
import xinQing.web.model.Info;

import javax.servlet.http.HttpSession;

/**
 * Created by xinQing on 2016/9/27.
 */
public interface AdminService extends BaseService<Admin, Integer> {

    Admin selectByLoginName(String loginName);

    Info validation(AdminInfo adminInfo, HttpSession session);
}
