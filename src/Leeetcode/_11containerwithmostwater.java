package Leeetcode;

public class _11containerwithmostwater {
    public static int lc11(int[] height){
        int res = 0;
        int l = 0; //left
        int r = height.length - 1; //right

        while(l < r){
            res = Math.max(res, Math.min(height[l], height[r]) * (r - l));
            if(height[l] < height[r]){ //important 誰小誰走一步
                l++;
            } else {
                r--;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] heights = {1,8,6,2,5,4,8,3,7};
        System.out.println(lc11(heights));
    }
}
