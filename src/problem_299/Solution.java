package problem_299;

import java.util.Arrays;

public class Solution {
    public String getHint(String secret,String guess){
            char[] sArr=secret.toCharArray();
            char[] gArr=guess.toCharArray();
            int[] sMap=new int[256];
            int[] gMap=new int[256];
            int A=0,B=0;
            for(int i=0;i<sArr.length;i++){
                if (sArr[i]==gArr[i])
                    A++;
                sMap[sArr[i]]++;
                gMap[gArr[i]]++;
            }
            for (int i=0;i<sMap.length;i++){
                B+=Math.min(sMap[i],gMap[i]);
            }
            return A+"A"+(B-A)+"B";
    }
//    public String getHint(String secret, String guess) {
//            char[] sArr=secret.toCharArray();
//            char[] gArr=guess.toCharArray();
//            int A=0,B=0;
//            for(int i=0;i<sArr.length;i++){
//                if (sArr[i]==gArr[i])
//                    A++;
//            }
//        Arrays.sort(sArr);
//        Arrays.sort(gArr);
//        int i=0,j=0;
//        while (j<gArr.length&&i<sArr.length){
//            if (sArr[i]==gArr[j]) {
//                B++;
//                i++;
//                j++;
//            }
//            else{
//                if (sArr[i]<gArr[j])
//                    i++;
//                else
//                    j++;
//            }
//        }
//        return A+"A"+(B-A)+"B";
//    }

    public static void main(String[] args) {
        String res=new Solution().getHint("1807","7810");
        System.out.println(res);
    }
}
