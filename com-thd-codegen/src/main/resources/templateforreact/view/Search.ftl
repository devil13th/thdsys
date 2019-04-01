import React from 'react';
import { Form,DatePicker,InputNumber, Row, Col, Button, Input, Select, Tooltip, Popover, Popconfirm, Icon } from 'antd';
import MyRpcSelect from '../../../../components/custom/MyRpcSelect';
const ButtonGroup = Button.Group;
const Option = Select.Option;
const InputGroup = Input.Group;
class ${cfg.tableCodeForClass}Search extends React.Component {
    constructor(props) {
        super(props);
    }

    componentDidMount = () => {
        const { form } = this.props;
        //设置表单的值
        form.setFieldsValue(this.props.queryCondition)
    }


    submitForm = () => {
        const { form } = this.props;
        form.validateFields((err, values) => {
            if (!err) {
                //console.log("------------");
                //console.log(values);
                this.props.search${cfg.tableCodeForClass}(values);
            }
        });
    }

    resetForm = () => {
        const { form } = this.props;
        form.resetFields();
        this.submitForm();
    }

    onSearch = (v) => {
        this.props.onDicClassifySearch(v);
    }

    render() {
        const _this = this;
        const formItemLayout = {
            labelCol: {
                xs: { span: 2 },
                sm: { span: 4 },
            },
            wrapperCol: {
                xs: { span: 4 },
                sm: { span: 4 },
            },
        };




        const { getFieldDecorator } = this.props.form;
        const moreCondition = (
            <div className="moreCondition">
                <Form layout="inline">
                    <table>
                        <tbody>
                            <tr>     
                            <#if cfg.pkColumn.columnType=="java.lang.Float" || cfg.pkColumn.columnType=="java.lang.Double">
                      			<td>
					            	 ${cfg.pkColumn.columnDesc}：
					            </td>
                                <td>
                                    <Form.Item>
                                        {getFieldDecorator('${cfg.pkColumn.columnCodeForUpper}')(
                                            <InputNumber style={{ width: 150 }} />
                                        )}
                                    </Form.Item>
                                </td>
                      		</#if>
                      		<#if cfg.pkColumn.columnType=="java.lang.Integer" || cfg.pkColumn.columnType=="java.lang.Long">
                           		<td>
					            	 ${cfg.pkColumn.columnDesc}：
					            </td>
                                <td>
                                    <Form.Item>
                                        {getFieldDecorator('${cfg.pkColumn.columnCodeForUpper}',)(
                                            <InputNumber style={{ width: 150 }} />
                                        )}
                                    </Form.Item>
                                </td>
                      		</#if>
                            <#if cfg.pkColumn.columnType=="java.lang.String">
                                <td>
					            	 ${cfg.pkColumn.columnDesc}：
					            </td>
                                <td>
                                    <Form.Item>
                                        {getFieldDecorator('${cfg.pkColumn.columnCodeForUpper}')(
                                            <Input style={{ width: 150 }} />
                                        )}
                                    </Form.Item>
                                </td>
                            </#if>
                            <#if cfg.pkColumn.columnType=="java.util.Date">
                                <td>
					            	 ${cfg.pkColumn.columnDesc}：
					            </td>
                                <td>
                                    <Form.Item>
                                        {getFieldDecorator('${cfg.pkColumn.columnCodeForUpper}')(
                                            <DatePicker />
                                        )}
                                    </Form.Item>
                                </td>
                            </#if>                       
                            <#list cfg.columnList as col> 
                            <#if col.columnType=="java.lang.Float" || col.columnType=="java.lang.Double">
                      			<td>
					            	 ${col.columnDesc}：
					            </td>
                                <td>
                                    <Form.Item>
                                        {getFieldDecorator('${col.columnCodeForUpper}')(
                                            <InputNumber style={{ width: 150 }} />
                                        )}
                                    </Form.Item>
                                </td>
                      		</#if>
                      		<#if col.columnType=="java.lang.Integer" || col.columnType=="java.lang.Long">
                           		<td>
					            	 ${col.columnDesc}：
					            </td>
                                <td>
                                    <Form.Item>
                                        {getFieldDecorator('${col.columnCodeForUpper}',)(
                                            <InputNumber style={{ width: 150 }} />
                                        )}
                                    </Form.Item>
                                </td>
                      		</#if>
                            <#if col.columnType=="java.lang.String">
                                <td>
					            	 ${col.columnDesc}：
					            </td>
                                <td>
                                    <Form.Item>
                                        {getFieldDecorator('${col.columnCodeForUpper}')(
                                            <Input style={{ width: 150 }} />
                                        )}
                                    </Form.Item>
                                </td>
                            </#if>
                            <#if col.columnType=="java.util.Date">
                                <td>
					            	 ${col.columnDesc}：
					            </td>
                                <td>
                                    <Form.Item>
                                        {getFieldDecorator('${col.columnCodeForUpper}')(
                                            <DatePicker />
                                        )}
                                    </Form.Item>
                                </td>
                            </#if>
                            </#list> 
                            </tr>
                        </tbody>
                    </table>
                </Form>
            </div>
        );




        let deleteBton = null;
        if (this.props.selectedEntityIds && this.props.selectedEntityIds.length > 0) {
            deleteBton = (
                <Popconfirm
                    title="Are you sure delete these record ?"
                    placement="left"
                    okText="Yes"
                    cancelText="No"
                    onConfirm={() => { this.props.delete${cfg.tableCodeForClass}Batch(this.props.selectedEntityIds) }}
                >
                    <Button icon="delete" ></Button>
                </Popconfirm>
            )
        } else {
            deleteBton = (
                <Button icon="delete" disabled={true}></Button>
            )
        }

        return (


            <div className="search">

                <Row gutter={24}>
                    <Col span={20}>
                        <Form layout="inline">



                            <InputGroup compact >
                                {getFieldDecorator('dicName', {
                                })(
                                    <Input style={{ width: 150 }} placeholder="关键字" />
                                )}
                                <Tooltip placement="top" title="Search">
                                    <Button icon="search" loading={this.props.queryListLoading} onClick={this.submitForm} type="primary"></Button>
                                </Tooltip>
                                <Tooltip placement="top" title="more condition">
                                    <Popover
                                        style={{ background: "red" }}
                                        content={moreCondition}
                                        placement="bottom"
                                        trigger="click"
                                    >
                                        <Button><Icon type="ellipsis" rotate={90} /></Button>
                                    </Popover>
                                </Tooltip>

                                <Tooltip placement="top" title="Reset">
                                    <Button icon="redo" onClick={this.resetForm} ></Button>
                                </Tooltip>
                            </InputGroup>

                        </Form>
                    </Col>
                    <Col span={4} style={{ textAlign: "right" }}>

                        <ButtonGroup>
                            <Tooltip placement="top" title="new">
                                <Button type="primary" icon="plus" onClick={this.props.open${cfg.tableCodeForClass}Form}></Button>
                            </Tooltip>

                            <Tooltip placement="top" title="delete">
                                {deleteBton}
                            </Tooltip>
                        </ButtonGroup>
                    </Col>
                </Row>

            </div>
        )
    }
}

//export default ${cfg.tableCodeForClass}Search;

//1.封装form 
//2.初始化form组件值
const Wrapped${cfg.tableCodeForClass}Search = Form.create()(${cfg.tableCodeForClass}Search);
export default Wrapped${cfg.tableCodeForClass}Search;


