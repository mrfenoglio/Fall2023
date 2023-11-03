import java.util.*;
public class Permutation {
	private List<List<Integer>> bigList = new ArrayList<>();
	public Permutation(int[] nums) {
	    List<List<Integer>> list = new ArrayList<>();
	    Arrays.sort(nums);
	    backtrack(list, new ArrayList<>(), nums);
	    bigList = list;
	}
	public Permutation(int[] nums, int r) {
	    List<List<Integer>> list = new ArrayList<>();
	    Arrays.sort(nums);
	    backtrack(list, new ArrayList<>(), nums, r);
	    bigList = list;
	}

	private void backtrack(List<List<Integer>> list, List<Integer> tempList, int [] nums){
		if (tempList.size() == nums.length){
			list.add(new ArrayList<>(tempList));
		}
		else {
			for (int i = 0; i < nums.length; i++){ 
				if (tempList.contains(nums[i])) continue; // element already exists, skip
		        tempList.add(nums[i]);
		        backtrack(list, tempList, nums);
		        tempList.remove(tempList.size() - 1);
			}
		}
	} 
	
	private void backtrack(List<List<Integer>> list, List<Integer> tempList, int [] nums, int r){
		if(tempList.size() == r){
			list.add(new ArrayList<>(tempList));
		}
		else {
			for (int i = 0; i < nums.length; i++){ 
				if (tempList.contains(nums[i]) || tempList.size() == r) continue; // element already exists, skip
		        tempList.add(nums[i]);
		        backtrack(list, tempList, nums, r);
		        tempList.remove(tempList.size() - 1);
			}
		}
	}
}
