package com.example.demo.pass.algorithm.recursion;

// 17965 幸运之星 数学
/*Description
        每年新年派对的最后一个节目就是选出下年的“幸运之星”，有丰厚的大礼包的噢~~。  O(∩_∩)O 所以每位参加派对的人士都摩拳擦掌跃跃欲试。选择的办法是这样约定的：

        （1）所有参与的人员数n，让n个人一字排开，然后至左向右从1开始报数，凡报到奇数号的全部后退剔除，剩下的人员，又至左向右报数，逢奇剔除，如此不断的递归下去，直至只有一个人为止
        这个人就是“幸运之星”。

        （2）所有参与的人员数n，先随机抽取一个m值（从黑暗小箱中随机摸一个，m可能比n小或相等，也可能大于n），所有 参与的人员列成环形，然后从位置1开始报数，凡报到m的倍数的人后退剔除
        剩下的人员，从刚才位置继续报数，逢m的 倍数的人剔除，如此不断的递归下去，直至只有一个人为止，这个人就是“幸运之星”。 如：n=8,m=4，如下图所示，幸 运之星为6号。

        现在，请你分析上面两种节目方式，若想获得幸运大礼包，应该选哪个初始编号的位置来站？注意此题设置的时限很短，也就不建议你采用队列或循环列表去模拟这个剔除的
        过程而得到最后的解答。这里，我们更应 该分析一下，这个问题的递归思路。有了分析的递归公式，就可以在很短时间内完成“幸运之星”的计算。

        输入格式    输入：n和m（m只和第二个问题有关，与第一个问题无关）。    n和m的范围：n,m <1000000。

        输出格式    输出：幸运之星游戏未开始剔除之前的最初的编号。（1）题和（2）题的解，中间空格相连。

        输入样例            输出样例
        8 4                 8 6

        提示
        此题不要用递归来写，因为n,m <1000000，递归深度若和n有关的话，这么深的递归是无法执行的，递归栈要爆了。
        因此，第（1）问和第（2）问都尽量避免用递归过程，而要想方设法推导出“递推公式”，由递推公式直接计算得到。

        （1）我们把“幸运之星”的初始编号定为J(n)。我们初写如下几个J(n)：
        n      1    2    3    4    5    6    7    8    9    10  …
        ------------------------------------------------------------
        J(n)   1    2    2    4    4    4    4    8    8     8  …


        把n分奇偶来讨论：即n=2k时的J(2k)和n=2k+1的J(2k+1)来探讨。
        1）当n=2k时，所有奇数都删去，剩下的偶数 2 4 … 2k又重新形成和之前类似的一字型排开队列，只是编号加倍。   所以J(2k)=2J(k)；
        2）当n=2k+1时，所有的奇数都删去了，剩下的偶数和上面是相同的：2 4 … 2k，也只是编号加倍。                 所以J(2k+1)=2J(k)；
        3）当n=1时，J(1)=1。

        递归关系清晰，这个递归式是非常有效的，因为每次应用此递归式时，n都可以大致减半，大约递 归19次，就能计算到J(1 000 000)了，现在你可以编程实现了吧。

        这个问题是寻找“幸运之星”编号，如果你很想中奖，那脑子就得快速计算最有利的位置，所以还希望找 出J(n)的一般闭形式，毕竟没有太多时间递归计算。
        把n表示成 n = 2^p + q，其中2^p是指不超过n 的2的最大幂，q是余量。递归式的闭形式解：J(n) = J(2^p + q) = 2^p    J(1)=1。



        （2）这里的m指的是：逢m的倍数的人剔除。且参与人员是环形的。我们把“幸运之星”的初始编号定为J(n)，
        题目上的图的例子就是m=4，J(8)=6。我们需要考虑，某个人剔除前和剔除后的编号对应关系。
        如题中图（n=8,m=4）为例说明：在图（a）中，第一个人n4剔除，那n5即视为1，重新开始n-1个人的幸
        运之星游戏。更一般的，由于第一个人编号是从1开始而非0开始，所以第一个剔除的人编号为 (m-1)%n+1，
        剩下n-1个人重新组成一个环形，只是这时候从m%n+1开始。 在 (m-1)%n+1被剔除前和剔除后，其余人的
        编号形成这样的映射：

        剔除前编号      剔除了(m-1)%n+1   剔除后编号
        (m)%n+1               ---               1
        (m+1)%n+1             ---               2
        ...                                ...
        (m-3)%n+1             ---              n-2
        (m-2)%n+1             ---              n-1

        也可以反过来说，这里n-1长环的元素编号和n长环的元素编号之间的映射关系是：
        Index(n) = (Index(n-1)+m-1)%n + 1
        继续下一步剔除，将变成n-2长的环，他们之间的关系则是Index(n-1) = (Index(n-2)+m-1)%(n-1) + 1。 ……。
        一直剔除下去，最后肯定是只有一个元素（这就是“幸运之星”），这个元素对应编号为1，也就是Index(1) =1。
        那它的上一级环2个元素的编号是多少呢？按前面公式倒推回去，Index(2) = (Index(1)+m-1)%2 + 1，对应3个元
        素、4个元素的编号呢？一路倒推下去，就可以得到n个元素环的编号了，这个递推关系就是：
        Index(n) = (Index(n-1)+m-1)%n + 1        Index(1)=1。

        总结递归公式，我们把“幸运之星”的初始编号定为J(n)，也就是上面分析的Index(n)：

        1）当n=1时，J(1) = 1；
        2）当n>1时，J(n) = (J(n-1)+m-1)%n + 1。



        设下标的编号从1开始
        对于第一问，一开始我是找规律的，感觉太渣渣了，正解真的很优美。
        设F(n)表示长度为n的序列，的答案是什么。
        考虑n是偶数，那么就是1、2、3、4、5、6、7、8.....2k
        第一步，就抽取了成为2、4、6、8.....2k
        就是长度是n/2的子问题，明显可以递归求解，但是下标不同，不过可以提取2这个公因子，所以F(n) = 2 * F(n / 2)
        考虑n是奇数，1、2、3、4、5、6、7、8.....2k+1
        然后最后一个奇数会剔除的，就也是变成了2、4、6、8.....2k的子问题，所以F(n) = 2 * F(n / 2)


        对于第二问，
        设F（n）表示长度为n的序列，每次报号是m的时候要剔除的时候的最优位置是哪一个。
        然后，第一次很容易求解出来，要删除的就是 (m - 1) % n + 1 -----------下标为1的模%法
        然后就变成了m%n+1对应报号1， (m+1)%n+1对应报号2， ..... (m + n - 2)%n + 1对应报号n - 1的，长度是n-1的子问题。
        关键是她们的长度可以递归，但是id不同，
        因为我们设了F(n)是求解长度是n的时候的最优位置，那么把右边映射回来左边也不是难事。
        F(1) = 1
        F(n) = (m - 1 + F(n - 1)) % n + 1*/


public class T_17965 {

    public static int getAns(int n){
        if(n==1)return  1;
        int ans=2;
        int t=2;
        while(t<=n){
            ans=t;
            t*=2;
        }
        return ans;
    }

    public static int getAns2(int n,int m){
        if(n==1)return  1;
        int[] ans=new int[n];
        ans[0]=1;
        for(int i=1;i<n;i++){
            ans[i]=(ans[i-1]+m-1)%(i+1)-1;
        }

        return ans[n-1];
    }
}