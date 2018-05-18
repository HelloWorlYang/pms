/**
 * 员工工时管理初始化
 */
var Hours = {
    id: "HoursTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1,
    projectid:0
};

/**
 * 初始化表格的列
 */
Hours.initColumn = function () {
    return [
        {field: 'selectItem', radio: true},
            {title: '序号', field: 'id', visible: false, align: 'center', valign: 'middle'},
            {title: '项目ID', field: 'pid', visible: true, align: 'center', valign: 'middle'},
            {title: '阶段ID', field: 'hid', visible: true, align: 'center', valign: 'middle'},
            {title: '人员ID', field: 'uid', visible: true, align: 'center', valign: 'middle'},
            {title: '小时', field: 'hours', visible: true, align: 'center', valign: 'middle'},
            {title: '工时备注', field: 'comment', visible: true, align: 'center', valign: 'middle'},
            {title: '记录创建时间', field: 'createtime', visible: true, align: 'center', valign: 'middle'},
            {title: '记录修改时间', field: 'updatetime', visible: true, align: 'center', valign: 'middle'}
    ];
};

/**
 * 检查是否选中
 */
Hours.check = function () {
    var selected = $('#' + this.id).bootstrapTable('getSelections');
    if(selected.length == 0){
        Feng.info("请先选中表格中的某一记录！");
        return false;
    }else{
        Hours.seItem = selected[0];
        return true;
    }
};

/**
 * 点击添加员工工时
 */
Hours.openAddHours = function () {
    var index = layer.open({
        type: 2,
        title: '添加员工工时',
        area: ['800px', '420px'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: Feng.ctxPath + '/hours/hours_add'
    });
    this.layerIndex = index;
};

/**
 * 打开查看员工工时详情
 */
Hours.openHoursDetail = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: '员工工时详情',
            area: ['800px', '420px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/hours/hours_update/' + Hours.seItem.id
        });
        this.layerIndex = index;
    }
};

/**
 * 删除员工工时
 */
Hours.delete = function () {
    if (this.check()) {
        var ajax = new $ax(Feng.ctxPath + "/hours/delete", function (data) {
            Feng.success("删除成功!");
            Hours.table.refresh();
        }, function (data) {
            Feng.error("删除失败!" + data.responseJSON.message + "!");
        });
        ajax.set("hoursId",this.seItem.id);
        ajax.start();
    }
};

/**
 * 查询员工工时列表
 */
Hours.search = function () {
    var queryData = {};
    queryData['condition'] = $("#condition").val();
    Hours.table.refresh({query: queryData});
};

Hours.onClickProject = function (e, treeId, treeNode) {
    Hours.projectid = treeNode.id;
    Hours.search();
};

Hours.onClickProjectPhase = function (e, treeId, treeNode) {
    Hours.projectid = treeNode.id;
    Hours.search();
};

$(function () {
    var defaultColunms = Hours.initColumn();
    var table = new BSTable(Hours.id, "/hours/list", defaultColunms);
    table.setPaginationType("client");
    Hours.table = table.init();

    var ztree = new $ZTree("projectTree", "/project/tree");
    ztree.bindOnClick(Hours.onClickProject);
    ztree.init();

    var ztreePhase = new $ZTree("project_phase_Tree", "/projectPhase/tree");
    ztreePhase.bindOnClick(Hours.onClickProjectPhase);
    ztreePhase.init();
});
