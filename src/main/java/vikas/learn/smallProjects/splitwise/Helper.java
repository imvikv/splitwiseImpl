package vikas.learn.smallProjects.splitwise;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class Helper {
	public static Map<cacheType,  Map<String,Object>> cache;
	public enum cacheType{
		expense,
		login,
		password,
		group
	}

	public static String generateId()
	{
		return UUID.randomUUID().toString();
	}
	
	public static Map<cacheType, Map<String,Object>> getCache()
	{
		if(null==cache)
		{
		 cache= new HashMap<Helper.cacheType, Map<String,Object>>();
		}
		return cache;
		
	}
	
	public static void printBalanceforGroup(String groupId)
	{
		Map<String, Object> grp= cache.get(cacheType.group);
		Map<String,String> grpBalance= (Map<String, String>) grp.get(groupId);
		StringBuilder sb= new StringBuilder();
		sb.append("[");
		for(String s: grpBalance.keySet())
		{
			sb.append(s+":"+grpBalance.get(s)+" ,");
		}
		sb.append("]");
		System.out.println(sb.toString());
	}
}
