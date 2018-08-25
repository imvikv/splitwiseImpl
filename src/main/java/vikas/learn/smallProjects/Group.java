package vikas.learn.smallProjects;

import java.util.HashMap;
import java.util.Map;

import vikas.learn.smallProjects.Helper.cacheType;

public class Group {

	String groupId;
	String groupName;
	String[] members;
	

	
	public boolean createGroup(String groupName,String[] members)
	{
		Map<cacheType, Map<String, Object>> cache = Helper.getCache();
		Map<String, Object> groups = cache.get(Helper.cacheType.group);
		if(null==groups)
			groups= new HashMap<String, Object>();
		if(!groups.containsKey(groupName))
		{
			Map<String,String> groupEntry=new HashMap<String, String>();
			for(String member: members)
			{
				groupEntry.put(member, String.valueOf(0));
			}
			groups.put(groupName, groupEntry);
			cache.put(Helper.cacheType.group, groups);
			return true;
		}
		return false;
		
	}
	
	public boolean invite(String userID,String groupName,String emailIDTo)
	{
		return false;
		
	}
}
