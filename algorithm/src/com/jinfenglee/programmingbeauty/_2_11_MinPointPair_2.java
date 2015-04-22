package com.jinfenglee.programmingbeauty;

import java.util.Arrays;

/**
 * ʹ�÷��η�����Ѱ������ĵ��
 * ˼·�����ڣ�http://www.cnblogs.com/kkgreen/archive/2011/06/12/2078668.html
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

	        Arrays.sort(Points);//����x��������Ե�Ԥ����,n*log(n)�ĸ��Ӷ�
	        
	        Point[] result = new Point[2];
	        result = getNearestPoints(Points);
	        System.out.println("�������������������ǣ� ");
	        //System.out.println(result[0].x);
	        for (int i = 0; i < result.length; i++)
	            System.out.print("(" + result[i].x + "," + result[i].y + ")   ");
	}
	
	public static Point[] getNearestPoints(Point[] Points) {
        //��һ�������������ҵ�����������㣬��������������
        Point[] result = new Point[2];
        if (Points.length == 3 || Points.length == 2) //�ݹ����������
            result = getNear(Points);
        else //����3���㣬���Σ��ֱ��ҳ������Ӽ��ϵ������ԣ�Ȼ��ϲ����
        {
            Point[] left = Arrays.copyOfRange(Points, 0, Points.length / 2);// ���һ���±겻����
            Point[] right = Arrays.copyOfRange(Points, Points.length / 2, Points.length);
            
            //�õ�2���Ӽ�����ֱ���̾����2����
            Point[] result1 = getNearestPoints(left);
            Point[] result2 = getNearestPoints(right);

            double d1 = dPoints(result1[0], result1[1]);
            double d2 = dPoints(result2[0], result2[1]);

            //���˽�result��ֵ
            if (d1 <= d2)
                result = result1;
            else
                result = result2;
            
            //�ϲ�������ҵ�ȫ�־�����̵������� 
            double dmin = Math.min(d1, d2);

            int x1 = left.length - 1;//����x�ķֽ��
            int x2 = x1 + 1;
            //��Points.length/2��һ������ʱ�Ǵ����
            //int x1 = Points[Points.length/2 - 1].x;//����x�ķֽ��
            //int x2 = Points[Points.length/2].x;

            for (int i = x1; i >= 0; i--) {
                //if(x2 - Points[i].x > dmin)        //ֱ�ӵ��µ��Ժܾö���֪�������ģ�
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
	 * ���ؽ���2�������������ĵ������о�����С��������
	 * �������ֱ�ӷ��أ�������ͼ���ÿ������֮�ҵľ��룬Ȼ�󷵻ؾ�����С��������.
	 * 
	 * @param Points 2��3����
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
	 * ���������������֮��ľ���
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
class Point implements Comparable { //��ά����ĵ�
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
