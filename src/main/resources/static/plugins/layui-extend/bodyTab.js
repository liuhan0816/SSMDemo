layui.define(['element', 'layer', 'jquery'], function (drdrdr) {

    var tabFilter;

    var element = layui.element;
    var layer = layui.layer;
    var $ = layui.jquery;
    var Tab = function () {
        this.tabConfig = {
            openTabNum: undefined,
            tabFilter: undefined,
            ajaxSettings: {}
        }
    };

    //需要渲染左侧菜单的html
    function navBar(strData) {


        //图标字符转换为html
        var convertIconHtml = function (iconStr) {
            var openTitle = '';
            if (iconStr) {
                if (iconStr.split("-")[0] == 'icon') {
                    openTitle += '<i data-icon="' + iconStr + '" class="iconfont ' + iconStr + '"></i>';
                } else {
                    if (iconStr && (iconStr.length > 3) && (iconStr.indexOf('&') === -1)) {
                        openTitle += '<i data-icon="' + iconStr + '" class="layui-icon ' + iconStr + '"></i>';
                    } else {
                        openTitle += '<i data-icon="' + iconStr + '" class="layui-icon">' + iconStr + '</i>';
                    }
                }
            } else {
                openTitle += '<i class="layui-icon"></i>';
            }
            return openTitle;
        }


        //递归获取子菜单html
        var getChildrenHtml = function (item) {
            var ulHtml = '<li class="layui-nav-item">';
            if (item.children != undefined && item.children.length > 0) {
                ulHtml += '<a title="' + item.title + '" href="javascript:void(0)">';

                ulHtml += convertIconHtml(item.icon);

                ulHtml += '<cite>' + item.title + '</cite>';
                ulHtml += '<span class="layui-nav-more"></span>';
                ulHtml += '</a>';
                ulHtml += '<ul class="layui-nav-child">';

                for (var i = 0; i < item.children.length; i++) {
                    ulHtml += getChildrenHtml(item.children[i]);
                }

                ulHtml += "</ul>";

            }
            else {
                if (item.target) {
                    ulHtml += '<a title="' + item.title + '" href="' + item.href + '" data-url="' + item.href + '" target="' + item.target + '">';
                } else {
                    ulHtml += '<a title="' + item.title + '" href="' + item.href + '" data-url="' + item.href + '">';
                }
                ulHtml += convertIconHtml(item.icon);
                ulHtml += '<cite>' + item.title + '</cite></a>';
            }
            ulHtml += '</li>';
            return ulHtml;
        }


        //菜单解析
        var data;
        if (typeof (strData) == "string") {
            var data = eval("(" + strData + ")"); //部分用户解析出来的是字符串，转换一下
        } else {
            data = strData;
        }
        var ulHtml = '<ul class="layui-nav layui-nav-tree"  lay-filter="magetree">';
        for (var i = 0; i < data.length; i++) {
            ulHtml += getChildrenHtml(data[i]);
        }
        ulHtml += '</ul>';
        return ulHtml;
    }


    //获取二级菜单数据
    Tab.prototype.render = function () {

        var _this = this;
        var ajaxSettings = _this.tabConfig.ajaxSettings;

        ajaxSettings.success = function (data) {

            if (typeof (data) == "string") {
                //如果是字符格式则转为js对象
                data = JSON.parse(data);
            }

            if (data.code == 200) {
                //显示左侧菜单
                if ($(".navBar").html() == '') {
                    var htmlyem = navBar(data.data);
                    $(".navBar").html(htmlyem);
                    element.render();  //初始化页面元素

                    var openTabTitle = $('#top_tabs li.layui-this').first().find('cite').text();
                    if (openTabTitle) {
                        _this.selectedMenu(openTabTitle);
                    }
                }
            } else {
                layer.msg((data.msg || '加载错误'), { anim: 10, icon: 0 });
            }

        }

        ajaxSettings.error = function (ex) {

            console.warn(ex.responseText);

        }


        //jquery ajax请求
        $.ajax(ajaxSettings);

    }

    //参数设置
    Tab.prototype.set = function (option) {
        var _this = this;
        $.extend(true, _this.tabConfig, option);

        //渲染左侧菜单
        _this.render();

        return _this;
    };

    //通过title选中菜单
    Tab.prototype.selectedMenu = function (title) {
        $(".navBar a.layui-this,.navBar dd.layui-this,.navBar li.layui-this").removeClass('layui-this');
        $('.navBar li.layui-nav-item').removeClass('layui-nav-itemed');
        $('.navBar a[title="' + title + '"]').first().addClass('layui-this').parent().addClass('layui-this').parents('li.layui-nav-item').addClass('layui-nav-itemed');
    }

    //通过title获取lay-id
    Tab.prototype.getLayId = function (title) {
        $(".layui-tab-title.top_tab li").each(function () {
            if ($(this).find("cite").text() == title) {
                layId = $(this).attr("lay-id");
                return false;
            }
        })
        return layId;
    }
    //通过title判断tab是否存在
    Tab.prototype.hasTab = function (title) {
        var tabIndex = -1;
        $(".layui-tab-title.top_tab li").each(function () {
            if ($(this).find("cite").text() == title) {
                tabIndex = 1;
                return false;
            }
        })
        return tabIndex;
    }

    //右侧内容tab操作
    var tabIdIndex = 0;
    Tab.prototype.tabAdd = function (_this) {
        var that = this;
        var openTabNum = that.tabConfig.openTabNum;
        tabFilter = that.tabConfig.tabFilter;

        if (_this.attr("target")) {

            //创建一个a标签然后js执行点击跳转
            var aElemant = document.createElement('a');
            aElemant.href = _this.attr("data-url");
            aElemant.target = _this.attr("target");
            aElemant.style.display = 'none';
            aElemant.onclick = function (event) { event.stopPropagation(); }
            document.body.appendChild(aElemant);
            //document.querySelector("body").appendChild(aElemant);
            aElemant.click();
            //document.querySelector("body").removeChild(aElemant);
            document.body.removeChild(aElemant);

        } else if (_this.attr("data-url") != undefined) {
            var title = '';
            if (_this.find("i.iconfont,i.layui-icon").attr("data-icon") != undefined) {
                if (_this.find("i.iconfont").attr("data-icon") != undefined) {
                    title += '<i class="iconfont ' + _this.find("i.iconfont").attr("data-icon") + '"></i>';
                } else {
                    var layuiIconStr = _this.find("i.layui-icon").attr("data-icon");
                    if (layuiIconStr && (layuiIconStr.length > 3) && (layuiIconStr.indexOf('&') === -1)) {
                        title += '<i class="layui-icon ' + layuiIconStr + '"></i>';
                    } else {
                        title += '<i class="layui-icon">' + layuiIconStr + '</i>';
                    }
                }
            } else {
                title += '<i class="layui-icon"></i>';
            }
            //已打开的窗口中不存在
            if (that.hasTab(_this.find("cite").text()) == -1 && _this.siblings("dl.layui-nav-child").length == 0) {
                if ($(".layui-tab-title.top_tab li").length == openTabNum) {
                    layer.msg('只能同时打开' + openTabNum + '个选项卡哦。不然系统会卡的！');
                    return;
                }
                tabIdIndex++;
                title += '<cite>' + _this.find("cite").text() + '</cite>';
                title += '<i class="layui-icon layui-unselect layui-tab-close" data-id="' + tabIdIndex + '">&#x1006;</i>';

                var getTimeNew = (new Date().getTime());

                element.tabAdd(tabFilter, {
                    title: title,
                    content: "<iframe id='laftMenu" + getTimeNew + "' frameborder='0' src='" + _this.attr("data-url") + "' data-id='" + tabIdIndex + "' style='padding: 0px; margin: 0px; border-width: 0px;' ></frame>",
                    id: getTimeNew
                })
                //当前窗口内容
                var curmenu = {
                    "icon": (_this.find("i.iconfont").attr("data-icon") != undefined) ? (_this.find("i.iconfont").attr("data-icon")) : (_this.find("i.layui-icon").attr("data-icon")),
                    "title": _this.find("cite").text(),
                    "href": _this.attr("data-url"),
                    "layId": getTimeNew
                }
                element.tabChange(tabFilter, that.getLayId(_this.find("cite").text()));
                that.tabMove(); //顶部窗口是否可滚动

                //刷新iframe
                var __thisIframe = document.getElementById("laftMenu" + getTimeNew);
                __thisIframe.src = __thisIframe.src;
                // __thisIframe.contentWindow.location.reload(true);
            } else {
                element.tabChange(tabFilter, that.getLayId(_this.find("cite").text()));
                //刷新当前窗口
                $(".refresh")[0].click();
                that.tabMove(); //顶部窗口是否可滚动
            }
        }
    }

    //监听切换tab设置当前选中tab
    Tab.prototype.monitorSwitchTab = function (htmlElement) {
        tabFilter = this.tabConfig.tabFilter;
        element.tabChange(tabFilter, $(htmlElement).attr("lay-id")).init();
    }

    //关闭tab监听
    Tab.prototype.monitorCloseTab = function (htmlElement) {
        tabFilter = this.tabConfig.tabFilter;

        element.tabDelete(tabFilter, $(htmlElement).parent("li").attr("lay-id")).init();
        this.tabMove();
    }

    //关闭其他tab
    Tab.prototype.CloseOtherTab = function () {
        tabFilter = this.tabConfig.tabFilter;

        if ($("#top_tabs li").length > 2 && $("#top_tabs li.layui-this cite").text() != "主页") {
            $("#top_tabs li").each(function () {
                if ($(this).attr("lay-id") != '' && !$(this).hasClass("layui-this")) {
                    element.tabDelete(tabFilter, $(this).attr("lay-id")).init();
                }
            });
        } else if ($("#top_tabs li.layui-this cite").text() == "主页" && $("#top_tabs li").length > 1) {
            $("#top_tabs li").each(function () {
                if ($(this).attr("lay-id") != '' && !$(this).hasClass("layui-this")) {
                    element.tabDelete(tabFilter, $(this).attr("lay-id")).init();
                    return false;
                }
            });
        } else {
            layer.msg("没有可以关闭的窗口了@_@");
        }
        //渲染顶部窗口
        this.tabMove();
    }

    //关闭全部tab
    Tab.prototype.CloseAllTab = function () {
        tabFilter = this.tabConfig.tabFilter;

        if ($("#top_tabs li").length > 1) {
            $("#top_tabs li").each(function () {
                if ($(this).attr("lay-id") != '') {
                    element.tabDelete(tabFilter, $(this).attr("lay-id")).init();
                }
            });
        } else {
            layer.msg("没有可以关闭的窗口了@_@");
        }
        //渲染顶部窗口
        this.tabMove();
    }

    //顶部窗口移动
    Tab.prototype.tabMove = function () {
        $(window).on("resize", function () {
            var topTabsBox = $("#top_tabs_box"),
                topTabsBoxWidth = $("#top_tabs_box").width(),
                topTabs = $("#top_tabs"),
                topTabsWidth = $("#top_tabs").width(),
                tabLi = topTabs.find("li.layui-this"),
                top_tabs = document.getElementById("top_tabs");;

            if (topTabsWidth > topTabsBoxWidth) {
                if (tabLi.position().left > topTabsBoxWidth || tabLi.position().left + topTabsBoxWidth > topTabsWidth) {
                    topTabs.css("left", topTabsBoxWidth - topTabsWidth);
                } else {
                    topTabs.css("left", -tabLi.position().left);
                }
                //拖动效果
                var flag = false;
                var cur = {
                    x: 0,
                    y: 0
                }
                var nx, dx, x;
                function down(event) {
                    flag = true;
                    var touch;
                    if (event.touches) {
                        touch = event.touches[0];
                    } else {
                        touch = event;
                    }
                    cur.x = touch.clientX;
                    dx = top_tabs.offsetLeft;
                }
                function move(event) {
                    var self = this;
                    window.getSelection ? window.getSelection().removeAllRanges() : document.selection.empty();
                    if (flag) {
                        var touch;
                        if (event.touches) {
                            touch = event.touches[0];
                        } else {
                            touch = event;
                        }
                        nx = touch.clientX - cur.x;
                        x = dx + nx;
                        if (x > 0) {
                            x = 0;
                        } else {
                            if (x < topTabsBoxWidth - topTabsWidth) {
                                x = topTabsBoxWidth - topTabsWidth;
                            } else {
                                x = dx + nx;
                            }
                        }
                        top_tabs.style.left = x + "px";
                        //阻止页面的滑动默认事件
                        document.addEventListener("touchmove", function (event) {
                            event.preventDefault();
                        }, false);
                    }
                }
                //鼠标释放时候的函数
                function end() {
                    flag = false;
                }
                //pc端拖动效果
                topTabs.on("mousedown", down);
                topTabs.on("mousemove", move);
                $(document).on("mouseup", end);
                //移动端拖动效果
                topTabs.on("touchstart", down);
                topTabs.on("touchmove", move);
                topTabs.on("touchend", end);
            } else {
                //移除pc端拖动效果
                topTabs.off("mousedown", down);
                topTabs.off("mousemove", move);
                topTabs.off("mouseup", end);
                //移除移动端拖动效果
                topTabs.off("touchstart", down);
                topTabs.off("touchmove", move);
                topTabs.off("touchend", end);
                topTabs.removeAttr("style");
                return false;
            }
        }).resize();

    }

    var bodyTab = new Tab();

    //将bodyTab给layui模块化加载
    layui.bodyTab = bodyTab;
    drdrdr('bodyTab', bodyTab);

});//layui.define的结尾