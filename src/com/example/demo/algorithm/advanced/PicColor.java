package com.example.demo.algorithm.advanced;

public class PicColor {
}

/*
import java.util.*;
public class mzhuose {

	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		int [][] a=new int[100][100];
		int [] b=new int[100];
		System.out.println("请输入点的数目和边的数目");
		int n=in.nextInt();
		int m=in.nextInt();
		System.out.println("边的连接");
		for(int i=0;i<m;i++)
		{
			int x=in.nextInt();
			int y=in.nextInt();
			a[x][y]=1;
			a[y][x]=1;//1代表连接
		}
		int t=n;
		b[0]=100;
		trackback(a,b,m,n,t);//回溯
		System.out.println(b[0]);

	}

	private static void trackback(int[][] a, int[] b, int m, int n,int t) {
		int tmp=n;
		int state=0,i,j;
		if(tmp<=0)
		{
			int temp=b[1];
			for(int r=1;r<=t;r++)
			{
				if(temp<b[r])
					temp=b[r];

			}
			if(temp<b[0])//b[0]代表最小的颜色,temp代表此次的颜色种数
				b[0]=temp;
			return ;
		}
		for( i=1;i<=t;i++)//颜色
		{
			state=0;
			b[tmp]=i;
			for( j=1;j<=t;j++)//边的连接
			{

				if(a[tmp][j]==1&&b[j]!=b[tmp])
				{
					continue;//trackback(a,b,m,n-1,t);
				}
				else if(b[j]==b[tmp]&&a[tmp][j]==1)
				{
					if(j==tmp)//如果是本身与自身的连接那么不管
						continue;
					state=1;
					break;
				}
			}
			if(state!=1)
			{

				trackback(a,b,m,n-1,t);
			}
		}

	}

}

 */
