package xinQing.web.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import xinQing.web.dao.AdminMapper;
import xinQing.web.entity.Admin;
import xinQing.web.model.AdminInfo;
import xinQing.web.model.Info;
import xinQing.web.service.AdminService;
import xinQing.web.util.SessionUtil;

import javax.servlet.http.HttpSession;

/**
 * Created by xinQing on 2016/9/27.
 */
@Service
@Transactional
public class AdminServiceImpl extends BaseServiceImpl<Admin, Integer> implements AdminService {

    @Autowired
    private AdminMapper adminMapper;

    @Override
    public Admin selectByLoginName(String loginName) {
        Admin admin = new Admin();
        admin.setLoginName(loginName);
        return adminMapper.selectOne(admin);
    }

    /**
     * 由于新浪云的问题，验证码图片无法显示，因此发布到新浪云中取消登录中的验证码校验
     *
     * @param adminInfo
     * @param session
     * @return
     */
    @Override
    public Info validation(AdminInfo adminInfo, HttpSession session) {
        Info loginInfo = new Info();
//        if (!((String)session.getAttribute(SessionUtil.VERIFICATION_CODE)).equalsIgnoreCase(adminInfo.getVerificationCode())) {
//            loginInfo.setFlag(false);
//            loginInfo.setMsg("验证码输入错误");
//            return loginInfo;
//        }
        Admin persistAdmin = selectByLoginName(adminInfo.getAdmin().getLoginName());
        if (persistAdmin == null) {
            loginInfo.setFlag(false);
            loginInfo.setMsg("该账号不存在");
            return loginInfo;
        }
        Admin admin = adminInfo.getAdmin();
        if (!persistAdmin.getPassword().equals(admin.getPassword())) {
            loginInfo.setFlag(false);
            loginInfo.setMsg("密码错误");
            return loginInfo;
        }
        session.setAttribute(SessionUtil.ADMIN, admin);
        loginInfo.setFlag(true);
        loginInfo.setMsg("登录成功");
        return loginInfo;
    }
}
