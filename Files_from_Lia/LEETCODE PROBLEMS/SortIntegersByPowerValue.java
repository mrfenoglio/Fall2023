class SortIntegersByPowerValue {
  // pr 1387
  public static int getKth(int lo, int hi, int k) {
    	List<Integer> pow = new ArrayList<>();
    	pow.add(power(lo));
    	List<Integer> val = new ArrayList<>();
    	val.add(lo);
    	
    	for (int i = lo+1; i <= hi; i++)
    	{
    		int p = power(i);
    		int index = 0;
    		for (int j = 0; j < pow.size(); j++)
    		{
    			if (p >= pow.get(j))
    			{
    				index = j+1;
    			}
    		}
    		pow.add(index, p);
    		val.add(index, i);
    	}
    	return val.get(k-1);
    	
    }
    
    public static int power(int n)
    {
    	if (n == 1)
    		return 0;
    	if (n % 2 == 0)
    		return 1 + power(n/2);
    	else
    		return 1 + power(3*n+1);
    }
}
