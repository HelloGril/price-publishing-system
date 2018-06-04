var cooperativesDict;
var plantingZoneDict;
var isSolvedDict;
$.ajax({
    type: "get",
    url: base + "/dict/isSolved",
    cache: true,
    async: false,
    dataType: "json",
    success: function (obj) {
        isSolvedDict = obj;
    }
});

$.ajax({
    type: "get",
    url: base + "/cooperatives/dict",
    cache: true,
    async: false,
    dataType: "json",
    success: function (obj) {
        cooperativesDict = obj;
    }
});

$.ajax({
    type: "get",
    url: base + "/plantingZone/dict",
    cache: true,
    async: false,
    dataType: "json",
    success: function (obj) {
        plantingZoneDict = obj;
    }
});

$('#environmentMonitorGrid').datagrid({
    url: base + '/environmentMonitor/page',
    pagePosition: 'bottom',
    pagination: true,
    singleSelect: true,
    fitColumns: true,
    toolbar: '#environmentMonitorGridToolBar',
    idField: "id",
    loadMsg: "正在努力为您加载数据",
    fit: true,
    rownumbers: true,
    nowrap: true,
    columns: [[
        {
            field: 'cooperativesId', title: '合作社ID', align: 'center', sortable: true,
            formatter: function (value, row, index) {
                return dictValue(cooperativesDict, 'code', 'name', value)
            }
        },
        {
            field: 'plantingZoneId', title: '种植区ID', align: 'center', sortable: true,
            formatter: function (value, row, index) {
                return dictValue(plantingZoneDict, 'code', 'name', value)
            }
        },
        {field: 'unusualMessage', title: '异常信息', align: 'center', sortable: true},
        {
            field: 'isSolved', title: '是否解决', align: 'center', sortable: true,
            formatter: function (value, row, index) {
                return dictValue(isSolvedDict, 'code', 'name', value)
            }
        }
    ]]
});

function doSearch() {
    var param = {};
    generateCondition(param, $('#queryForm').serialize());
    $("#environmentMonitorGrid").datagrid('load', param);
}

function openUpdateEnvironmentMonitorWin() {
    var row = $('#environmentMonitorGrid').datagrid('getSelected');
    if (row) {
        $('#updateEnvironmentMonitorForm').form('reset');
        $('#environmentMonitorUpdateWin').window('open');
        $('#updateEnvironmentMonitorForm').form('load', row);
    } else {
        pop('提示', "请选择要修改的数据！");
    }
}

function closeUpdateEnvironmentMonitorWin() {
    $('#environmentMonitorUpdateWin').window('close');
}

function updateEnvironmentMonitor() {
    if ($('#updateEnvironmentMonitorForm').form('validate')) {
        $.ajax({
            type: "POST",
            url: base + "/environmentMonitor/update",
            data: $('#updateEnvironmentMonitorForm').serialize(),
            dataType: 'json',
            success: function (obj) {
                if (obj.success) {
                    $('#environmentMonitorUpdateWin').window('close');
                    updateRowInGrid('environmentMonitorGrid', obj.data);
                    pop('温馨提示', '保存成功');
                }
                else {
                    pop('保存提示', obj.msg);
                }
            }
        });
    }
}

function openSaveEnvironmentMonitorWin() {
    $('#saveEnvironmentMonitorForm').form('reset');
    $('#environmentMonitorSaveWin').window('open');
}

function saveEnvironmentMonitor() {
    if ($('#saveEnvironmentMonitorForm').form('validate')) {
        $.ajax({
            type: "POST",
            url: base + "/environmentMonitor/add",
            data: $('#saveEnvironmentMonitorForm').serialize(),
            dataType: 'json',
            success: function (obj) {
                if (obj.success) {
                    $('#environmentMonitorSaveWin').window('close');
                    insertRowToGrid('environmentMonitorGrid', obj.data);
                    pop('温馨提示', '保存成功');
                }
                else {
                    pop('保存提示', obj.msg);
                }
            }
        });
    }
}

function deleteEnvironmentMonitor() {
    var row = $('#environmentMonitorGrid').datagrid('getSelected');
    if (row) {
        $.messager.confirm('提示信息', '确定删除?', function (r) {
            if (r) {
                $.ajax({
                    type: "POST",
                    url: base + "/environmentMonitor/delete?id=" + row.id,
                    success: function (obj) {
                        if (obj.success) {
                            deleteSelectedRow('environmentMonitorGrid');
                            pop('温馨提示', '删除成功');
                        }
                        else {
                            pop('删除提示', obj.msg);
                        }
                    }
                });
            }
        });
    } else {
        pop('删除提示', "请选择要删除的数据！");
    }
}

function closeSaveEnvironmentMonitorWin() {
    $('#environmentMonitorSaveWin').window('close');
}


$('.cooperativesId').combobox({
    url: base + '/cooperatives/dict',
    valueField: 'code',
    textField: 'name',
    onSelect: function (rec) {
        $('.plantingZoneId').combobox('clear');
        var url = base + '/plantingZone/dict?cooperativesId=' + rec.code;
        $('.plantingZoneId').combobox('reload', url);
    },
    onShowPanel: function () {
        $(this).combobox('reload')
    }
});

$('.plantingZoneId').combobox({
    valueField: 'code',
    textField: 'name',
    onShowPanel: function () {
        $(this).combobox('reload')
    }
});