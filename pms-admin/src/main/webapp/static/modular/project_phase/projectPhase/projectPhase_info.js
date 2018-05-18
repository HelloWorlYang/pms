/**
 * 初始化项目开发阶段详情对话框
 */
var ProjectPhaseInfoDlg = {
    projectPhaseInfoData : {}
};

/**
 * 清除数据
 */
ProjectPhaseInfoDlg.clearData = function() {
    this.projectPhaseInfoData = {};
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
ProjectPhaseInfoDlg.set = function(key, val) {
    this.projectPhaseInfoData[key] = (typeof val == "undefined") ? $("#" + key).val() : val;
    return this;
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
ProjectPhaseInfoDlg.get = function(key) {
    return $("#" + key).val();
}

/**
 * 关闭此对话框
 */
ProjectPhaseInfoDlg.close = function() {
    parent.layer.close(window.parent.ProjectPhase.layerIndex);
}

/**
 * 收集数据
 */
ProjectPhaseInfoDlg.collectData = function() {
    this
    .set('id')
    .set('phaseCode')
    .set('phaseName')
    .set('description')
    .set('createtime')
    .set('updatetime');
}

/**
 * 提交添加
 */
ProjectPhaseInfoDlg.addSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/projectPhase/add", function(data){
        Feng.success("添加成功!");
        window.parent.ProjectPhase.table.refresh();
        ProjectPhaseInfoDlg.close();
    },function(data){
        Feng.error("添加失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.projectPhaseInfoData);
    ajax.start();
}

/**
 * 提交修改
 */
ProjectPhaseInfoDlg.editSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/projectPhase/update", function(data){
        Feng.success("修改成功!");
        window.parent.ProjectPhase.table.refresh();
        ProjectPhaseInfoDlg.close();
    },function(data){
        Feng.error("修改失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.projectPhaseInfoData);
    ajax.start();
}

$(function() {

});
