<%--
  Created by IntelliJ IDEA.
  User: chimeralala
  Date: 2018/6/4
  Time: 21:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>设置中心</title>
</head>

<link rel="stylesheet" type="text/css" href="<%=basePath%>css/bootstrap.css" />
<link rel="stylesheet" type="text/css" href="//img-cdn-qiniu.dcloud.net.cn/static/css/font-awesome.css" />
<link rel="stylesheet" type="text/css" href="//img-cdn-qiniu.dcloud.net.cn/static/css/aw-font.css" />

<link href="<%=basePath%>css/common.css" rel="stylesheet" type="text/css" />
<link href="<%=basePath%>css/stylebankuai.css" rel="stylesheet" type="text/css" />
<link href="<%=basePath%>css/classblack.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" href="<%=basePath%>css/user.css" />
<link rel="stylesheet" href="<%=basePath%>css/user-setting.css" />

<script src="//img-cdn-qiniu.dcloud.net.cn/static/js/jquery.2.js?v=20171108" type="text/javascript"></script>
<script src="//img-cdn-qiniu.dcloud.net.cn/static/js/jquery.form.js?v=20171108" type="text/javascript"></script>
<script src="//img-cdn-qiniu.dcloud.net.cn/static/js/plug_module/plug-in_module.js?v=20171108" type="text/javascript"></script>
<script src="//img-cdn-qiniu.dcloud.net.cn/static/js/functions.js?v=20171108" type="text/javascript"></script>

<script src="//img-cdn-qiniu.dcloud.net.cn/static/js/common.js?v=20171108" type="text/javascript"></script>

<script type="text/javascript" src="//img-cdn-qiniu.dcloud.net.cn/static/js/compatibility.js"></script>

</head>
<style type="text/css">
    .sponsor .sponsor-level {
        width: 13px;
        height: 13px;
        position: absolute;
        left: 45px;
        top: 9px;
        margin-left: 0;
    }

    .sponsor .sponsor-count {
        width: 8px;
        height: 8px;
        position: absolute;
        left: 48px;
        top: 11px;
        margin-left: 0;
    }
</style>
<style>
    .ad-item {
        position: relative;
    }

    .ad-item .close {
        position: absolute;
        width: 18px;
        height: 18px;
        background-color: #000000;
        opacity: 0.5;
        text-align: center;
        right: 0px;
        top: 0px;
        line-height: 18px;
        display: none;
    }

    .ad-item .close a {
        font-size: 14px;
        color: #FFFFFF;
        text-decoration: none;
    }

    .ad-item .guide {
        display: none;
    }

    .ad-item:hover .close {
        display: block;
    }
</style>

