package vikas.learn.smallProjects;

public class MaxLenContigiousZeroOne {

	public static void main(String[] args) {
	//	System.out.println(new MaxLenContigiousZeroOne().maxLen(new int[] {0,0,1,0,0}));
		System.out.println(new MaxLenContigiousZeroOne().maxLen(new int[] {1,1,0,1,0,0,0,0,1,0,0,0,0,1,1,0,0,0,1,1,1,0,1,0,0,0,1,0,0,1,1,1,0,1,0,1,1,1,1,1,1,1,1,1,1,0,1,1,0,1,0,1,1,0,0,1,0,1,1,1,0,0,0,1,0,1,0,1,0,1,0,1,1,1,1,0,0,0,1,0,1,0,0,0,0}));
	}
    /*You are required to complete this method*/ 
    int maxLen(int[] arr) 
    {
        int one=0,zero=0;
        
        //first get the length of 0 and 1
        for(int i=0;i<arr.length;i++)
        {
            if(arr[i]==0)
            zero++;
            else
            one++;
        }
        if(zero==one)
        return 2*zero;
        // now that means we have unequal numers of 0 and 1
        // now take two pointers and move those pointers such that we can maximise the length
        //for that we will move the pointer from the direction where we can avoid deleting the minority element
        int left=0, right=arr.length-1;
        int[] arr1= new int[2];
        arr1[0]=zero;
        arr1[1]=one;
        int minority=0;
        if(zero>one)
        {minority=1;}
        while(left<right)
        {
            if(right-left+1==arr1[0]+arr1[1] && arr1[1]==arr1[0])
            {
               break;
            }
        if(arr[left]==minority)
        {
            //reduce from other side
            if(arr[right]==0)
            {
                arr1[0]=arr1[0]-1;
                right--;
            }
            else
            {
            arr1[1]=arr1[1]-1;
            right--;
            }
        }
        //
        else
        {//reduce from left itself
           if(arr[left]==0)
           {
               arr1[0]=arr1[0]-1;
               left++;
           }
           else
           {
            arr1[1]=arr1[1]-1;
            left++;
           }
        }
        }
        
        return 2*arr1[1]; 
    }

}


