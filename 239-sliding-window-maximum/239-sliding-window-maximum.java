class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length ;
        int r1= 0 ;
        int r[] = new int [n-k+1];
        Deque<Integer> q = new ArrayDeque<>();
        
        
        for(int i=0 ; i<n ; i++)
        {
            // Checking the condition for popping out the boundary elem
            if(!q.isEmpty() && q.peek() == i-k){
                q.poll();
            }
            // Maintainig the decresing orde
            while(!q.isEmpty() && nums[q.peekLast()] < nums[i])
            {
                q.pollLast();
            }
            
            q.offer(i);
            
            if(i>=k-1)
            {
                r[r1++] = nums[q.peek()];
            }
        }
        
        return r;
        
        
    }
}

// peek --> front ;
// peekLast() --> from back;
// poll() --> poll from front ;
// pollLast() --> poll from last;