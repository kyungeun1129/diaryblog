
public class BlogDTO {
	private String id;
	private String nickname;
	private String password;
	private String email;
	private String gender;
	private int birth;
    private String agree;
    
    public BlogDTO() {
	}

	public BlogDTO(String id, String nickname, String password, String email, String gender, int birth, String agree) {
		super();
		this.id = id;
		this.nickname = nickname;
		this.password = password;
		this.email = email;
		this.gender = gender;
		this.birth = birth;
		this.agree = agree;
	}

	@Override
	public String toString() {
		return "BlogDTO [id=" + id + ", nickname=" + nickname + ", password=" + password + ", email=" + email
				+ ", gender=" + gender + ", birth=" + birth + ", agree=" + agree + "]";
	}
	
	
	// getter /setter
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getBirth() {
		return birth;
	}

	public void setBirth(int birth) {
		this.birth = birth;
	}

	public String getAgree() {
		return agree;
	}

	public void setAgree(String agree) {
		this.agree = agree;
	}
    
    
}
