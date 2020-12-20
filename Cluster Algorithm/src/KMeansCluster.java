import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
public class KMeansCluster extends Cluster {
	List<List<Coordinate>> dataList = new ArrayList<List<Coordinate>>();
	ArrayList<Coordinate> centroidList = new ArrayList<Coordinate>();
	private Random rand = new Random();
	private int centroidSize;
	private Coordinate state = new Coordinate(1,1,1);
	public KMeansCluster(){
		this.description = "kmeans";
	}
	
	@Override
	void initializeCluster() {
		// TODO Auto-generated method stub
		System.out.println("K means enter the parameter(k,distance function code) : ");
		Scanner scanner = new Scanner(System.in);
		centroidSize = scanner.nextInt();
		System.out.println(centroidSize);
		for(int i = 0 ; i< centroidSize; i++){
			List<Coordinate> arr = new ArrayList<Coordinate>();  
			dataList.add(arr);			
			int x = rand.nextInt(256);
			int y = rand.nextInt(256); 
			int z = rand.nextInt(256);
			centroidList.add(new Coordinate(x,y,z));
			System.out.println("random x " + x + " random y " + y + " random z " + z );
		}
	}

	@Override
	void implementClustering() {
		boolean check = false;
		while(check == false){
			for(int i = 0; i< this.coordinates.size() ; i++)
			{
				int index = checkDistance(this.coordinates.get(i));
				dataList.get(index).add(this.coordinates.get(i));
			}
			
			for(int i = 0; i< dataList.size() ; i++)
			{
				
				Coordinate coorM = this.centroidChange((ArrayList<Coordinate>) dataList.get(i));
				state.x =  coorM.x - centroidList.get(i).x;
				state.y = coorM.y - centroidList.get(i).y;
				state.z = coorM.z - centroidList.get(i).z;				
				if(state.x == 0 && state.y == 0 && state.z == 0){
					check = true;					
					//continue;
				}
				else{					
					centroidList.set(i, coorM);					
					check = false;
				}
					
			}
			for(int i = 0; i< dataList.size() ; i++)
			{
				dataList.get(i).clear();
			}
		}
		
		for(int i = 0; i< centroidList.size() ; i++)
		{
			this.dataCentroidList.add(centroidList.get(i) );
		}
	
		
	}
	public double EuclideanDistanceTwoPoints(Coordinate coor1,Coordinate coor2){
		int x = Math.abs(coor1.x - coor2.x);
		int y = Math.abs(coor1.y - coor2.y);
		int z = Math.abs(coor1.z - coor2.z);
		
		double total = Math.sqrt( Math.pow(x,2) + Math.pow(y,2) + Math.pow(z,2) );
		return total;
	}
	
	public int checkDistance(Coordinate point){
		int index = 0;
		int i;
		ArrayList<Double> distanceTotalList = new  ArrayList<Double>();
		ArrayList<Double> tempList = new  ArrayList<Double>();
		for(i = 0; i< centroidList.size() ; i++){
			double temp = EuclideanDistanceTwoPoints(point,centroidList.get(i));
			distanceTotalList.add(temp);
			tempList.add(temp);
		}
		Collections.sort(distanceTotalList);
		for( i = 0; i< distanceTotalList.size() ; i++){
			if( tempList.get(i).equals(distanceTotalList.get(0)) ){
				index = i;
				break;
			}
		}
		return index;
	}
	public Coordinate centroidChange(ArrayList<Coordinate> array){
		int totalX = 0,totalY = 0,totalZ = 0;
		for(int i = 0; i < array.size() ; i++){
			totalX += array.get(i).x;
			totalY += array.get(i).y;
			totalZ += array.get(i).z;
		}
		if( array.size() > 0){
			totalX = totalX / array.size();
			totalY = totalY / array.size();
			totalZ = totalZ / array.size();
		}
		return new Coordinate(totalX,totalY,totalZ);
	}
	
}
