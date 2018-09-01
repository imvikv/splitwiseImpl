package vikas.learn.smallProjects.splitwise;

import java.util.HashMap;
import java.util.Map;

import vikas.learn.smallProjects.splitwise.Helper.cacheType;

public class User {

	String userId;
	String name;
	String emailId;
	Password passwd;

	/**
	 * @return the userId
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * @param userId
	 *            the userId to set
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the emailId
	 */
	public String getEmailId() {
		return emailId;
	}

	/**
	 * @param emailId
	 *            the emailId to set
	 */
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	/**
	 * @return the passwd
	 */
	public Password getPasswd() {
		return passwd;
	}

	/**
	 * @param passwd
	 *            the passwd to set
	 */
	public void setPasswd(Password passwd) {
		this.passwd = passwd;
	}

	
	public User() {
		super();
	}

	public  User(String userId, String name, String emailId, Password passwd) {
		super();
		this.userId = userId;
		this.name = name;
		this.emailId = emailId;
		this.passwd = passwd;
	}

	public boolean logIn(String userID, String password) {
		Map<cacheType, Map<String, Object>> cache = Helper.getCache();
		Map<String, Object> login = cache.get(Helper.cacheType.login);
		Map<String, Object> passwd = cache.get(Helper.cacheType.password);
		if(login.containsKey(userID) && passwd.get(userID).equals(password))
		{
			return true;
		}
		return false;
	}

	public boolean signUp(String userID, String password, String emailID) {
		return makeEntry(new User(Helper.generateId(), userID, emailID, new Password(password)));
	}

	private boolean makeEntry(User u) {
		Map<cacheType, Map<String, Object>> cache = Helper.getCache();
		Map<String, Object> login = cache.get(Helper.cacheType.login);
		if (null == login) {
			login = new HashMap<String, Object>();
		}
		if(!login.containsKey(u.getName()))
		{
			login.put(u.getName(), u.toString());
			cache.put(Helper.cacheType.login, login);
			return Password.makeEntryForPassword(u.getName(), u.getPasswd().passwd);
		}
		System.out.println("Failed to  make Entry for user "+ u.toString());
		return false;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return ""+name+"|"+name+"|"+emailId;
	}
}
