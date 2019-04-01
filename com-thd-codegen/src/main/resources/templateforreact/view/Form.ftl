import React from 'react';
import { Input,InputNumber, DatePicker,Form, Row, Col,  Divider, Button } from 'antd';
import MyRpcSelect from '../../../../components/custom/MyRpcSelect';
import moment from 'moment';
class SysDicPubForm extends React.Component {
    constructor(props) {
        super(props);
    }

    componentDidMount = () => {
        const { form } = this.props;
        
        if(this.props.entity){
        	//处理日期类型属性    将字符串转moment对象
			
			<#list cfg.columnList as col>
			<#if col.columnDataType=="date" >
			if(this.props.entity.${col.columnCodeForProperty}){
				this.props.entity.${col.columnCodeForProperty} = moment(this.props.entity.${col.columnCodeForProperty},"YYYY-MM-DD");
			}
			</#if>
			<#if col.columnDataType=="datetime" >
			if(this.props.entity.${col.columnCodeForProperty}){
				this.props.entity.${col.columnCodeForProperty} = moment(this.props.entity.${col.columnCodeForProperty},"YYYY-MM-DD kk:mm:ss");
			}
			</#if>
            </#list>
        }
        
        
        form.setFieldsValue(this.props.entity)
    }

    //保存
    saveSysDicPub = () => {
        const { form } = this.props;
        form.validateFields((err, values) => {
            if (!err) {
            	//处理日期类型属性  将moment对象转字符串
            	<#list cfg.columnList as col> 
            	<#if col.columnDataType=="date" >
            	if(values.${col.columnCodeForProperty}){
					values.${col.columnCodeForProperty} = values.${col.columnCodeForProperty}.format("YYYY-MM-DD");
				}
				</#if>
				<#if col.columnDataType=="datetime" >
				if(values.${col.columnCodeForProperty}){
					values.${col.columnCodeForProperty} = values.${col.columnCodeForProperty}.format("YYYY-MM-DD kk:mm:ss");
				}
				</#if>
            	</#list>
                
                
                console.log(values);
                this.props.onSave(values);
            }
        });
    }

