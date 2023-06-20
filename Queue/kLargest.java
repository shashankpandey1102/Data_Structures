package Queue;
import java.util.*;


public class kLargest {
    public static List<List<Integer>> findSubArray(List<Integer> arr, int start, int end){
        List<List<Integer>> res = new ArrayList<>();

        for(int i = start; i < end; i++){
            for(int j = i; j < end; j++){
                List<Integer> temp = new ArrayList<>();
                for(int k = i; k <= j; k++){
                    
                    temp.add(arr.get(k));
                }
                res.add(temp);
            }
        }

        return res;
    }

    public static List<Integer> findSubArraySum(List<List<Integer>> sub) {
        List<Integer> res = new ArrayList<>();

        for(int i = 0; i < sub.size(); i++){
            List<Integer> temp = new ArrayList<>();
            temp = sub.get(i);

            int sum = 0;
            for(int j = 0; j < temp.size(); j++){
                sum += temp.get(j);
            }
            res.add(sum);
        }

        return res;
    }

    public static int findKthLargestElement(List<Integer> sum, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for(int i = 0; i < sum.size(); i++){
            pq.add(sum.get(i));
        }

        int kLargest = 0;
        for(int i = 0; i < k; i++){
            kLargest = pq.poll();
        }

        return kLargest;
    }

    public static int findKthLargest(int N, int K, List<Integer> A) {
        List<List<Integer>> subArray = findSubArray(A, 0, N);
        List<Integer> subArraySum = findSubArraySum(subArray);
        int kthLargestSum = findKthLargestElement(subArraySum, K);

        return kthLargestSum;
    }
    public static void main(String[] args) {
        List<Integer> arr = new ArrayList<>(Arrays.asList(2, 3));
        int N = arr.size();
        int k = 3;

        int res = findKthLargest(N, k, arr);
        System.out.println(res);
    }
}
