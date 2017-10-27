package action;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MemberDao;
import vo.MemberVo;

public class LoginAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		String isSave = request.getParameter("save");
		System.out.println("parameter got");
		MemberVo vo = MemberDao.getInstance().found(id, pwd);
		System.out.println("found complete");
		
		if (isSave.equals("y")) {
			Cookie id_ck = new Cookie("id", id);// /login/login.do 에서 만들었으므로, 유효범위는
												// /login
			id_ck.setMaxAge(20);
			id_ck.setPath("/");// 유효범위를 /로 바꿈
			response.addCookie(id_ck);
		}
		if (vo != null) {
			request.getSession().setMaxInactiveInterval(10);// 세션의 유지 시간
			request.getSession().setAttribute("user", vo);
			return "/main.do";
		} else {
			Cookie loginResult_ck = new Cookie("loginResult", "false");
			loginResult_ck.setMaxAge(20);
			loginResult_ck.setPath("/");
			response.addCookie(loginResult_ck);
			System.out.println("vo is null");
			return "/login/loginform.do";
		}

	}
}