class Solution {
    public int maximumSum(int[] arr) {
        int oneDelete = 0; // where one element deletion is allowed
        int noDelete = arr[0]; // standard kadane's
        int res = arr[0];

        for(int i = 1; i < arr.length; i++){
            int a = oneDelete + arr[i];
            int b = noDelete + arr[i];
            int c = arr[i];

            // Either:
            // 1) Continue after previous deletion (a)
            // 2) Delete current element (take previous noDelete)
            oneDelete = Math.max(a, noDelete);

            noDelete = Math.max(b, c);

            int element = Math.max(oneDelete, noDelete);

            res = Math.max(res, element);
        }

        return res;
    }
}
