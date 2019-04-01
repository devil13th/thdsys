import React from 'react';
import { connect } from 'dva';
import { Modal, Tabs, Icon, Drawer, Button } from 'antd';
import ${cfg.tableCodeForClass}List from './view/${cfg.tableCodeForClass}List';
import ${cfg.tableCodeForClass}Search from './view/${cfg.tableCodeForClass}Search';
import ${cfg.tableCodeForClass}Form from './view/${cfg.tableCodeForClass}Form';
import CFG from '../../../constants';

const TabPane = Tabs.TabPane;
const ButtonGroup = Button.Group;

class ${cfg.tableCodeForClass}Router extends React.Component {
    constructor(props) {
        super(props);

        this.state = {
           ${cfg.tableCodeForProperty}FormVisible: false
        }
    }

    componentDidMount() {
        //查询列表
        this.props.dispatch({
            type: "${cfg.tableCodeForProperty}Model/queryList"
        });

        //查询字典分类下拉菜单数据
        this.props.dispatch({
            type: "${cfg.tableCodeForProperty}Model/queryDicClassify"
        });
    }


    //分页,排序,筛选改变时触发
    changePageAndSort = (pagination, filters, sorter) => {
        this.props.dispatch({
            type: "${cfg.tableCodeForProperty}Model/setPageAndSort",
            payload: {
                current: pagination.current,
                pageSize: pagination.pageSize,
                sortColumn: sorter.field,
                sortOrder: sorter.order
            }
        })
    }

    //打开编辑窗口
    open${cfg.tableCodeForClass}Form = () => {
        this.props.dispatch({
            type: "${cfg.tableCodeForProperty}Model/mergeState",
            payload: {
                ${cfg.tableCodeForProperty}FormVisible: true,
                entity: {},
                operateType: CFG.OPERATETYPE.SAVE
            }
        })
    }

    //关闭编辑窗口
    close${cfg.tableCodeForClass}Form = () => {
        this.props.dispatch({
            type: "${cfg.tableCodeForProperty}Model/mergeState",
            payload: {
                ${cfg.tableCodeForProperty}FormVisible: false
            }
        })
    }

    //保存${cfg.tableName}
    save${cfg.tableCodeForClass}Form = (obj) => {
        this.props.dispatch({
            type: "${cfg.tableCodeForProperty}Model/save${cfg.tableCodeForClass}",
            payload: obj
        })
    }

    //删除单条记录 - ${cfg.tableName}
    delete${cfg.tableCodeForClass} = (id) => {
        this.props.dispatch({
            type: "${cfg.tableCodeForProperty}Model/delete${cfg.tableCodeForClass}",
            payload: id
        })
    }

    //删除多条记录 - ${cfg.tableName}
    delete${cfg.tableCodeForClass}Batch = (id) => {
        this.props.dispatch({
            type: "${cfg.tableCodeForProperty}Model/delete${cfg.tableCodeForClass}Batch",
            payload: id
        })
    }



    //编辑${cfg.tableName}
    edit${cfg.tableCodeForClass} = (id) => {
        this.props.dispatch({
            type: "${cfg.tableCodeForProperty}Model/edit${cfg.tableCodeForClass}",
            payload: id
        })
    }

    //查询${cfg.tableName}
    search${cfg.tableCodeForClass} = (queryCondition) => {
        this.props.dispatch({
            type: "${cfg.tableCodeForProperty}Model/setQueryCondition",
            payload: { ...queryCondition }
        })
    }
    //勾选/取消勾选列表
    onChangeSelectedRow = (selectedEntityIds) => {
        this.props.dispatch({
            type: "${cfg.tableCodeForProperty}Model/mergeState",
            payload: {
                selectedEntityIds
            }
        })
    }



