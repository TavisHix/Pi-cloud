
public class user {
	
	
	private int _id;
	private String _username;
	private String _password;
	

	public user(){
		
		
	}
	
	
	public user(String uname, String pword){
		_username = uname;
		_password = pword;
	}

	// sets the user id
	public void set_id(int id){
		_id = id;
	}
	
	// gets the users id
	public int get_id(){
		return _id;
	}
	
	// sets the username
	public void set_username(String uname){
		_username = uname;
	}
	
	// gets the users username
	public String get_username(){
		return _username;
	}
	
	// sets the password
	public void set_password(String pword){
		_password = pword;
	}
		
	// gets the users password
	public String get_password(){
		return _password;
	}
}
