package controller;

import javax.swing.JOptionPane;

import dto.MemberDto;
import service.MemberService;
import service.impl.MemberServiceImpl;
import singleton.Singleton;
import view.accountView;
import view.loginView;

public class MemberController {
	MemberService memServ = new MemberServiceImpl();

	public void login() {
		new loginView();
	}

	public void loginAf(String id, String pwd) {
		MemberDto dto = memServ.login(id, pwd);
		if (dto == null) {
			JOptionPane.showMessageDialog(null, "ID나 PW가 틀렸습니다");
			login();
		} else {
			JOptionPane.showMessageDialog(null, dto.getId() + "님 환영합니다");
			// id저장 -> session
			Singleton s = Singleton.getInstance();
			s.setLoginID(dto.getId());

			// 커피 주문창
			s.coffeeCtrl.getOrder();
			
		}
	}

	public void regi() {
		new accountView();
	}

	public void regiAf(String id, String pwd, String name, String email) {
		boolean b = memServ.addMember(new MemberDto(id, pwd, name, email, 3));
		if(b) {
			JOptionPane.showMessageDialog(null, "회원가입 성공!");
			login();
		} else {
			JOptionPane.showMessageDialog(null, "회원가입 실패!");
			regi();
		}
	}

	public boolean idCheck(String id) {
		return memServ.getId(id);
	}

}
