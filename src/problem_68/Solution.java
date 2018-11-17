package problem_68;

import javafx.collections.transformation.SortedList;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> list=new ArrayList<>();
        int cnt=0;//StringBuilder包含单词的数量
        int nowLength=0;
        int start=0;
        for (int i=0;i<words.length;i++){
            if (nowLength+words[i].length()<=maxWidth) {
                nowLength+=words[i].length()+1;
                cnt++;
            }
            else{
                int temp=maxWidth-nowLength+cnt;
                int a=cnt-1>0?temp/(cnt-1):temp;
                int b=cnt-1>0?temp%(cnt-1):0;
                StringBuilder sb=new StringBuilder();
                StringBuilder blank=new StringBuilder();
                for (int k=0;k<a;k++)
                    blank.append(" ");
                for (int j=start;j<i;j++){
                    sb.append(words[j]+(j==i-1&&cnt>1?"":blank.toString())+(b-->0?" ":""));
                }

                list.add(sb.toString());
                cnt=0;
                start=i;
                nowLength=0;
                i--;
            }
        }
        StringBuilder stringBuilder=new StringBuilder();
        for(int j=start;j<words.length;j++){
            stringBuilder.append(words[j]+(j==words.length-1?"":" "));
        }
        while (stringBuilder.length()<maxWidth)
            stringBuilder.append(" ");
        list.add(stringBuilder.toString());
        return  list;
    }

    public static void main(String[] args) {
        String[] words={"Listen","to","many,","speak","to   a","few.  "};
        int l=6;
        List<String> result=new Solution().fullJustify(words,l);
        for (String str:result){
            System.out.println(str);
        }
    }
}
