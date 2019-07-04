<%@page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html style="background-color:#212121">
<head>
    <script type="text/javascript">
        try {
            if (/Android|webOS|iPhone|iPod|BlackBerry/i.test(navigator.userAgent)) {
                window.location.href = "m/modPas.jsp";
            }
        } catch (e) {
        }
    </script>
    <meta charset="utf-8"/>
    <title>Modify Password</title>
    <link href="../../static/customer/css/bootstrap.min.css" rel="stylesheet">
    <link href="../../static/customer/css/gloab.css" rel="stylesheet">
    <link href="../../static/customer/css/regUsr.css" rel="stylesheet">
    <script src="../../static/customer/js/jquery-1.11.1.min.js" type="text/javascript"></script>
    <script src="../../static/customer/js/register.js" type="text/javascript"></script>
</head>

<body class="bgf4">
<div class="login-box f-mt10 f-pb50" style="background-color:#212121">
    <div class="main bgf" style="background-color:#212121">
        <div class="reg-box-pan display-inline">

            <div class="reg-box" id="verifyCheck" style="margin-top: 20px;">
                <form id="form1" name="form1" method="post">
                    <div class="item col-xs-12">
                        <span class="intelligent-label f-fl" style="color:#fff;"><b class="ftx04">*</b>用户名:</span>
                        <div class="f-fl item-ifo">
                            <input type="text" name="userName" maxlength="20" style="background-color:transparent;"
                                   class="txt03 f-r3 required" tabindex="1"
                                   data-valid="isNonEmpty||between:3-20||isUname"
                                   data-error="The user name cannot be empty||The user name is 3-20 digits long||Only letters, numbers and underscores can be entered and begin with letters"
                                   id="adminNo" value="${user.c_id }"
                                   disabled="disabled"/>
                            <label class="icon-sucessfill blank hide"></label>
                        </div>
                    </div>
                    <div class="item col-xs-12">
                        <span class="intelligent-label f-fl" style="color:#fff;"><b class="ftx04">*</b>原密码:</span>
                        <div class="f-fl item-ifo">
                            <input type="password" name="oldPswd" id="oldPswd"
                                   maxlength="20" class="txt03 f-r3 required" tabindex="2"
                                   style="ime-mode: disabled;background-color:transparent;" onpaste="return  false"
                                   autocomplete="off" data-valid="isNonEmpty||between:6-20"
                                   data-error="密码不能为空||密码长度在6到20位"/>

                            <label class="icon-sucessfill blank hide"></label>
                            <label class="focus valid"></label>
                            <span class="clearfix"></span>
                        </div>
                    </div>
                    <div class="item col-xs-12">
                        <span class="intelligent-label f-fl" style="color:#fff;"><b class="ftx04">*</b>新密码:</span>
                        <div class="f-fl item-ifo">
                            <input type="password" name="newPswd" id="password"
                                   maxlength="20" class="txt03 f-r3 required" tabindex="3"
                                   style="ime-mode: disabled;background-color:transparent;" onpaste="return  false"
                                   autocomplete="off"
                                   data-valid="isNonEmpty||between:6-16||level:2"
                                   data-error="密码不能为空||密码长度在6到16位||密码太简单"/>

                            <label
                                    class="icon-sucessfill blank hide"></label> <label
                                class="focus">6-16位英语(区分大小写)、数字和字符组合</label> <label
                                class="focus valid"></label> <span class="clearfix"></span> <label
                                class="strength"> <span class="f-fl f-size12">安全性:</span>
                            <b><i>弱</i><i>中</i><i>强</i></b>
                        </label>
                        </div>
                    </div>
                    <div class="item col-xs-12">
                        <span class="intelligent-label f-fl" style="color:#fff;"><b class="ftx04">*</b>确认密码:</span>
                        <div class="f-fl item-ifo">
                            <input type="password" maxlength="20"
                                   class="txt03 f-r3 required" tabindex="4"
                                   style="ime-mode: disabled;background-color:transparent;" onpaste="return  false"
                                   autocomplete="off"
                                   data-valid="isNonEmpty||between:6-16||isRepeat:password"
                                   data-error="密码不能为空||密码长度在6到16位||两次密码不一致"
                                   id="rePassword"/> <span class="ie8 icon-close close hide"
                                                           style="right: 55px"></span> <label
                                class="icon-sucessfill blank hide"></label> <label
                                class="focus">请再输入一边密码</label> <label
                                class="focus valid"></label>
                        </div>
                    </div>
                    <input type="text" id="CustomerID" name="CustomerID"
                           value="${user.c_id }" hidden="ture">
                    <div class="item col-xs-12">
                        <span class="intelligent-label f-fl">&nbsp;</span>
                        <div class="f-fl item-ifo">
                            <a href="javascript:;" class="btn btn-blue f-r3" id="btn_part1">提交</a>
                        </div>
                    </div>
                </form>

            </div>
        </div>
    </div>
</div>
<script>
    $(function () {
        //Apply Button
        $("#btn_part1").click(function () {
            if (!verifyCheck._click())
                return;
            document.forms[0].action = "../ModifyPwdCustomer";
            document.forms[0].submit();
        });
    });
</script>
</body>
</html>
