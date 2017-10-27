package dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import service.MyBatisConnector;
import vo.MemberVo;

public class MemberDao {
	private static MemberDao single = null;
	SqlSessionFactory factory;
	private MemberDao() {
		factory = MyBatisConnector.getInstance().getSqlSessionFactory();
		//factory initiate
	}

	public static MemberDao getInstance() {
		if (single == null) {
			single = new MemberDao();
		}
		System.out.println("dao made");
		return single;
	}

	public MemberVo found(String id, String pwd) {
		// TODO Auto-generated method stub
		MemberVo vo = null;
		MemberVo temp = new MemberVo();
		temp.setId(id);
		temp.setPwd(pwd);
		SqlSession sqlsession = factory.openSession();
		System.out.println("Session made");
		vo = sqlsession.selectOne("member.find", temp);
		
		sqlsession.close();
		
		return vo;
	}
	
	public void signUp(String id, String pwd, String name){
		MemberVo temp = new MemberVo();
		temp.setId(id);
		temp.setPwd(pwd);
		temp.setName(name);
		SqlSession sqlsession = factory.openSession();
		System.out.println(temp.getId());
		
		sqlsession.insert("member.signupmember", temp);
		//MyBatis is not auto-commit, so need commit method invoke
		sqlsession.commit();
		sqlsession.close();
	}
}