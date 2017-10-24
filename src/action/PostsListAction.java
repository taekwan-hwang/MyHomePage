package action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vo.PostVo;

public class PostsListAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		List<PostVo> postList = new ArrayList<>();
		String msg = "my mvc";
		request.setAttribute("msg", msg);
		return "success";
	}
}
