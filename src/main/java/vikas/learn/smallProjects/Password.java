package vikas.learn.smallProjects;

import java.util.HashMap;
import java.util.Map;

import vikas.learn.smallProjects.Helper.cacheType;

public class Password {

	public Password(String passwd) {
		super();
		this.passwd = passwd;
	}

	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return ""+passwd;
	}

	public static boolean makeEntryForPassword(String userId,String passwd)
	{
		Map<cacheType, Map<String, Object>> cache = Helper.getCache();
		Map<String, Object> password = cache.get(Helper.cacheType.password);
		if(null== password)
			password= new HashMap<String, Object>();
		if(password.containsKey(userId))
			{
			System.out.println("Password Entry Already exist for user "+ userId);
			return false;
			}
		else 
			{password.put(userId, passwd);
		cache.put(Helper.cacheType.password, password);
		System.out.println("User signup Successful  for user "+ userId);
			}
		return true;
	}

	String passwd;
}
