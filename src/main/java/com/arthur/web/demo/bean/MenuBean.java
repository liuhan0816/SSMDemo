package com.arthur.web.demo.bean;

import java.util.List;

/**
 * @ClassName MenuBean
 * @Description 菜单bean
 * @Author liuhan
 * @Date 2019/8/12 16:11
 * @Version 1.0
 **/
public class MenuBean {
    String appKey;
    String appName;
    List<MenuChildBean> menus;

    /**
     * 获取字段 appKey
     *
     * @return 获取字段 appKey
     */
    public String getAppKey() {
        return appKey;
    }

    /**
     * 赋予字段 appKey
     * <p>你可以使用getAppKey() 来获取字段的值 appKey</p>
     *
     * @param appKey appKey
     */
    public void setAppKey(String appKey) {
        this.appKey = appKey;
    }

    /**
     * 获取字段 appName
     *
     * @return 获取字段 appName
     */
    public String getAppName() {
        return appName;
    }

    /**
     * 赋予字段 appName
     * <p>你可以使用getAppName() 来获取字段的值 appName</p>
     *
     * @param appName appName
     */
    public void setAppName(String appName) {
        this.appName = appName;
    }

    /**
     * 获取字段 menus
     *
     * @return 获取字段 menus
     */
    public List<MenuChildBean> getMenus() {
        return menus;
    }

    /**
     * 赋予字段 menus
     * <p>你可以使用getMenus() 来获取字段的值 menus</p>
     *
     * @param menus menus
     */
    public void setMenus(List<MenuChildBean> menus) {
        this.menus = menus;
    }
}
