/**
 * FileName: Sum
 * Author:   Lixiaopeng
 * Date:     2019/9/24 13:43
 * Description:
 */
package atomic;

public class Sum {

    public int[] sum (int[] nums,int tager){

        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if(nums[i] == tager - nums[j]){
                    int [] s = {i,j};
                    return s;
                }
            }
        }
        return null;
    }

    public static void main(String[] args){
        int [] s = {2,3,4,7};
        int ss = 9;
        Sum sum = new Sum();
        int[] sum1 = sum.sum(s, ss);
        for (int i : sum1) {
            System.out.println(i);
        }
    }

}
