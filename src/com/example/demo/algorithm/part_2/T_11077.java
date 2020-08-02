package com.example.demo.algorithm.part_2;


import javax.xml.bind.SchemaOutputResolver;

// 11077 最长公共子字符串 dp
/*Description
        求两个输入序列的最长的公共子字符串的长度。子字符串中的所有字符在源字符串中必须相邻。
        如字符串：21232523311324和字符串312123223445，他们的最长公共子字符串为21232，长度为5。

        输入格式    两行，第一行为第一个字符串X，第二行为第二个字符串Y，字符串不含空格并以回车标示结束。X和Y的串长都不超过100000。

        输出格式    两行，第一行为最长的公共子字符串的长度，第二行输出一个最长的公共子字符串。

        说明：
        (1)若最长的公共子字符串有多个，请输出在源字符串X中靠左的那个。
        (2)若最长公共子字符串的长度为0，请输出空串(一个回车符)。

        如输入：                    由于523和123都是最长的公共子字符串，但123在源串X中更靠左，因此输出：
        21232523311324                  3
        152341231                       123

        输入样例                    输出样例
        21232523311324              5
        312123223445                21232

        分析：
        最长公共子字符串必须是连续的。如果我们使用递归的方法解决的话，对于每一对字符就需要判断前面的是否已构成字串，这就会使子问题出现重复计算的问题。对于重复子问题，还是要使用动态规划的思想。
        假设需要求的字符串为 str1 , str2 .函数 f(m,n) 求分别以str1[m] , str2[n] 结尾的公共字符串长度。
        这有一下递推公式：
        f(m,n)=0        str1[m] != str2[n] ;
        f(m,n)=f(m-1,n-1) + 1      str[m]==str2[n];

        别忘了递推的特殊边界:
        f(0,n)=0;
        f(m,0)=0;
  */
public class T_11077 {

    public static void getInt(String str1,String str2){
        int[][] rc=new int[str1.length()][str2.length()];
        int end=0;
        int len=0;
        for(int i=0;i<str1.length();i++){
            for(int j=0;j<str2.length();j++){

                if(str1.charAt(i)==str2.charAt(j)){
                    if(i==0 || j==0){
                        rc[i][j]=1;
                    }else{
                        rc[i][j]=rc[i-1][j-1]+1;
                    }

                }else{
                    rc[i][j]=0;
                }
                if(rc[i][j]>len){
                    len=rc[i][j];
                    end=i;
                }
            }
        }

        System.out.println(len+" "+end);
        System.out.println(str1.substring(end-len+1,end+1));
    }

    public static void main(String[] args) {
        String str1="21232523311324";
        String str2="152341231";
        getInt(str1,str2);

    }
}
