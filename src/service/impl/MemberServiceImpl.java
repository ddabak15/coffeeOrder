package service.impl;

import dao.MemberDao;
import dao.impl.MemberDaoImpl;
import dto.MemberDto;
import service.MemberService;

// controller와 dao의 중간자
public class MemberServiceImpl implements MemberService {

	// interface의 instance를 생성
	MemberDao dao = new MemberDaoImpl();

	// Service는 controller와 dao의 중간에 위치하여 전달.

	public boolean getId(String id) {
		return dao.getId(id);
	}

	@Override
	public boolean addMember(MemberDto dto) {
		return dao.addMember(dto);
	}

	@Override
	public MemberDto login(String id, String pwd) {
		return dao.login(id, pwd);
	}

}
