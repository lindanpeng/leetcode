package problem_79;

import java.awt.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    //从第i行第j列开始查找是否存在匹配word的路径
    private int[][] mark;
    public boolean exist(char[][] board,String word,int i,int j){

        if (i>=board.length||j>=board[0].length||i<0||j<0||mark[i][j]==1)
            return false;
        if (board[i][j]!=word.charAt(0))
            return false;
        mark[i][j]=1;
        if (word.length()>1){
            String subWord=word.substring(1);
            boolean result= exist(board,subWord,i+1,j)||
                    exist(board,subWord,i-1,j)||
                    exist(board,subWord,i,j+1)||
                    exist(board,subWord,i,j-1);
            mark[i][j]=0;
            return result;
        }else{
            return true;
        }
    }
    public boolean exist(char[][] board, String word) {
        mark=new int[board.length][board[0].length];
        for (int i=0;i<board.length;i++){
            for (int j=0;j<board[0].length;j++){

                if (exist(board,word,i,j))
                    return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        char a='ź';
        a^=256;
        System.out.println(a);
    }
}
