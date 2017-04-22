package SecretCamera;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class MainPro10060 {
	private static final String impossible = "impossible";
	private static final int Impossible = -1;
	private static final int MaximumLeft = 0;
	private static final int MinimumRight = 1;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int n, k;
		int cameraInfo[][]; 
		
		n = scan.nextInt();
		k = scan.nextInt();
		
		cameraInfo = new int[k][2];
		
		for(int i = 0;i < k;i++){
			cameraInfo[i][0] = scan.nextInt();
			cameraInfo[i][1] = scan.nextInt();
		}

		int res = countMinCamera(n, k, cameraInfo);
		if(res == Impossible){
			System.out.println(impossible);
		}else{
			System.out.println(res);
		}
		
		scan.close();
	}
	public static int countMinCamera(int n, int k, int cameraInfo[][]){
		ArrayList<HashMap<Integer, Integer>> room_state = new ArrayList<>();
		
		for(int i = 0;i < k;i++){
			if(canBeSuveil(1, cameraInfo[i], n)){
				HashMap<Integer, Integer> tmp = new HashMap<>();
				if(cameraInfo[i][0] <= cameraInfo[i][1]){
					tmp.put(MaximumLeft, cameraInfo[i][1]);
					tmp.put(MinimumRight, n + 1);					
				}else{
					tmp.put(MaximumLeft, cameraInfo[i][1]);
					tmp.put(MinimumRight, cameraInfo[i][0]);
				}
				room_state.add(tmp);
			}
		}
		if(room_state.isEmpty()){
			return Impossible;
		}
		
		int res = F(n, k, room_state, new ArrayList<>(), cameraInfo, 1);
		return (res == Impossible)?Impossible:res + 1;
	}
	public static int F(int n, int k, ArrayList<HashMap<Integer, Integer>>odd_room_state, ArrayList<HashMap<Integer, Integer>>even_room_state, int cameraInfo[][], int depth){
		//BFS
		int min = k;
		ArrayList<HashMap<Integer, Integer>>room_state = (depth % 2 == 0)?even_room_state:odd_room_state;
		ArrayList<HashMap<Integer, Integer>>another_state = (depth % 2 == 0)?odd_room_state:even_room_state;
		
		for(int i = 0;i < room_state.size();i++){
			HashMap<Integer, Integer>target_state = room_state.get(i);
			int target_room_number = (target_state.get(MaximumLeft) + 1);
			boolean isThereSuveilCamera = false;
			
			for(int j = 0;j < k;j++){
				if(canBeSuveil(target_room_number, cameraInfo[j], min)){
					isThereSuveilCamera = true;
					HashMap<Integer, Integer>tmp = new HashMap<>();
					if(cameraInfo[j][0] <= cameraInfo[j][1]){
						tmp.put(MaximumLeft, max(cameraInfo[j][1], target_state.get(MaximumLeft)));
						tmp.put(MinimumRight, target_state.get(MinimumRight));
					}else{
						tmp.put(MaximumLeft, max(cameraInfo[j][1], target_state.get(MaximumLeft)));
						tmp.put(MinimumRight, min(cameraInfo[j][0], target_state.get(MinimumRight)));
					}
				
					if(tmp.get(MaximumLeft) >= tmp.get(MinimumRight) || (tmp.get(MaximumLeft) >= n) || (tmp.get(MinimumRight) <= 1)){
						return depth;
					}
					another_state.add(tmp);
				}
			}
			if(!isThereSuveilCamera){
				return Impossible;
			}
		}

		while(!room_state.isEmpty()){
			room_state.remove(0);
		}
		return F(n, k, odd_room_state, even_room_state, cameraInfo, depth+1);
	}
	
	
	public static boolean canBeSuveil(int room_num, int cameraInfo[], int n){
		if(cameraInfo[0] <= cameraInfo[1]){
			return (cameraInfo[0] <= room_num && room_num <= cameraInfo[1])?true:false;
		}else{//ai > bi
			return ((1 <= room_num && room_num <= cameraInfo[1]) || (cameraInfo[0] <= room_num && room_num <= n))?true:false;
		}
	}
	private static int min(int a, int b){
		return (a < b)?a:b;
	}
	private static int max(int a, int b){
		return (a < b)?b:a;
	}
}
