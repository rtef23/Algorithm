package StringNArray;

import java.awt.Point;
import java.util.ArrayList;

public class setZero {
	public void setZero(int arr[][], int m, int n){
		ArrayList<Point> zeroPos = new ArrayList<>();
		
		for(int y = 0;y < m;y++){
			for(int x = 0;x < n;x++){
				if(arr[y][x] == 0){
					zeroPos.add(new Point(x, y));
				}
			}
		}
		
		for(Point p : zeroPos){
			for(int i = 0;i < m;i++)
				arr[i][p.x] = 0;
			for(int i = 0;i < n;i++)
				arr[p.y][i] = 0;
				
		}
	}
}
