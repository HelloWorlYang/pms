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

$(function() {
    Feng.initValidator("hoursInfoForm", HoursInfoDlg.validateFields);
});
