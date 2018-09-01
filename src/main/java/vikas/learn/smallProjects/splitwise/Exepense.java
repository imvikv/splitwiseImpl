package vikas.learn.smallProjects.splitwise;

import java.util.HashMap;
import java.util.Map;

import vikas.learn.smallProjects.splitwise.Helper.cacheType;

public class Exepense {

	String expenseId;
	String groupID;
	String paidBy;
	String[] paidFor;
	String amount;
	
	/**
	 * @return the amount
	 */
	public String getAmount() {
		return amount;
	}

	public Exepense(String expenseId, String groupID, String paidBy, String[] paidFor, String amount) {
		super();
		this.expenseId = expenseId;
		this.groupID = groupID;
		this.paidBy = paidBy;
		this.paidFor = paidFor;
		this.amount = amount;
	}

	/**
	 * @param amount the amount to set
	 */
	public void setAmount(String amount) {
		this.amount = amount;
	}


	/**
	 * @return the paidBy
	 */
	public String getPaidBy() {
		return paidBy;
	}

	/**
	 * @param paidBy the paidBy to set
	 */
	public void setPaidBy(String paidBy) {
		this.paidBy = paidBy;
	}

	/**
	 * @return the paidFor
	 */
	public String[] getPaidFor() {
		return paidFor;
	}

	/**
	 * @param paidFor the paidFor to set
	 */
	public void setPaidFor(String[] paidFor) {
		this.paidFor = paidFor;
	}

	/**
	 * @return the expenseId
	 */
	public String getExpenseId() {
		return expenseId;
	}

	/**
	 * @param expenseId the expenseId to set
	 */
	public void setExpenseId(String expenseId) {
		this.expenseId = expenseId;
	}

	/**
	 * @return the groupID
	 */
	public String getGroupID() {
		return groupID;
	}

	/**
	 * @param groupID the groupID to set
	 */
	public void setGroupID(String groupID) {
		this.groupID = groupID;
	}


 

	public Exepense() {
		super();
	}

	public boolean addExepnse(String userID,Exepense expense)
	{
		
		Map<cacheType, Map<String, Object>> cache = Helper.getCache();
		Map<String, Object> groups = cache.get(Helper.cacheType.group);
		if(groups.containsKey(expense.getGroupID()))
		{
			//valid group 
			@SuppressWarnings("unchecked")
			Map<String,String> groupBalance=  (HashMap<String, String>) groups.get(expense.getGroupID());
			//make list to map for iteration and reconceliation purpose
			Map<String,String> expenseList= new HashMap<String, String>();
			int share=Integer.parseInt(expense.getAmount())/expense.getPaidFor().length;
			share=0-share; // to negate
			for(String member:expense.getPaidFor())
			{
				expenseList.put(member, String.valueOf(share));
			}
			//now settle balance
			for(String entry:groupBalance.keySet())
			{
				if(entry.equals(expense.getPaidBy()))
				{
					int value=Integer.valueOf(groupBalance.get(entry))+Integer.valueOf(expense.getAmount());
					groupBalance.put(entry, String.valueOf(value));
				}
				if(expenseList.containsKey(entry)) {
				int newBalance=Integer.valueOf(groupBalance.get(entry))+Integer.valueOf(expenseList.get(entry));
				groupBalance.put(entry, String.valueOf(newBalance));
				}
				
			}
			
		}
		else {
			System.out.println("Invalid group group ID "+groupID);
			return false;
		}
		
		
		return true;
		
	}
	
	public boolean addExepnse(String paidBy,String groupID,String[] paidFor,String amount)
	{
		Exepense e=new Exepense(Helper.generateId(), groupID, paidBy, paidFor,amount);
		return addExepnse(paidBy, e);
		
	}
}
