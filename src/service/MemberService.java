package service;

import dto.MemberDto;

public interface MemberService {
	public boolean getId(String id); // prototype 사양
	public boolean addMember(MemberDto dto);
	public MemberDto login(String id, String pwd);
}
