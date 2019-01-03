package com.thd.base.test.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.thd.base.test.dao.PersonRepository;
import com.thd.base.test.entity.Person;
import com.thd.base.test.service.PersonService;
import com.thd.core.bean.ResponseBean;
import com.thd.core.controller.BaseController;

@Controller
@RequestMapping("/person")
public class PersonController extends BaseController{
	@Autowired
	private PersonRepository personRepository;
	@Autowired
	private PersonService personService;
	//操作首页 http://127.0.0.1:8899/thd/person/index
	@RequestMapping(value="/index")
	public String index(){
		return "/person/index";
	}
	
	/**
	 * 测试synchronized方法
	 */
	//新增person
	@RequestMapping(value="/testTransaction",method=RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<ResponseBean> testTransaction(){
		//Person p = new Person();
		//p.setAddress("addr");
		//p.setAge(5);
		//p.setName("devil13th");
		//int i = 1/0;
		personService.savePerson(new Person());
		ResponseBean rb = new ResponseBean();
		rb.setResult(null);
		return rb.success();
	}
	
	
	
	/**
	 * 测试公共repository方法
	 */
	@RequestMapping(value="/testBaseRepository",method=RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<ResponseBean> testBaseRepository(){
		List l = this.personRepository.query("", null, 0, 0);
		ResponseBean rb = new ResponseBean();
		rb.setResult(l);
		return rb.success();
	}
	
	
	//查询列表
	@RequestMapping(value="/",method=RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<ResponseBean> queryAllPerson(){
		ResponseBean rb = new ResponseBean();
		//rb.setResult(personRepository.findAll());
		rb.setResult(personService.queryAllPerson());
		return rb.success();
	}
	
	//根据姓名查询
	@RequestMapping(value="/name/",method=RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<ResponseBean> queryPersonByName(@RequestParam("name") String name){
		ResponseBean rb = new ResponseBean();
		List l = this.personRepository.queryByName(name);
		rb.setResult(l);
		return rb.success();
	}
	
	//根据地址查询
	@RequestMapping(value="/addr/{addr}",method=RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<ResponseBean> queryPersonByAddr(@PathVariable String addr,@RequestBody Pageable pageRequest){
		ResponseBean rb = new ResponseBean();
		List l = this.personRepository.queryByAddr(addr,pageRequest);
		rb.setResult(l);
		return rb.success();
	}
	
	
	
	
	
	//根据id查询person
	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<ResponseBean> queryPersonById(@PathVariable String id){
		Optional<Person> p =  personRepository.findById(id);
		
		ResponseBean rb = new ResponseBean();
		if(p.isPresent()){
			rb.setResult(p.get());
		}else{
			rb.setResult(null);
		}
		return rb.success();
	}
	
	//根据id删除person
	@RequestMapping(value="/{id}",method=RequestMethod.DELETE)
	@ResponseBody
	public ResponseEntity<ResponseBean> deletePersonById(@PathVariable String id) throws Exception {
		if(StringUtils.isEmpty(id)){
			throw new Exception("请提供person的id");
		}
		if(!this.personRepository.findById(id).isPresent()){
			throw new Exception("未找到person");
		}
		personRepository.deleteById(id);
		ResponseBean rb = new ResponseBean();
		rb.setResult(null);
		return rb.success();
	}
	
	//新增person
	@RequestMapping(value="/",method=RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<ResponseBean> addPerson(@RequestBody Person person){
		//Person p = new Person();
		//p.setAddress("addr");
		//p.setAge(5);
		//p.setName("devil13th");
		//int i = 1/0;
		if(!StringUtils.isEmpty(person.getId())){
			throw new RuntimeException("id属性必须为空");
		}
		personRepository.save(person);
		ResponseBean rb = new ResponseBean();
		rb.setResult(person);
		return rb.success();
	}
	
	//修改person
	@RequestMapping(value="/{id}",method=RequestMethod.PUT)
	@ResponseBody
	public ResponseEntity<ResponseBean> updatePerson(@PathVariable String id,@RequestBody Person person) throws Exception{
		if(StringUtils.isEmpty(id)){
			throw new Exception("请提供person的id");
		}
		Optional p = personRepository.findById(id);
		if(!p.isPresent()){
			throw new Exception("未找到person对象");
		}
		
		person.setId(id);
		personRepository.saveAndFlush(person);
		ResponseBean rb = new ResponseBean();
		rb.setResult(person);
		return rb.success();
	}
	
	
}
