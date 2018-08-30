
// https://www.geeksforgeeks.org/window-sliding-technique/

// Returns maximum sum in 
    // a subarray of size k.
    static int maxSum(int arr[], int n, int k)
    {
        // k must be greater
        if (n < k)
        {
        System.out.println("Invalid");
        return -1;
        }
     
        // Compute sum of first window of size k
        int max_sum = 0;
        for (int i = 0; i < k; i++)
        max_sum += arr[i];
     
        // Compute sums of remaining windows by
        // removing first element of previous
        // window and adding last element of
        // current window.
        int window_sum = max_sum;
        for (int i = k; i < n; i++)
        {
        window_sum += arr[i] - arr[i - k];
        max_sum = Math.max(max_sum, window_sum);
        }
     
        return max_sum;
    }
    
    // https://leetcode.com/problems/contains-duplicate-ii/description/
    
    public boolean containsNearbyDuplicate(int[] nums, int k) {
       if(null == nums || nums.length < 2) {
            return false;
        }
        Map <Integer,Integer> maps = new HashMap<>();
        for(int i =0; i < nums.length ; i++) {
            int key = nums[i];
            if(maps.containsKey(key)) {
                Integer num = maps.get(key);
                    if(Math.abs(i - num ) <= k) {
                        return true;
                    }
            } 
                maps.put(key, i);
            
        }
      return false;    
    }
    
    
