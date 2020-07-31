package com.example.demo.ol;

//dp
public class Title1 {

    public static int dp(int[] m,int[] c,int n){
        int[][] dp=new int[m.length][n+1];
        int[][] rc=new int[m.length][n+1];

        for(int i=0;i<n;i++)dp[0][i]=0;

        for(int i=0;i<m.length;i++){
            for(int j=1;j<=n;j++){
                int k=1;
                while(k<=c[i] && m[i]*(k-1)<j){
                    k++;
                }

                if(k-1>=1) {
                    if(i>=1){
                        dp[i][j] = dp[i - 1][j-m[i] * (k - 1)] + m[i] * (k - 1);
                        rc[i][j] = rc[i-1][j-m[i] * (k - 1)]+k-1;
                    }else{
                        dp[i][j]=m[i] * (k - 1);
                        rc[i][j]=k-1;
                    }

                }else{
                    if(i>=1){
                        dp[i][j]=dp[i-1][j];
                        rc[i][j]=rc[i-1][j];
                    }else{
                        dp[i][j]=0;
                        rc[i][j]=0;
                    }

                }
//                if(i>1 && k==0){
//                    dp[i][j]=dp[i-1][j];
//                    rc[i][j]=rc[i-1][j];
//                }else{
//                    dp[i][j]=dp[i][j-m[i]*(k-1)]+m[i]*(k-1);
//                    if(i>1){
//                        rc[i][j]=rc[i-1][j]+k-1;
//                    }else{
//                        rc[i][j]=k-1;
//                    }
//
//                }

            }
            printMartix(dp);
            printMartix(rc);
        }

        return 0;
    }


    public static void printMartix(int[][] dp){
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[i].length;j++){
                System.out.print(dp[i][j]+" ");
            }
            System.out.println("");
        }
        System.out.println("end...\n");
    }

    public static void main(String[] args) {
        int[] m={1,5,10,50,100};
        int[] c={5,2,2,3,5};
        dp(m,c,55);
    }
}
