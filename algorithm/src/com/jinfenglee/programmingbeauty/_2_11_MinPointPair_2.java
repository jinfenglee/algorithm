package com.jinfenglee.programmingbeauty;

import java.util.Arrays;

/**
 * 使用分治法进行寻找最近的点对
 * 思路来自于：http://www.cnblogs.com/kkgreen/archive/2011/06/12/2078668.html
 * @author LJF
 *
 */
public class _2_11_MinPointPair_2 {
	public static void main(String[] args) {
		 Point[] Points = new Point[10];

	        Points[0] = new Point(3, 4);
	        Points[1] = new Point(2, 5);
	        Points[2] = new Point(3, 8);
	        Points[3] = new Point(13, 9);
	        Points[4] = new Point(7, 8);
	        Points[5] = new Point(7, 12);
	        Points[6] = new Point(90, 0);
	        Points[7] = new Point(5, 8);
	        Points[8] = new Point(7, 9);
	        Points[9] = new Point(3, 6);
	        //Points[10] = new Point(3,41);

	        Arrays.sort(Points);//按照x坐标升序对点预排序,n*log(n)的复杂度
	        
	        Point[] result = new Point[2];
	        result = getNearestPoints(Points);
	        System.out.println("输出距离最近的两个点是： ");
	        //System.out.println(result[0].x);
	        for (int i = 0; i < result.length; i++)
	            System.out.print("(" + result[i].x + "," + result[i].y + ")   ");
	}
	
	public static Point[] getNearestPoints(Point[] Points) {
        //从一个点数组里面找到最近的两个点，并返回这两个点
        Point[] result = new Point[2];
        if (Points.length == 3 || Points.length == 2) //递归结束的条件
            result = getNear(Points);
        else //多于3个点，分治，分别找出两个子集合的最近点对，然后合并结果
        {
            Point[] left = Arrays.copyOfRange(Points, 0, Points.length / 2);// 最后一个下标不包括
            Point[] right = Arrays.copyOfRange(Points, Points.length / 2, Points.length);
            
            //得到2个子集里面分别最短距离的2个点
            Point[] result1 = getNearestPoints(left);
            Point[] result2 = getNearestPoints(right);

            double d1 = dPoints(result1[0], result1[1]);
            double d2 = dPoints(result2[0], result2[1]);

            //忘了将result赋值
            if (d1 <= d2)
                result = result1;
            else
                result = result2;
            
            //合并结果：找到全局距离最短的两个点 
            double dmin = Math.min(d1, d2);

            int x1 = left.length - 1;//两个x的分界点
            int x2 = x1 + 1;
            //在Points.length/2是一个整数时是错误的
            //int x1 = Points[Points.length/2 - 1].x;//两个x的分界点
            //int x2 = Points[Points.length/2].x;

            for (int i = x1; i >= 0; i--) {
                //if(x2 - Points[i].x > dmin)        //直接导致调试很久都不知道错在哪！
                if (Points[x2].x - Points[i].x > dmin)
                    break;
                else {
                    //for(int j = Points.length/2;j < Points.length;j++)
					for (int j = x2; j < Points.length; j++) {
                        //System.out.println(Points[j].y);
                        //if(Points[j].x - x1 > dmin)
                        if (Points[j].x - Points[x1].x > dmin)
                            break;
                        else {
                            double temp = dPoints(Points[i], Points[j]);
//                            System.out.println(temp);
                            if (temp < dmin) {
                                dmin = temp;
                                result[0] = Points[i];
                                result[1] = Points[j];
                            }
                        }
                    }
                }// end else
            }
        }

        return result;
    }
	
	/**
	 * 返回仅有2个点或者三个点的点数组中距离最小的两个点
	 * 两个点就直接返回，三个点就计算每两个点之家的距离，然后返回距离最小的两个点.
	 * 
	 * @param Points 2或3个点
	 * @return
	 */
    private static Point[] getNear(Point[] Points) {
        Point[] result = new Point[2];
        if (Points.length == 2) {
        	  result = Points;
        } else {
            double d1 = dPoints(Points[0], Points[1]);
            double d2 = dPoints(Points[0], Points[2]);
            double d3 = dPoints(Points[1], Points[2]);

            if (d1 <= d2 && d1 <= d3) {
                result[0] = Points[0];
                result[1] = Points[1];
            } else if (d2 <= d3) {
                result[0] = Points[0];
                result[1] = Points[2];
            } else {
                result[0] = Points[1];
                result[1] = Points[2];
            }
        }
        return result;
    }

	/**
	 * 坐标轴上两个点对之间的距离
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
	private static double dPoints(Point a, Point b) {
		return Math.pow(Math.pow(a.x - b.x, 2) + Math.pow(a.y - b.y, 2), 0.5);
	}
}

@SuppressWarnings("rawtypes")
class Point implements Comparable { //二维数组的点
    public int x;
    public int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int compareTo(Object o) {
        // TODO Auto-generated method stub
        Point obj = (Point) o;
        if (this.x < obj.x)
            return -1;
        else if (this.x > obj.x)
            return 1;
        return 0;
    }
}
