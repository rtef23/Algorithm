package AssignRoom;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class MainPro11000 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		
		int n = scan.nextInt();
		ArrayList<Point> time_table = new ArrayList<>();

		for(int i = 0;i < n;i++){
			time_table.add(new Point(scan.nextInt(), scan.nextInt()));
		}
		
		scan.close();
		
		System.out.println(countRoom(n, time_table));
	}
	public static int countRoom(int n, ArrayList<Point> time_table){
		int assigned_room_index = -1;
		int rooms[] = new int[n];
		
		time_table.sort(new Comparator<Point>() {
			@Override
			public int compare(Point o1, Point o2) {
				// TODO Auto-generated method stub
				return (o1.x < o2.x)?-1:(o1.x == o2.x)?0:1;
			}
		});

		for(int i = 0;i < n;i++){
			int finded_assign_room = -1;
			
			for(int j = 0;j <= assigned_room_index;j++){
				if(time_table.get(i).x >= rooms[j]){
					finded_assign_room = j;
					break;
				}
			}
			if(finded_assign_room < 0){
				assigned_room_index++;
				rooms[assigned_room_index] = time_table.get(i).y;
			}else{
				rooms[finded_assign_room] = time_table.get(i).y;
			}
		}
		
		return assigned_room_index + 1;
	}
}
