package vikas.learn.smallProjects.splitwise;

public class PublicAPIimpl implements PublicAPI{

	User u= new User();
	Group gp= new Group();
	Exepense exp= new Exepense();
	public boolean logIn(String userID, String password) {
		return  u.logIn(userID, password);
	}

	public boolean signUp(String userID, String password, String emailID) {
		
		 return u.signUp(userID, password, emailID);
		 
	}

	public boolean createGroup(String groupName,String[] members) {
		return gp.createGroup(groupName, members);
	}

	public boolean invite(String userID, String groupName, String emailIDTo) {
		// will implement
		return false;
	}

	public boolean addExepnse(String paidBy, String groupID, String[] paidFor, String amount) {
		return exp.addExepnse(paidBy, groupID, paidFor, amount);
	}

}
