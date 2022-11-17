package pend.aurrius.test.dao;

import java.util.ArrayList;

import pend.aurrius.test.dto.MemberDto;

public interface IDao {
	
	public void memberJoin(String mid, String mpw, String mname, String memail); // 회원가입, date도 잇지만 db에서 sysdate로 설정되있어 자동으로 입력되므로 적지않는다.
	public ArrayList<MemberDto>  memberList(); 	// 모든 회원 리스트 가져오기 (무조건 모두 가져오기)	,  가져오기 라서 selcet문을 써야한다.
	public MemberDto searchIdOk(String mid);	// 회원 아이디로 검색하여 1명 정보만 가져오기
	
	
}
