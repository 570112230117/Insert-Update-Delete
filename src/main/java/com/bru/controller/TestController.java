package com.bru.controller;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.bru.dao.TestDao;
import com.bru.model.TestBean;


@Controller
public class TestController {

	@Autowired
	TestDao testDao;
	
	@RequestMapping("/")
		public String test() {
		return "index";
	}
	//insert
	@RequestMapping("/index")
	public String test2(String email, String password ,HttpServletRequest res) {
		List<TestBean> list = new ArrayList<>();
		TestBean bean = new TestBean();
		bean.setEmail(email);
		bean.setPassword(password);
	
		try {
			testDao.insert(bean);
			list=testDao.findAll();
			res.getSession().setAttribute("listUser", list);

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return "index2";
	}
	//end gotoupdate
	@RequestMapping("/gotoupdate")
	public String gotoupdate(int id,String email,String password, HttpServletRequest request , Model model) {
		TestBean bean = new TestBean();
		
		try {
			bean.setId(id);
			bean.setEmail(email);
			bean.setPassword(password);
		testDao.update(bean);
			//testDao.findByidCard(bean);
		List<TestBean> list = new ArrayList<>();
		list=testDao.findAll();
		request.getSession().setAttribute("listUser", list);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();

		}
		
		return "index2";
	}
	@RequestMapping("/update")
	public String update(int email, HttpServletRequest request , Model model) {
		TestBean bean = new TestBean();
		
		try {
			bean.setId(email);
//			testDao.update(testBean);
			testDao.amnuay(bean);
			request.getSession().setAttribute("top", bean);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();

		}
		
		return "update";
	}
	
	@RequestMapping("/delete")
	public String delete(Model model, int email, HttpServletRequest request) {
//		TestBean bean = new TestBean();
		
		try {
			testDao.delete(email);
			List<TestBean> list = new ArrayList<>();
			list=testDao.findAll();
			request.getSession().setAttribute("listUser", list);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			
		}
		return "index2";
	}
}
