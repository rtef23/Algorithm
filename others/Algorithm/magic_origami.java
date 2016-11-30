package Algorithm;

import java.awt.Point;
import java.util.Scanner;

public class magic_origami {
	/*
	 test case
	 
	 8 7
	 5
	 5 4
	 2 3
	 3 1
	 7 6
	 6 2
	 * */
	private static final int inf = -1;
	
	int max_area = inf;
	int min_area = inf;
	static Point divide_points[];
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		
		int width, height;
		int N;
		width = scan.nextInt();
		height = scan.nextInt();
		N = scan.nextInt();
		divide_points = new Point[N];
		
		for(int i = 0;i < N;i++){
			int x = scan.nextInt();
			int y = scan.nextInt();
			divide_points[i] = new Point(x, y);
		}

		Point default_points[] = new Point[4];
		
		default_points[0]=new Point(0, height);
		default_points[1]=new Point(width, height);
		default_points[2]=new Point(width, 0);
		default_points[3]=new Point(0, 0);
		
		int max_val = divideOrigami(true, default_points, 0, N);
		
		System.out.println("max origami size : " + max_val);
		
		scan.close();
	}
	public static int divideOrigami(boolean isWhite, Point points[], int divide_points_index, int N){
		/* points position
		 * p0	p1
		 * p3	p2
		 * */
		if(divide_points_index >= N)
			return getAreaSize(Math.abs(points[0].x - points[1].x), Math.abs(points[1].y - points[2].y));
		
		if(isContainPoint(points, divide_points[divide_points_index])){
			Point new_points1[] = new Point[4];//top, left
			Point new_points2[] = new Point[4];//bottom, right
			if(isWhite){
				new_points1[0] = points[0];
				new_points1[1] = points[1];
				new_points1[2] = new Point(points[2].x, divide_points[divide_points_index].y);
				new_points1[3] = new Point(points[3].x, divide_points[divide_points_index].y);

				new_points2[0] = new_points1[3];
				new_points2[1] = new_points1[2];
				new_points2[2] = points[2];
				new_points2[3] = points[3];
				
				return max(divideOrigami(false, new_points1, divide_points_index + 1, N), divideOrigami(false, new_points2, divide_points_index + 1, N));
			}else{//black origimi
				new_points1[0] = points[0];
				new_points1[1] = new Point(divide_points[divide_points_index].x, points[1].y);
				new_points1[2] = new Point(divide_points[divide_points_index].x, points[2].y);
				new_points1[3] = points[3];
				
				new_points2[0] = new_points1[1];
				new_points2[1] = points[1];
				new_points2[2] = points[2];
				new_points2[3] = new_points1[2];
				
				return max(divideOrigami(true, new_points1, divide_points_index + 1, N), divideOrigami(true, new_points2, divide_points_index + 1, N));
			}
		}else{//is not contain this point which index is divide_points_index
			return divideOrigami(isWhite, points, divide_points_index + 1, N);
		}
	}
	public static boolean isContainPoint(Point points[], Point target_p){
		return ((target_p.x >= points[0].x && target_p.x <= points[1].x) && (target_p.y >= points[2].y && target_p.y <= points[1].y));
	}
	public static int getAreaSize(int width, int height){
		return width * height;
	}
	public static int max(int a, int b){
		return (a > b)?a:b;
	}
}
