package com.arthur.web.controller.member.index;

import com.arthur.web.core.controller.BaseController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * @ClassName IndexController
 * @Description TODO
 * @Author liuhan
 * @Date 2019/8/1 11:22
 * @Version 1.0
 **/
@Controller
@RequestMapping(value = "/member")
public class IndexController extends BaseController {
    private static final Logger logger = LoggerFactory.getLogger(IndexController.class);

    @RequestMapping(value = "/index")
    public String index(Model model, String userId, String userPassword, String certificationCode) {

        return "/member/index/index";
    }

    @RequestMapping(value = "/home")
    public String home() {
        return "/member/index/home";
    }

    @RequestMapping(value = "/menu")
    @ResponseBody
    public void menu() throws IOException {
        response.setContentType("text/json;charset=UTF-8");
        response.setCharacterEncoding("utf-8");
        PrintWriter pw = response.getWriter();
        pw.print("{\n" +
                "\t\"code\": 200,\n" +
                "\t\"token\": \"taVJM3Ba3lD/YmU19m1VLj9BrBMs8CdS\",\n" +
                "\t\"msg\": null,\n" +
                "\t\"data\": [\n" +
                "\t\t{\n" +
                "\t\t\t\"title\": \"主页\",\n" +
                "\t\t\t\"icon\": \"&#xe68e;\",\n" +
                "\t\t\t\"href\": \"/member/index\",\n" +
                "\t\t\t\"children\": []\n" +
                "\t\t},\n" +
                "\t\t{\n" +
                "\t\t\t\"title\": \"用户权限\",\n" +
                "\t\t\t\"icon\": \"&#xe672;\",\n" +
                "\t\t\t\"href\": \"\",\n" +
                "\t\t\t\"children\": [\n" +
                "\t\t\t\t{\n" +
                "\t\t\t\t\t\"title\": \"用户管理\",\n" +
                "\t\t\t\t\t\"icon\": \"&#xe612;\",\n" +
                "\t\t\t\t\t\"href\": \"/member/account/index\",\n" +
                "\t\t\t\t\t\"children\": []\n" +
                "\t\t\t\t},\n" +
                "\t\t\t\t{\n" +
                "\t\t\t\t\t\"title\": \"用户管理tree\",\n" +
                "\t\t\t\t\t\"icon\": \"&#xe60a;\",\n" +
                "\t\t\t\t\t\"href\": \"/member/account/tree\",\n" +
                "\t\t\t\t\t\"children\": []\n" +
                "\t\t\t\t},\n" +
                "\t\t\t\t{\n" +
                "\t\t\t\t\t\"title\": \"角色管理\",\n" +
                "\t\t\t\t\t\"icon\": \"&#xe613;\",\n" +
                "\t\t\t\t\t\"href\": \"pages/userRights/role.html\",\n" +
                "\t\t\t\t\t\"children\": []\n" +
                "\t\t\t\t},\n" +
                "\t\t\t\t{\n" +
                "\t\t\t\t\t\"title\": \"菜单管理\",\n" +
                "\t\t\t\t\t\"icon\": \"&#xe62a;\",\n" +
                "\t\t\t\t\t\"href\": \"pages/userRights/menu.html\",\n" +
                "\t\t\t\t\t\"children\": []\n" +
                "\t\t\t\t}\n" +
                "\t\t\t]\n" +
                "\t\t},\n" +
                "\t\t{\n" +
                "\t\t\t\"title\": \"系统设置\",\n" +
                "\t\t\t\"icon\": \"&#xe614;\",\n" +
                "\t\t\t\"href\": \"\",\n" +
                "\t\t\t\"children\": [\n" +
                "\t\t\t\t{\n" +
                "\t\t\t\t\t\"title\": \"基本信息\",\n" +
                "\t\t\t\t\t\"icon\": \"&#xe647;\",\n" +
                "\t\t\t\t\t\"href\": \"pages/sysSetup/basicData.html\",\n" +
                "\t\t\t\t\t\"children\": []\n" +
                "\t\t\t\t},\n" +
                "\t\t\t\t{\n" +
                "\t\t\t\t\t\"title\": \"数据清理\",\n" +
                "\t\t\t\t\t\"icon\": \"&#xe640;\",\n" +
                "\t\t\t\t\t\"href\": \"pages/sysSetup/dataClear.html\",\n" +
                "\t\t\t\t\t\"children\": []\n" +
                "\t\t\t\t},\n" +
                "\t\t\t\t{\n" +
                "\t\t\t\t\t\"title\": \"SEO优化\",\n" +
                "\t\t\t\t\t\"icon\": \"&#xe630;\",\n" +
                "\t\t\t\t\t\"href\": \"pages/sysSetup/seoOptimize.html\",\n" +
                "\t\t\t\t\t\"children\": []\n" +
                "\t\t\t\t},\n" +
                "\t\t\t\t{\n" +
                "\t\t\t\t\t\"title\": \"友情链接\",\n" +
                "\t\t\t\t\t\"icon\": \"&#xe62e;\",\n" +
                "\t\t\t\t\t\"href\": \"pages/sysSetup/friendshipLink.html\",\n" +
                "\t\t\t\t\t\"children\": []\n" +
                "\t\t\t\t},\n" +
                "\t\t\t\t{\n" +
                "\t\t\t\t\t\"title\": \"模板管理\",\n" +
                "\t\t\t\t\t\"icon\": \"&#xe663;\",\n" +
                "\t\t\t\t\t\"href\": \"pages/sysSetup/templateAdmin.html\",\n" +
                "\t\t\t\t\t\"children\": []\n" +
                "\t\t\t\t}\n" +
                "\t\t\t]\n" +
                "\t\t},\n" +
                "\t\t{\n" +
                "\t\t\t\"title\": \"报表\",\n" +
                "\t\t\t\"icon\": \"&#xe637;\",\n" +
                "\t\t\t\"href\": \"\",\n" +
                "\t\t\t\"children\": [\n" +
                "\t\t\t\t{\n" +
                "\t\t\t\t\t\"title\": \"用户统计\",\n" +
                "\t\t\t\t\t\"icon\": \"&#xe629;\",\n" +
                "\t\t\t\t\t\"href\": \"pages/reportForm/statistics.html\",\n" +
                "\t\t\t\t\t\"children\": []\n" +
                "\t\t\t\t},\n" +
                "\t\t\t\t{\n" +
                "\t\t\t\t\t\"title\": \"日志报表\",\n" +
                "\t\t\t\t\t\"icon\": \"&#xe62a;\",\n" +
                "\t\t\t\t\t\"href\": \"pages/reportForm/log.html\",\n" +
                "\t\t\t\t\t\"children\": []\n" +
                "\t\t\t\t}\n" +
                "\t\t\t]\n" +
                "\t\t}\n" +
                "\t]\n" +
                "}");
        pw.flush();
        pw.close();
    }
}
