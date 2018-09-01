package vikas.learn.smallProjects.splitwise;

public class Main {

	public static void main(String[] args) {

		//create signup users
		PublicAPIimpl api= new PublicAPIimpl();
		api.signUp("A", "a", "a@gmail.com");
		api.signUp("B", "ab", "ab@gmail.com");
		api.signUp("C", "abc", "abc@gmail.com");
		api.signUp("D", "abcd", "abcd@gmail.com");
	
		
		// add group
		api.createGroup("abacus", new String[] {"A","B","C","D"});
		
		//add expense
		
		api.addExepnse("A", "abacus", new String[] {"A","B","C","D"}, "1000");
		Helper.printBalanceforGroup("abacus");
		api.addExepnse("A", "abacus", new String[] {"B","C","D"}, "100");
		Helper.printBalanceforGroup("abacus");
		api.addExepnse("B", "abacus", new String[] {"B","C","D"}, "100");
		Helper.printBalanceforGroup("abacus");
		
		//check login
		boolean loginSuccess=api.logIn("A", "a");
		System.out.println("A user with password a login api status "+loginSuccess);
		
	}

}