    render() {


        //dva组件state
        const state = this.props.${cfg.tableCodeForProperty}Model;
        //组件state字符串
        var stateStr = JSON.stringify(state);

        const { current, pageSize, total } = this.props.${cfg.tableCodeForProperty}Model.queryExtraBean;

        //列表查询loading
        const queryListLoading = this.props.loading.effects['${cfg.tableCodeForProperty}Model/queryList']
        ||  this.props.loading.effects['reactCodegenTestModel/edit${cfg.tableCodeForClass}']
        ||  this.props.loading.effects['reactCodegenTestModel/delete${cfg.tableCodeForClass}']
        ||  this.props.loading.effects['reactCodegenTestModel/delete${cfg.tableCodeForClass}Batch'];
        
        //保存实体loading
        const onSaveLoading = this.props.loading.effects['${cfg.tableCodeForProperty}Model/save${cfg.tableCodeForClass}'];
        return (
            <div className="mainContent">

                <${cfg.tableCodeForClass}Search
                    queryCondition={this.props.${cfg.tableCodeForProperty}Model.queryConditionBean}
                    search${cfg.tableCodeForClass}={this.search${cfg.tableCodeForClass}}
                    open${cfg.tableCodeForClass}Form={this.open${cfg.tableCodeForClass}Form}
                    selectedEntityIds={this.props.${cfg.tableCodeForProperty}Model.selectedEntityIds}
                    delete${cfg.tableCodeForClass}Batch={this.delete${cfg.tableCodeForClass}Batch}
                    dicClassifyDataSource={this.props.${cfg.tableCodeForProperty}Model.dicClassifyDataSource}
                    queryListLoading={queryListLoading}
                >
                </${cfg.tableCodeForClass}Search>
                <${cfg.tableCodeForClass}List
                    queryExtraBean={this.props.${cfg.tableCodeForProperty}Model.queryExtraBean}
                    queryListLoading={queryListLoading}
                    changePageAndSort={this.changePageAndSort}
                    pagination={{
                        current, pageSize, total
                    }}
                    listDataSource={this.props.${cfg.tableCodeForProperty}Model.listDataSource}
                    delete${cfg.tableCodeForClass}={this.delete${cfg.tableCodeForClass}}

                    edit${cfg.tableCodeForClass}={this.edit${cfg.tableCodeForClass}}
                    selectedEntityIds={this.props.${cfg.tableCodeForProperty}Model.selectedEntityIds}
                    onChangeSelectedRow={this.onChangeSelectedRow}

                >

                </${cfg.tableCodeForClass}List>

                {/* 
                <Modal
                    title="公共字典信息"
                    visible={this.props.${cfg.tableCodeForProperty}Model.${cfg.tableCodeForProperty}FormVisible}
                    destroyOnClose={true}
                    footer={false}
                    onCancel={this.close${cfg.tableCodeForClass}Form}
                    maskClosable={false}
                    width={1000}
                >
                    <${cfg.tableCodeForClass}Form
                        entity={this.props.${cfg.tableCodeForProperty}Model.entity}
                        onSave={this.save${cfg.tableCodeForClass}Form}
                        onCancel={this.close${cfg.tableCodeForClass}Form}
                    >
                    </${cfg.tableCodeForClass}Form>
                </Modal>
                */}


                <Drawer
                    title="公共字典信息"
                    placement="right"
                    width={350}
                    destroyOnClose={true}
                    onClose={this.close${cfg.tableCodeForClass}Form}
                    visible={this.props.${cfg.tableCodeForProperty}Model.${cfg.tableCodeForProperty}FormVisible}
                >

                    <${cfg.tableCodeForClass}Form
                        entity={this.props.${cfg.tableCodeForProperty}Model.entity}
                        onSave={this.save${cfg.tableCodeForClass}Form}
                        onCancel={this.close${cfg.tableCodeForClass}Form}
                        onSaveLoading={onSaveLoading}
                    >
                    </${cfg.tableCodeForClass}Form>
                </Drawer>

                {/* <div>{stateStr}</div> */}
            </div>
        )
    }
}


export default connect(({ ${cfg.tableCodeForProperty}Model, loading }) => ({
    ${cfg.tableCodeForProperty}Model,
    loading
}))(${cfg.tableCodeForClass}Router);