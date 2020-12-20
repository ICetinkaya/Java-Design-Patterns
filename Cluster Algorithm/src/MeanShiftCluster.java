import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class MeanShiftCluster extends Cluster{
	List<List<Coordinate>> dataList = new ArrayList<List<Coordinate>>();
	
	private Scanner scanner = new Scanner(System.in);
	private Random rand = new Random();
	private int radius = 0;
	private int index = 0;
	private Coordinate state = new Coordinate(1,1,1);
	private Coordinate sphereCentroid = new Coordinate(1,1,1);
	public MeanShiftCluster(){
		this.description  = "meanshift";
	}
	@Override
	void initializeCluster() {
		System.out.println("Mean shift enter the parameter(r,distance function code) : ");
		radius = scanner.nextInt();
		sphereCentroid.x = rand.nextInt(256);
		sphereCentroid.y = rand.nextInt(256); 
		sphereCentroid.z = rand.nextInt(256);
		List<Coordinate> arr = new ArrayList<Coordinate>();  
		dataList.add(arr);
	}

	@Override
	void implementClustering() {
		boolean check = false;
		while(check == false){
			if(this.coordinates.size() > 0){
				for(int i = 0; i < this.coordinates.size() ; i++){
					if(incheckPointInSphere(this.sphereCentroid,this.coordinates.get(i)) ){
						//System.out.println(this.coordinates.get(i));
						dataList.get(this.index).add(this.coordinates.get(i));
						
					}
				}
				Coordinate coorM = this.centroidChange((ArrayList<Coordinate>) dataList.get(this.index));	
				//System.out.println(coorM.x + " " + coorM.y +" "+coorM.z  );
				state.x =  coorM.x - sphereCentroid.x;
				state.y = coorM.y - sphereCentroid.y;
				state.z = coorM.z - sphereCentroid.z;
				
				if(state.x == 0 && state.y == 0 && state.z == 0){
					check = true;
					this.dataCentroidList.add(coorM);
					//this.removeVisitedPoint((ArrayList<Coordinate>) dataList.get(this.index));
					//check = false;
				}
				else{
					sphereCentroid.x = coorM.x;
					sphereCentroid.y = coorM.y;
					sphereCentroid.z = coorM.z;
					check = false;
				}
			}	
			
		
		}
	}
	public boolean incheckPointInSphere(Coordinate sphereCentroid,Coordinate point){
		int totalX = Math.abs(point.x - sphereCentroid.x );
		int totalY = Math.abs(point.y - sphereCentroid.y );
		int totalZ = Math.abs(point.z - sphereCentroid.z );
		
		int total = (int) Math.sqrt( Math.pow(totalX, 2) + Math.pow(totalY, 2) + Math.pow(totalZ, 2) ) ;
		if(total == (this.radius))
			return true;
		else{
			return false;
		}
		
	}
	public Coordinate centroidChange(ArrayList<Coordinate> array){
		int totalX = 0,totalY = 0,totalZ = 0;
		for(int i = 0; i < array.size() ; i++){
			totalX += array.get(i).x;
			totalY += array.get(i).y;
			totalZ += array.get(i).z;
		}
		if(array.size() > 0){
			totalX = totalX / array.size();
			totalY = totalY / array.size();
			totalZ = totalZ / array.size();
		}
		return new Coordinate(totalX,totalY,totalZ);
	}
	public void removeVisitedPoint(ArrayList<Coordinate> array) {
		System.out.println("----------------------------------");
		
			for(int i = 0; i < this.coordinates.size() ; i++){
				for(int j = 0; j < array.size() ; j++){
				if(this.coordinates.get(i).x == array.get(j).x &&
					this.coordinates.get(i).y == array.get(j).y  &&
					  this.coordinates.get(i).z == array.get(j).z ){
					/*System.out.println(this.coordinates.get(j).x + "  "
							+this.coordinates.get(i).y  + " "
							 + this.coordinates.get(i).z + " " );*/
					this.coordinates.remove(i);
				}
			}
		}
		System.out.println("----------------------------------");
		System.out.println(this.coordinates.size());
		this.index++;
		List<Coordinate> arr = new ArrayList<Coordinate>(); 
		dataList.add(arr);
		sphereCentroid.x = rand.nextInt(256);
		sphereCentroid.y = rand.nextInt(256); 
		sphereCentroid.z = rand.nextInt(256);
		
	}
	
}
