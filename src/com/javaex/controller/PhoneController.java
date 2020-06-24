package com.javaex.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javaex.dao.PhoneDao;
import com.javaex.util.WebUtil;
import com.javaex.vo.PersonVo;

@WebServlet("/pbc")
public class PhoneController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("pbc");
		
		String action = request.getParameter("action");
		//action=list
		System.out.println(action);
		if("list".equals(action))
		{
			PhoneDao pDao = new PhoneDao();
			List<PersonVo> pList = pDao.getPersonList();
			System.out.println(pList.toString());
			//데이터 리퀘스트에 추가
			request.setAttribute("pList", pList);
			//포워드작업
			WebUtil.foword(request, response, "/WEB-INF/list.jsp");
//			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/list.jsp");
//			rd.forward(request, response);
		}
		//action=delete
		if("wform".equals(action)||"".equals(action)) 
		{
			WebUtil.foword(request, response, "/WEB-INF/wform.jsp");
//			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/wform.jsp");
//			rd.forward(request, response);
		}
		if("insert".equals(action)) 
		{
			String name = request.getParameter("name");
			String hp = request.getParameter("hp");
			String company = request.getParameter("company");
			
			PersonVo pVo = new PersonVo(name,hp,company);

			PhoneDao pDao = new PhoneDao();
			pDao.personInsert(pVo);
			WebUtil.redeirect(request, response, "/pb2/pbc?action=list");
			
//			response.sendRedirect("/pb2/pbc?action=list");
		}
		
		if("updateForm".equals(action)) {
			WebUtil.foword(request, response, "/WEB-INF/updateForm.jsp");
		}
		if("update".equals(action)) {
			request.setCharacterEncoding("UTF-8");
			int person_id = Integer.parseInt(request.getParameter("person_id"));
			String name = request.getParameter("name");
			String hp = request.getParameter("hp");
			String company = request.getParameter("company");
			PersonVo pVo = new PersonVo(person_id, name, hp, company);
			PhoneDao pDao = new PhoneDao();
			pDao.personUpdate(pVo);
			WebUtil.redeirect(request, response, "/pb2/pbc?action=list");
		}
		if("delete".equals(action)) {
			int person_id = Integer.parseInt(request.getParameter("person_id"));
			PhoneDao pDao = new PhoneDao();
			pDao.personDelete(person_id);
			WebUtil.redeirect(request, response, "/pb2/pbc?action=list");
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