    render() {
    	const _this = this;
    	
        //form 栅格化布局 (label和控件)
        const sysDicPubformItemLayout = {
            labelCol: {
                xs: { span: 24 },
                sm: { span: 8 },
            },
            wrapperCol: {
                xs: { span: 24 },
                sm: { span: 14 }
            }

        };

        const { getFieldDecorator } = this.props.form;
        //const colLayout = {xs:24,sm:12,md:12,lg:8,xl:8,xxl:6}

        //栅格布局(每个表单元素(label+控件))
        const colLayout = { xs: 24 }
        return (
            <div>
                <form layout="vertical">
                    <Row >
                        <#if cfg.pkColumn.columnType=="java.lang.Float" || cfg.pkColumn.columnType=="java.lang.Double">
                      	<Col {...colLayout}>
                            <Form.Item
                                {...sysDicPubformItemLayout}
                                label="${cfg.pkColumn.columnDesc}"
                            >
                                {getFieldDecorator('${cfg.pkColumn.columnCodeForProperty}', {
                                    rules: [{
                                        required: true, message: 'Please input ${cfg.pkColumn.columnDesc} !',
                                    }],
                                })(
                                    <InputNumber max={30} min={0} precision={2}/>
                                )}
                            </Form.Item>
                        </Col>
                      	</#if>
                      	<#if cfg.pkColumn.columnType=="java.lang.Integer" || cfg.pkColumn.columnType=="java.lang.Long">
                      	<Col {...colLayout}>
                            <Form.Item
                                {...sysDicPubformItemLayout}
                                label="${cfg.pkColumn.columnDesc}"
                            >
                                {getFieldDecorator('${cfg.pkColumn.columnCodeForProperty}', {
                                    rules: [{
                                        required: true, message: 'Please input ${cfg.pkColumn.columnDesc} !',
                                    }]
                                })(
                                    <InputNumber max={30} min={0}  precision={0}/>
                                )}
                            </Form.Item>
                        </Col>
                      	</#if>
                      	<#if cfg.pkColumn.columnType=="java.lang.String">
                      	<Col {...colLayout}>
                            <Form.Item
                                {...sysDicPubformItemLayout}
                                label="${cfg.pkColumn.columnDesc}"
                            >
                                {getFieldDecorator('${cfg.pkColumn.columnCodeForProperty}', {
                                    rules: [{
                                        max: 30,message:' Max : 30'
                                    },{
                                        min: 0,message:' Min : 0'
                                    }, {
                                        required: true, message: 'Please input ${cfg.pkColumn.columnDesc} !',
                                    }]
                                })(
                                    <Input />
                                )}
                            </Form.Item>
                        </Col>
                      	</#if>
                      	<#if cfg.pkColumn.columnType=="java.util.Date">
                      	<Col {...colLayout}>
                            <Form.Item
                                {...sysDicPubformItemLayout}
                                label="${cfg.pkColumn.columnDesc}"
                            >
                                {getFieldDecorator('${cfg.pkColumn.columnCodeForProperty}', {
                                    rules: [{
                                        required: true, message: 'Please input ${cfg.pkColumn.columnDesc} !',
                                    }],
                                })(
                                	<#if cfg.pkColumn.columnDataType=="datetime" >
                                    <DatePicker format="YYYY-MM-DD kk:mm:ss" showTime={true}/>
                                    </#if>
                                    <#if cfg.pkColumn.columnDataType=="date" >
                                    <DatePicker format="YYYY-MM-DD"/>
                                    </#if>
                                )}
                            </Form.Item>
                        </Col>
                      	</#if>
                        <#list cfg.columnList as col>
                      	<#if col.columnType=="java.lang.Float" || col.columnType=="java.lang.Double">
                      	<Col {...colLayout}>
                            <Form.Item
                                {...sysDicPubformItemLayout}
                                label="${col.columnDesc}"
                            >
                                {getFieldDecorator('${col.columnCodeForProperty}', {
                                    rules: [{
                                        required: true, message: 'Please input ${col.columnDesc} !',
                                    }]
                                })(
                                    <InputNumber max={30} min={0} precision={2}/>
                                )}
                            </Form.Item>
                        </Col>
                      	</#if>
                      	<#if col.columnType=="java.lang.Integer" || col.columnType=="java.lang.Long">
                      	<Col {...colLayout}>
                            <Form.Item
                                {...sysDicPubformItemLayout}
                                label="${col.columnDesc}"
                            >
                                {getFieldDecorator('${col.columnCodeForProperty}', {
                                    rules: [{
                                        required: true, message: 'Please input ${col.columnDesc} !',
                                    }]
                                })(
                                    <InputNumber max={30} min={0}  precision={0}/>
                                )}
                            </Form.Item>
                        </Col>
                      	</#if>
                      	<#if col.columnType=="java.lang.String">
                      	<Col {...colLayout}>
                            <Form.Item
                                {...sysDicPubformItemLayout}
                                label="${col.columnDesc}"
                            >
                                {getFieldDecorator('${col.columnCodeForProperty}', {
                                    rules: [{
                                        max: 30,message:' Max : 30'
                                    },{
                                        min: 0,message:' Min : 0'
                                    }, {
                                        required: true, message: 'Please input ${col.columnDesc} !',
                                    }]
                                })(
                                    <Input />
                                )}
                            </Form.Item>
                        </Col>
                      	</#if>
                      	<#if col.columnType=="java.util.Date">
                      	<Col {...colLayout}>
                            <Form.Item
                                {...sysDicPubformItemLayout}
                                label="${col.columnDesc}"
                            >
                                {getFieldDecorator('${col.columnCodeForProperty}', {
                                    rules: [{
                                        required: true, message: 'Please input ${col.columnDesc} !',
                                    }],
                                })(
                                   <#if col.columnDataType=="datetime" >
                                    <DatePicker format="YYYY-MM-DD kk:mm:ss" showTime={true}/>
                                    </#if>
                                    <#if col.columnDataType=="date" >
                                    <DatePicker format="YYYY-MM-DD"/>
                                    </#if>
                                )}
                            </Form.Item>
                        </Col>
                      	</#if>
                        </#list>
                    </Row>
                    <Divider />
                    <Row>
                        <Col span={24} style={{ textAlign: "right" }}>
                            <Button style={{ marginRight: 8 }} onClick={this.props.onCancel} >Canel</Button>
                            <Button type="primary" onClick={this.saveSysDicPub} loading={_this.props.onSaveLoading}>Save</Button>
                        </Col>
                    </Row>
                </form>
            </div>
        )
    }
}

const WrappedSysDicPubForm = Form.create()(SysDicPubForm);
export default WrappedSysDicPubForm;