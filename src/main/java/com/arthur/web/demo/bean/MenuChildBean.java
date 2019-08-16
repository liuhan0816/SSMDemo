package com.arthur.web.demo.bean;

/**
 * @ClassName MenuChildBean
 * @Description TODO
 * @Author liuhan
 * @Date 2019/8/12 16:12
 * @Version 1.0
 **/
public class MenuChildBean {
    String id;
    String parentId;
    String name;
    String type;
    String sort;
    String url;

    /**
     * 获取字段 id
     *
     * @return 获取字段 id
     */
    public String getId() {
        return id;
    }

    /**
     * 赋予字段 id
     * <p>你可以使用getId() 来获取字段的值 id</p>
     *
     * @param id id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * 获取字段 parentId
     *
     * @return 获取字段 parentId
     */
    public String getParentId() {
        return parentId;
    }

    /**
     * 赋予字段 parentId
     * <p>你可以使用getParentId() 来获取字段的值 parentId</p>
     *
     * @param parentId parentId
     */
    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    /**
     * 获取字段 name
     *
     * @return 获取字段 name
     */
    public String getName() {
        return name;
    }

    /**
     * 赋予字段 name
     * <p>你可以使用getName() 来获取字段的值 name</p>
     *
     * @param name name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取字段 type
     *
     * @return 获取字段 type
     */
    public String getType() {
        return type;
    }

    /**
     * 赋予字段 type
     * <p>你可以使用getType() 来获取字段的值 type</p>
     *
     * @param type type
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * 获取字段 sort
     *
     * @return 获取字段 sort
     */
    public String getSort() {
        return sort;
    }

    /**
     * 赋予字段 sort
     * <p>你可以使用getSort() 来获取字段的值 sort</p>
     *
     * @param sort sort
     */
    public void setSort(String sort) {
        this.sort = sort;
    }

    /**
     * 获取字段 url
     *
     * @return 获取字段 url
     */
    public String getUrl() {
        return url;
    }

    /**
     * 赋予字段 url
     * <p>你可以使用getUrl() 来获取字段的值 url</p>
     *
     * @param url url
     */
    public void setUrl(String url) {
        this.url = url;
    }
}
