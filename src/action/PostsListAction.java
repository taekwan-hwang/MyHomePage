package action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.PostDao;
import vo.PostVo;

public class PostsListAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		List<PostVo> postList = PostDao.getInstance().makeList();
		request.setAttribute("postList", postList);
		return "success";
	}
}
