/**
 * 初始化员工工时详情对话框
 */
var HoursInfoDlg = {
    hoursInfoData : {},
    validateFields: {
        pid: {
            validators: {
                notEmpty: {
                    message: '项目ID不能为空'
                }
            }
        },
        hid: {
            validators: {
                notEmpty: {
                    message:  '阶段ID不能为空'
                }
            }
        },
        uid: {
            validators: {
                notEmpty: {
                    message: '员工不能为空'
                }
            }
        },
        hours: {
            validators: {
                notEmpty: {
                    message: '工时不能为空'
                }
            }
        }
    }
};

/**
 * 清除数据
 */
HoursInfoDlg.clearData = function() {
    this.hoursInfoData = {};
};

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
HoursInfoDlg.set = function(key, val) {
    this.hoursInfoData[key] = (typeof val == "undefined") ? $("#" + key).val() : val;
    return this;
};

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
HoursInfoDlg.get = function(key) {
    return $("#" + key).val();
};

/**
 * 关闭此对话框
 */
HoursInfoDlg.close = function() {
    parent.layer.close(window.parent.Hours.layerIndex);
};

/**
 * 收集数据
 */
HoursInfoDlg.collectData = function() {
    this
    .set('id')
    .set('pid')
    .set('hid')
    .set('uid')
    .set('hours')
    .set('comment')
    .set('createtime')
    .set('updatetime');
};

/**
 * 提交添加
 */
HoursInfoDlg.addSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/hours/add", function(data){
        Feng.success("添加成功!");
        window.parent.Hours.table.refresh();
        HoursInfoDlg.close();
    },function(data){
        Feng.error("添加失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.hoursInfoData);
    ajax.start();
};

/**
 * 提交修改
 */
HoursInfoDlg.editSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/hours/update", function(data){
        Feng.success("修改成功!");
        window.parent.Hours.table.refresh();
        HoursInfoDlg.close();
    },function(data){
        Feng.error("修改失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.hoursInfoData);
    ajax.start();
};

/**
 * 点击项目input框时
 *
 * @param e
 * @param treeId
 * @param treeNode
 * @returns
 */
HoursInfoDlg.onClickProject = function (e, treeId, treeNode) {
    $("#pidSel").attr("value", instance.getSelectedVal());
    $("#pid").attr("value", treeNode.id);
};

/**
 * 显示项目选择的树
 *
 * @returns
 */
HoursInfoDlg.showProjectSelectTree = function () {
    var pidObj = $("#pidSel");
    var pidOffset = $("#pidSel").offset();
    $("#menuContent").css({
        left: pidOffset.left + "px",
        top: pidOffset.top + pidObj.outerHeight() + "px"
    }).slideDown("fast");

    $("body").bind("mousedown", onBodyDown);
};

/**
 * 显示用户详情项目选择的树
 *
 * @returns
 */
HoursInfoDlg.showInfoProjectSelectTree = function () {
    var pidObj = $("#pidObj");
    var pidPosition = $("#pidObj").position();
    $("#menuContent").css({
        left: pidPosition.left + "px",
        top: pidPosition.top + pidObj.outerHeight() + "px"
    }).slideDown("fast");

    $("body").bind("mousedown", onBodyDown);
};

/**
 * 隐藏项目选择的树
 */
HoursInfoDlg.hideProjectSelectTree = function () {
    $("#menuContent").fadeOut("fast");
    $("body").unbind("mousedown", onBodyDown);// mousedown当鼠标按下就可以触发，不用弹起
};

/**
 * 点击阶段ztree列表的选项时
 *
 * @param e
 * @param treeId
 * @param treeNode
 * @returns
 */
HoursInfoDlg.onClickPhase = function(e, treeId, treeNode) {
    $("#hid").attr("value", HoursInfoDlg.zTreeInstance.getSelectedVal());
    $("#phaseid").attr("value", treeNode.id);
}

/**
 * 显示阶段选择的树
 *
 * @returns
 */
HoursInfoDlg.showPhaseSelectTree = function() {
    var hId = $("#hid");
    var hIdOffset = $("#hid").offset();
    $("#PhaseMenu").css({
        left : hIdOffset.left + "px",
        top : hIdOffset.top + hId.outerHeight() + "px"
    }).slideDown("fast");

    $("body").bind("mousedown", onBodyDown);
}

/**
 * 隐藏阶段选择的树
 */
HoursInfoDlg.hidePhaseSelectTree = function() {
    $("#PhaseMenu").fadeOut("fast");
    $("body").unbind("mousedown", onBodyDown2);// mousedown当鼠标按下就可以触发，不用弹起
}

function onBodyDown2(event) {
    if (!(event.target.id == "menuBtn" || event.target.id == "menuContent" || $(
        event.target).parents("#PhaseMenu").length > 0)) {
        HoursInfoDlg.hidePhaseSelectTree();
    }
}

function onBodyDown(event) {
    if (!(event.target.id == "menuBtn" || event.target.id == "menuContent" || $(
        event.target).parents("#menuContent").length > 0)) {
        HoursInfoDlg.hideProjectSelectTree();
    }
}

$(function() {
    Feng.initValidator("hoursInfoForm", HoursInfoDlg.validateFields);

    var ztree_project = new $ZTree("treeDemo", "/project/tree");
    ztree_project.bindOnClick(HoursInfoDlg.onClickProject);
    ztree_project.init();
    HoursInfoDlg.instance = ztree_project;

    var ztree_phase = new $ZTree("phaseMenuTree", "/projectPhase/tree");
    ztree_phase.bindOnClick(HoursInfoDlg.onClickPhase);
    ztree_phase.init();
    HoursInfoDlg.zTreeInstance = ztree_phase;

});