<body>
    <div class="aw-top-menu-wrap">
        <div class="aw-wecenter aw-top-menu clearfix">
            <div class="container">
            <!-- logo -->
            <div class="aw-logo hidden-xs">
                <img src="<%=basePath%>images/LOGO.png" style="width: 72px; height: 41px;" />
            </div>
            <!-- end logo -->
            <!-- 搜索框 -->
            <div class="aw-search-box  hidden-xs hidden-sm">
                <form class="navbar-search pull-right" action="#" id="global_search_form" method="post">
                    <div class="input-group">
                        <input value="" class="form-control" type="text" placeholder="搜索问题、话题" autocomplete="off" name="q" id="aw-search-query" class="search-query" />
                        <span class="input-group-addon" title="搜索" id="global_search_btns" onClick="$('#global_search_form').submit();"><i class="fa fa-search"></i></span>
                        <div class="clearfix"></div>

                    </div>
                </form>
            </div>
            <!-- end 搜索框 -->
            <!-- 导航 -->
            <div class="aw-top-nav navbar">
                <div class="navbar-header">
                    <button class="navbar-toggle pull-left">
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                </div>
                <nav role="navigation" class="collapse navbar-collapse bs-navbar-collapse">
                    <ul class="nav navbar-nav">

                        <li class="nav-current" role="presentation">
                            <a href="luntanshouyetest.html">美论首页</a>
                        </li>
                        <li>
                            <a href="index.html">美乎</a>
                        </li>
                        <li>
                            <a href="#">美购</a>
                        </li>
                        <li>
                            <a href="#">美商城</a>
                        </li>
                        <li>
                            <a href="#">活动</a>
                        </li>

                        <li>
                            <a href="#">关于</a>
                        </li>

                    </ul>
                </nav>

            </div>
            <!-- end 导航 -->
            <!-- 用户栏 -->
            <div class="aw-user-nav">
                <!-- 登陆&注册栏 -->
                <span>
							<a href="#" ><img src="<%=basePath%>images/${user.headpic}"/>欢迎您：${user.uname}</a>
                    <!--<a href="#">注册</a>
                    <a href="#">登录</a>-->
						</span>

                <!-- end 登陆&注册栏 -->
            </div>
            <!-- end 用户栏 -->
            <!-- 发起 -->
            <!-- end 发起 -->
        </div>
        </div>
    </div>

    <div class="aw-container-wrap">
        <div class="container">
            <div class="row">
                <div class="aw-content-wrap clearfix">
                    <div class="aw-user-setting">
                        <div class="tabbable">
                            <ul class="nav nav-tabs aw-nav-tabs active">
                                <li class="active"><a href="#">基本资料</a></li>
                            </ul>
                        </div>

                        <div class="tab-content clearfix">
                            <!-- 基本信息 -->
                            <form action="" method="post">
                                <div class="aw-mod">
                                    <div class="mod-body">
                                        <div class="aw-mod mod-base">
                                            <div class="mod-head">
                                                <h3>基本信息</h3>
                                            </div>
                                            <form id="setting_form" method="post" action="http://wenda.wecenter.com/account/ajax/profile_setting/">
                                                <div class="mod-body">
                                                    <dl>
                                                        <dt>用户名:</dt>
                                                        <dd><input type="text" placeholder="${user.uname}"/></dd>
                                                    </dl>
                                                    <dl>
                                                        <dt>性别:</dt>
                                                        <dd>
                                                            <label>

                                                                <input name="sex" id="sex1" value="1" type="radio"<c:if test="${user.sex=='男'}">checked</c:if> /> 男						</label>
                                                            <label>
                                                                <input name="sex" id="sex2" value="2" type="radio" <c:if test="${user.sex=='女'}">checked="checked"</c:if> /> 女						</label>

                                                        </dd>
                                                    </dl>
                                                    <dl>
                                                        <dt>电话:</dt>
                                                        <dd><input type="text" placeholder="${user.tel}"/></dd>
                                                    </dl>
                                                    <dl>
                                                        <dt>邮箱:</dt>
                                                        <dd><input type="text" placeholder="${user.email}"/></dd>
                                                    </dl>
                                                    <dl>
                                                        <dt>注册时间:</dt>
                                                        <dd><input type="date"/></dd>
                                                    </dl>
                                                    <!-- 上传头像 -->
                                                    <div class="side-bar">
                                                        <dl>
                                                            <dt class="pull-left"><img class="aw-border-radius-5" src="<%=basePath%>images/${user.headpic}" alt="" id="avatar_src" /></dt>
                                                            <dd class="pull-left">
                                                                <h5>头像设置</h5>
                                                                <p>支持 jpg、gif、png 等格式的图片</p>
                                                                <a class="btn btn-mini btn-success" id="avatar_uploader" href="javascript:;">上传头像</a> <span id="avatar_uploading_status" class="collapse"><i class="aw-loading"></i> 文件上传中...</span>
                                                            </dd>
                                                        </dl>
                                                    </div>
                                                    <!-- end 上传头像 -->
                                                </div>
                                            <div class="mod-footer clearfix">
                                            <input type="submit"  class="btn btn-large btn-success pull-right" value="保存"></input>
                                        </div>
                                            </form>
                                        </div>
                                    </div>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
</html>