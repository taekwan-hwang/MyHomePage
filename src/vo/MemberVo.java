package vo;

public class MemberVo {
	private String id, name, pwd;
	public MemberVo(){}
	public MemberVo(String id, String pwd, String name){
		this.id=id;
		this.pwd=pwd;
		this.name=name;
	}
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
}
