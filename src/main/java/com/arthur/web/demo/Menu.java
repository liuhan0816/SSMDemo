package com.arthur.web.demo;

import com.alibaba.fastjson.JSON;
import com.arthur.web.demo.bean.MenuBean;
import com.arthur.web.demo.bean.MenuChildBean;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName Menu
 * @Description 本地菜单调试
 * @Author liuhan
 * @Date 2019/8/12 16:07
 * @Version 1.0
 **/
public class Menu {

    public static String generalMenu(){
        MenuBean menu = new MenuBean();
        List<MenuChildBean> list = new ArrayList<MenuChildBean>();

        menu.setAppName("测试平台");
        menu.setAppKey("001");

        //一级菜单ID
        String childrenId = "";
        String rootId = "-1";

        /*
         * ID命名规则
         * -1，根目录
         * 001，1级目录，同级目录，依次+1
         * 00101,2级目录，同级目录，依次+1
         * 0010101,3级目录，同级目录，依次+1
         */
        String parentId1 = initRoot(list, "货代业务", "10", "001",rootId);
        String parentId2 = initRoot(list, "报关行业务", "20", "002",rootId);
        String parentId3 = initRoot(list, "驳船业务", "30", "003",rootId);
        String parentId4 = initRoot(list, "车队业务", "40", "004",rootId);
        String parentId5 = initRoot(list, "系统管理", "50", "005",rootId);


        menu.setMenus(list);

        String result = JSON.toJSONString(menu);

        return result;
    }


    /*
     * 新建一级菜单
     */
    public static String initRoot(List<MenuChildBean> list,String name,String sort,String id,String parentId){
        MenuChildBean bean = new MenuChildBean();
        bean.setId(id);
        bean.setParentId(parentId);
        bean.setName(name);
        bean.setType("0");
        bean.setSort(sort);
        list.add(bean);
        return id;
    }

    /*
     * 新建子菜单-功能
     */
    public static String initChildren(List<MenuChildBean> list,String name,String sort,String url,String id,String parentId){
        MenuChildBean bean = new MenuChildBean();
        bean.setId(id);
        bean.setParentId(parentId);
        bean.setName(name);
        bean.setType("1");
        bean.setSort(sort);
        bean.setUrl(url);
        list.add(bean);
        return id;
    }
}
