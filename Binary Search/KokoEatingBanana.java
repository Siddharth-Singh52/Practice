class Solution {

    long fun(int[] piles, int speed){
        long time = 0;

        for(int i = 0; i < piles.length; i++){
            time += piles[i]/speed; // time to eat the banana

            if(piles[i]%speed != 0){ // extra time to eat leftover banana
                time++;
            }
        }
        return time;
    }

    public int minEatingSpeed(int[] piles, int h) {
        int low = 1;
        int high = 0;
        for(int i = 0; i < piles.length; i++){
            high = Math.max(high, piles[i]);
        }

        int res = -1;

        while(low <= high){
            int mid = low+(high-low)/2;

            long hour = fun(piles, mid);
            if(hour > h){
                low = mid+1;
            }
            else{
                res = mid;
                high = mid-1;
            }
        }
        return res;
    }
}
