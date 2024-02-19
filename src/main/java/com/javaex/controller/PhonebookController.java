package com.javaex.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javaex.dao.PhoneDao;
import com.javaex.vo.PersonVo;

@WebServlet("/pbc") // 주소이름
public class PhonebookController extends HttpServlet {

	// 일반메소드
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

//		System.out.println("PhonebookController.doGet()");

		String action = request.getParameter("action");
		System.out.println(action);

		if ("wform".equals(action)) {
//			System.out.println("wform : 등록폼");

//	    	jsp한테 html그리게 하기 -> foward
			RequestDispatcher rd = request.getRequestDispatcher("/writeForm.jsp");
			rd.forward(request, response);

		} else if ("insert".equals(action)) {
//			System.out.println("insert : 등록");

			String name = request.getParameter("name");
			String hp = request.getParameter("hp");
			String company = request.getParameter("company");

			// Vo로 묶기
			PersonVo personVo = new PersonVo(name, hp, company);
			System.out.println(personVo.toString());

			System.out.println(name);
			System.out.println(hp);
			System.out.println(company);

			// DB관련 업무
			PhoneDao phoneDao = new PhoneDao();

			// db에 저장
			phoneDao.personInsert(personVo);

			// db에서 전체데이터 가져오기
			List<PersonVo> personList = phoneDao.personSelect();
			
			
			// request에 담기
			request.setAttribute("personList", personList);

			// foward
			RequestDispatcher rd = request.getRequestDispatcher("/list.jsp");
			rd.forward(request, response);

		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
