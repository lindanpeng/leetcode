package problem_306;

public class Solution {
    public boolean isAdditiveNumber(String num) {
        if (num.length()<=0)
            return true;
        long a,b,c;
        for(int i=0;i<num.length();i++){
            for (int j=i+1;j<num.length();j++){
                try {
                    a=getNum(num.substring(0,i+1));
                    b=getNum(num.substring(i+1,j+1));
                    c=a+b;
                    String resStr=String.valueOf(c);
                    if (num.length()>j&&num.substring(j+1).startsWith(resStr)){
                        if (j+1+resStr.length()>=num.length()||isAdditiveNumber(num.substring(i+1)))
                            return true;
                        break;
                    }
                }catch (NumberFormatException e){
                    continue;
                }
            }
        }
        return false;
    }
    public long getNum(String str){
        if (str.startsWith("0")&&str.length()>1)
            throw new NumberFormatException();
        long res=Long.valueOf(str);
        return res;
    }

    public static void main(String[] args) {
        boolean res=new Solution().isAdditiveNumber("101010");
        System.out.println(res);
    }
}
