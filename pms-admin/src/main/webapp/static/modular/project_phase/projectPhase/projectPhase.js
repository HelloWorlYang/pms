/**
 * 项目开发阶段管理初始化
 */
var ProjectPhase = {
    id: "ProjectPhaseTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1
};

/**
 * 初始化表格的列
 */
ProjectPhase.initColumn = function () {
    return [
        {field: 'selectItem', radio: true},
            {title: '序号', field: 'id', visible: true, align: 'center', valign: 'middle'},
            {title: '阶段代码', field: 'phaseCode', visible: true, align: 'center', valign: 'middle'},
            {title: '阶段名称', field: 'phaseName', visible: true, align: 'center', valign: 'middle'},
            {title: '备注', field: 'description', visible: true, align: 'center', valign: 'middle'},
            {title: '记录创建时间', field: 'createtime', visible: true, align: 'center', valign: 'middle'},
            {title: '修改时间', field: 'updatetime', visible: true, align: 'center', valign: 'middle'}
    ];
};

/**
 * 检查是否选中
 */
ProjectPhase.check = function () {
    var selected = $('#' + this.id).bootstrapTable('getSelections');
    if(selected.length == 0){
        Feng.info("请先选中表格中的某一记录！");
        return false;
    }else{
        ProjectPhase.seItem = selected[0];
        return true;
    }
};

/**
 * 点击添加项目开发阶段
 */
ProjectPhase.openAddProjectPhase = function () {
    var index = layer.open({
        type: 2,
        title: '添加项目开发阶段',
        area: ['800px', '420px'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: Feng.ctxPath + '/projectPhase/projectPhase_add'
    });
    this.layerIndex = index;
};

/**
 * 打开查看项目开发阶段详情
 */
ProjectPhase.openProjectPhaseDetail = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: '项目开发阶段详情',
            area: ['800px', '420px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/projectPhase/projectPhase_update/' + ProjectPhase.seItem.id
        });
        this.layerIndex = index;
    }
};

/**
 * 删除项目开发阶段
 */
ProjectPhase.delete = function () {
    if (this.check()) {
        var ajax = new $ax(Feng.ctxPath + "/projectPhase/delete", function (data) {
            Feng.success("删除成功!");
            ProjectPhase.table.refresh();
        }, function (data) {
            Feng.error("删除失败!" + data.responseJSON.message + "!");
        });
        ajax.set("projectPhaseId",this.seItem.id);
        ajax.start();
    }
};

/**
 * 查询项目开发阶段列表
 */
ProjectPhase.search = function () {
    var queryData = {};
    queryData['condition'] = $("#condition").val();
    ProjectPhase.table.refresh({query: queryData});
};

$(function () {
    var defaultColunms = ProjectPhase.initColumn();
    var table = new BSTable(ProjectPhase.id, "/projectPhase/list", defaultColunms);
    table.setPaginationType("client");
    ProjectPhase.table = table.init();
});
