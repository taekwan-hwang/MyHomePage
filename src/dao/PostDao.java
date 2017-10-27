package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import service.MyBatisConnector;
import vo.PostVo;

public class PostDao {
	private static PostDao dao=null;
	SqlSessionFactory factory;
	private PostDao(){
		factory=MyBatisConnector.getInstance().getSqlSessionFactory();
	}
	public static PostDao getInstance(){
		if(dao==null){
			dao=new PostDao();
		}
		return dao;
	}
	public List<PostVo> makeList(){
		List<PostVo> postList = null;
		SqlSession session=factory.openSession();
		postList=session.selectList("post.makeList");
		if(postList==null){
			System.out.println("list is pointing null");
		}else{
			System.out.println("make list");
		}
		for(PostVo vo:postList){
			System.out.println(vo.getIdx());
		}
		session.close();
		return postList;
	}
}