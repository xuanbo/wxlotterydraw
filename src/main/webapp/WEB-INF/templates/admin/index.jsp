<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE HTML>
<html>
<head>
    <meta charset="UTF-8">
    <title>管理员页面</title>
    <script src="/assets/jQuery/jQuery.min.js"></script>
    <script src="/assets/bootstrap/js/bootstrap.min.js"></script>
    <link type="text/css" href="/assets/bootstrap/css/bootstrap.min.css" rel="stylesheet"/>
    <style>
        * {
            margin: 0;
            padding: 0;
            font-family: "Microsoft YaHei", sans-serif;
        }

        html {
            font-size: 625%;
        }

        #head {
            background-color: #6f5499;
            height: .5rem;
            font: .18rem/.5rem "Microsoft YaHei";
            text-align: center;
            color: #fff;
            letter-spacing: .01rem;
        }

        .btn-group > .btn {
            outline: 0 !important;
            padding: 12px 12px !important;
        }

        .table {
            width: 98%;
            margin: .2rem auto;
        }

        .col-xs-6 > .input-group, .col-xs-12 > .input-group {
            width: 90%;
            margin: .10rem auto;
        }

        .col-xs-12 {
            padding-left: 0;
            padding-right: 0;
        }
    </style>
</head>

<body>

<div id="head">
    抽奖后台管理系统
</div>

<div id="content">
    <div class="btn-group btn-group-justified">
        <div class="btn-group">
            <button type="button" class="btn btn-default" data-toggle="modal" data-target=".bs-example-modal-sm">创建抽奖规则
            </button>
        </div>
        <div class="btn-group">
            <a href="/logout" class="btn btn-default">退出登录</a>
        </div>
    </div>
    <div class="col-lg-10 col-lg-offset-1">
        <table class="table table-striped table-responsive text-center">
            <!-- On cells (`td` or `th`) -->
            <tr class="table-head ">
                <th class="text-center">编号</th>
                <th class="text-center">名称</th>
                <th class="text-center">描述</th>
                <th class="text-center">开始时间</th>
                <th class="text-center">结束时间</th>
                <th class="text-center">人数</th>
                <th class="text-center">中奖人数</th>
                <th class="text-center">操作</th>
            </tr>
        </table>
        <div id="loading" class="text-center">正在加载数据 ...</div>
    </div>
</div>
<!-- Modal -->
<div class="modal fade bs-example-modal-sm" tabindex="-1" role="dialog" aria-labelledby="mySmallModalLabel"
     aria-hidden="true">
    <div class="modal-dialog ">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span
                        class="sr-only">Close</span></button>
                <h4 class="modal-title" id="myModalLabel">创建抽奖规则</h4>
            </div>
            <div class="modal-body">
                <div class="row">
                    <div class="col-xs-6">
                        <div class="input-group">
              <span class="input-group-btn">
                <button class="btn btn-primary" type="button">名称:</button>
              </span>
                            <input placeholder="请输入抽奖名称" type="text" class="form-control">
                        </div>
                    </div>
                    <div class="col-xs-6">
                        <div class="input-group">
              <span class="input-group-btn">
                <button class="btn btn-primary" type="button">描述:</button>
              </span>
                            <input placeholder="请输入抽奖描述" type="text" class="form-control">
                        </div>
                    </div>
                    <div class="col-xs-6">
                        <div class="input-group">
              <span class="input-group-btn">
                <button class="btn btn-primary" type="button">人数:</button>
              </span>
                            <input placeholder="请输入抽奖人数" type="number" class="form-control">
                        </div>
                    </div>
                    <div class="col-xs-6">
                        <div class="input-group">
              <span class="input-group-btn">
                <button class="btn btn-primary" type="button">中奖人数:</button>
              </span>
                            <input placeholder="请输入中奖人数" type="number" class="form-control">
                        </div>
                    </div>
                    <div class="col-xs-12">
                        <div class="input-group">
              <span class="input-group-btn">
                <button class="btn btn-primary" type="button">开始时间:</button>
              </span>
                            <input placeholder="请输入开始时间" type="datetime-local" class="form-control">
                        </div>
                    </div>
                    <div class="col-xs-12">
                        <div class="input-group">
              <span class="input-group-btn">
                <button class="btn btn-primary" type="button">结束时间:</button>
              </span>
                            <input placeholder="请输入结束时间" type="datetime-local" class="form-control">
                        </div>
                    </div>
                </div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                <button type="button" class="btn btn-primary">保存</button>
            </div>
        </div>
    </div>
</div>

<script>
    (function ($) {
        $(function () {
            $.get('/rules', function (data) {
                $(data.list).each(function (index, val) {
                    var ele = "<tr><td>";
                    ele += val.id + "</td><td>" + val.name + "</td><td>" + val.description
                            + "</td><td>" + new Date(val.startTime).toLocaleString() + "</td><td>" + new Date(val.endTime).toLocaleString()
                            + "</td><td>" + val.max + "</td><td>" + val.pickerNum + "</td><td><a href='/rule/" + val.id + "/activity' class='btn btn-default btn-sm'>查看</a>";
                    if (!val.isDo) {
                        ele += "<button class='btn btn-sm btn-primary'>抽奖</button>";
                    }
                    ele += "</td></tr>";
                    $(".table").append(ele);
                });
                $('#loading').text("加载完成").fadeOut(1000);
            }, 'json');
        });
    })(jQuery);
</script>

</body>
</html>