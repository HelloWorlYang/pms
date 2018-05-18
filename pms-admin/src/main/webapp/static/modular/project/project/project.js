/**
 * 项目信息管理初始化
 */
var Project = {
    id: "ProjectTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1
};

/**
 * 初始化表格的列
 */
Project.initColumn = function () {
    return [
        {field: 'selectItem', radio: true},
            {title: '序号', field: 'id', visible: true, align: 'center', valign: 'middle'},
            {title: '项目名称', field: 'projectName', visible: true, align: 'center', valign: 'middle'},
            {title: '项目代码', field: 'projectCode', visible: true, align: 'center', valign: 'middle'},
            {title: '预估人天', field: 'manday', visible: true, align: 'center', valign: 'middle'},
            {title: '预估小时', field: 'manhour', visible: true, align: 'center', valign: 'middle'},
            {title: '开始日期', field: 'startDate', visible: true, align: 'center', valign: 'middle'},
            {title: '结束日期', field: 'endDate', visible: true, align: 'center', valign: 'middle'},
            {title: '项目是否有阶段', field: 'hasPhase', visible: true, align: 'center', valign: 'middle'},
            {title: '描述', field: 'description', visible: true, align: 'center', valign: 'middle'},
            {title: '记录创建时间', field: 'createtime', visible: true, align: 'center', valign: 'middle'},
            {title: '记录更新时间', field: 'updatetime', visible: true, align: 'center', valign: 'middle'}
    ];
};

/**
 * 检查是否选中
 */
Project.check = function () {
    var selected = $('#' + this.id).bootstrapTable('getSelections');
    if(selected.length == 0){
        Feng.info("请先选中表格中的某一记录！");
        return false;
    }else{
        Project.seItem = selected[0];
        return true;
    }
};

/**
 * 点击添加项目信息
 */
Project.openAddProject = function () {
    var index = layer.open({
        type: 2,
        title: '添加项目信息',
        area: ['800px', '420px'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: Feng.ctxPath + '/project/project_add'
    });
    this.layerIndex = index;
};

/**
 * 打开查看项目信息详情
 */
Project.openProjectDetail = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: '项目信息详情',
            area: ['800px', '420px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/project/project_update/' + Project.seItem.id
        });
        this.layerIndex = index;
    }
};

/**
 * 删除项目信息
 */
Project.delete = function () {
    if (this.check()) {
        var ajax = new $ax(Feng.ctxPath + "/project/delete", function (data) {
            Feng.success("删除成功!");
            Project.table.refresh();
        }, function (data) {
            Feng.error("删除失败!" + data.responseJSON.message + "!");
        });
        ajax.set("projectId",this.seItem.id);
        ajax.start();
    }
};

/**
 * 查询项目信息列表
 */
Project.search = function () {
    var queryData = {};
    queryData['condition'] = $("#condition").val();
    Project.table.refresh({query: queryData});
};

$(function () {
    var defaultColunms = Project.initColumn();
    var table = new BSTable(Project.id, "/project/list", defaultColunms);
    table.setPaginationType("client");
    Project.table = table.init();
});
