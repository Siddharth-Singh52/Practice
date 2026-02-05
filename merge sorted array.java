class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1; // valid numbers in nums1
        int j = n - 1; // valid numbers in nums2
        int k = nums1.length - 1; // last index of nums1

        while(i >= 0 && j >= 0){
            if(nums1[i] > nums2[j]){
                nums1[k] = nums1[i];
                k--;
                i--;
            }
            else {
                nums1[k] = nums2[j];
                k--;
                j--;
            }
        }
        // if some elements is left in nums2
        while(j >= 0){
            nums1[k] = nums2[j];
            j--;
            k--;
        }
    }
