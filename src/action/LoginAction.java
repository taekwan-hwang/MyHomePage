package action;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MemberDao;
import vo.MemberVo;

public class LoginAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		String isSave = request.getParameter("save");
		System.out.println("parameter got");
		MemberVo vo = MemberDao.getInstance().found(id, pwd);
		System.out.println("found completee");
		// System.out.println(vo.getId());
		if (isSave.equals("y")) {
			Cookie ck = new Cookie("id", id);// /login/login.do 에서 만들었으므로, 유효범위는
												// /login
			ck.setMaxAge(20);
			ck.setPath("/");// 유효범위를 /로 바꿈
			response.addCookie(ck);
		}
		if (vo != null) {
			request.getSession().setMaxInactiveInterval(10);// 세션의 유지 시간
			request.getSession().setAttribute("user", vo);
			return "/main.do";
		} else {
			System.out.println("vo is null");
			return "/login/loginform.do";
		}

	}
}