package pend.aurrius.test;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import pend.aurrius.test.dao.IDao;
import pend.aurrius.test.dto.MemberDto;



@Controller
public class TestController {

	
	@Autowired
	private SqlSession sqlSession;
	
	@RequestMapping(value = "/join")
	public String join() {
		
		
		return "join";		// <--- 실행시키고자하는 페이지의 이름을 넣어야한다.
	}
	
	
	@RequestMapping(value = "joinMember")
	public String joinMember(HttpServletRequest request, Model model) {

		
		IDao dao = sqlSession.getMapper(IDao.class);
		
		String mid = request.getParameter("mid");
		String mpw = request.getParameter("mpw");
		String mname = request.getParameter("mname");
		String memail = request.getParameter("memail");

		dao.memberJoin(mid, mpw, mname, memail);
		model.addAttribute("mid", mid);
		
		
		return "joinOk";
	}

	
	@RequestMapping(value = "memberList")	
	public String memberList(HttpServletRequest request, Model model) {
		
		IDao dao = sqlSession.getMapper(IDao.class);
		
		ArrayList<MemberDto> memberDtos = dao.memberList();	// 모아서 한꺼번에 보내야한다.
		// 예를들어 한개씩 빼고싶다면 dtos.get(0).getMname(); 해서 방번호에서 이름만 가져오기 해서 일일히 해야한다. ,, 첫번째 가입회원의 이름추출
		
		model.addAttribute("memberList", memberDtos);
		
		return "memberList";
	}
	

	@RequestMapping(value = "searchId")
	public String searchId() {
		
		return "idSearch";
	}
	
	
	@RequestMapping(value = "idOk")
	public String idOk(HttpServletRequest request, Model model) {
		
		IDao dao = sqlSession.getMapper(IDao.class);
		
		String searchId = request.getParameter("searchId");
		
		MemberDto IDdto = dao.searchIdOk(searchId);	
		
		model.addAttribute("searchId", IDdto);
		
		return "idOk";
	}
	
	
}
