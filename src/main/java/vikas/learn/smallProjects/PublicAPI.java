/**
 * 
 */
package vikas.learn.smallProjects;

/**
 * @author vermv2
 *
 */
public interface PublicAPI {

	public boolean logIn(String userID,String password);
	public boolean signUp(String userID,String password,String emailID);
	public boolean createGroup(String groupName,String[] members);
	public boolean invite(String userID,String groupName,String emailIDTo);
	public boolean addExepnse(String paidBy,String groupID,String[] paidFor,String amount);
}
