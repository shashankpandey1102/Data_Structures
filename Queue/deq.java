package Queue;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class deq {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] result = new int[n - k + 1];
        Deque<Integer> q = new LinkedList<Integer>();
        int i = 0, right = 0, left = 0;

        while(right < n){
            if(q.isEmpty()){
                q.add(nums[left]);
            }
            else{
                while(!q.isEmpty() && q.peekLast() < nums[right]){
                    q.removeLast();
                }
                q.add(nums[right]);
            }

            if(right-left+1 < k){
                right++;
            }
            else if(right-left+1 == k){
                result[i++] = q.peekFirst();
                if(nums[left] == q.peekFirst()){
                    q.removeFirst();
                }

                left++;
                right++;
            }
        }
        

        return result; 
    }
    public static void main(String[] args) {
        deq d = new deq();
        int[] res = d.maxSlidingWindow(new int[] {1, 1, 1, 1, 1, 4, 5}, 3);
        System.out.println(Arrays.toString(res));
    }
}
