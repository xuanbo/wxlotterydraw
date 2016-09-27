package xinQing.web.service;

import org.dom4j.DocumentException;
import xinQing.web.model.WeiXinValidation;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by xinQing on 2016/9/27.
 */
public interface WeiXinService {

    /**
     * 验证微信是否正确接入
     *
     * @param weiXinValidation
     * @return
     */
    boolean check(WeiXinValidation weiXinValidation);

    /**
     * 处理微信转发的消息
     *
     * @param request
     * @param response
     */
    void handlerMessage(HttpServletRequest request, HttpServletResponse response) throws IOException, DocumentException;

}
