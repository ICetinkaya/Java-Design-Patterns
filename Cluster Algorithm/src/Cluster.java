import java.io.File;
import java.io.FileNotFoundException;
import java.lang.String;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public abstract class Cluster {
	String description;
	ArrayList<Coordinate> coordinates = new ArrayList<Coordinate>();
	List<Coordinate> dataCentroidList = new ArrayList<Coordinate>();
	Cluster() {
	}
	public void templateMethod()
	{
		loadData();
		initializeCluster();
		implementClustering();
		printOutCluster();
	}
	public void loadData(){
		File file = new File("data");
		int x,y,z;
		String line;
		String[] lineArray;		
	    try {
	    	Scanner scanner = new Scanner(file);
	        while (scanner.hasNextLine()) {
	        	line = scanner.nextLine();
		    	lineArray = line.split(", ");
		    	x = Integer.parseInt(lineArray[0]);
		    	y = Integer.parseInt(lineArray[1]);
		    	z = Integer.parseInt(lineArray[2]);
		    	//System.out.println(" x " + x +" y " + y + " z " + z);
		    	coordinates.add(new Coordinate(x,y,z));
	        }
	        scanner.close();
	    } 
	    catch (FileNotFoundException e) {
	        e.printStackTrace();
	    }
	}
	abstract void initializeCluster();
	abstract void implementClustering();
	public void printOutCluster(){
		System.out.print("For" + this.description);
		for(int i = 0; i < dataCentroidList.size(); i++ ){
			System.out.print(" [ "+dataCentroidList.get(i).x +","+ dataCentroidList.get(i).y +","+
					dataCentroidList.get(i).z +" ]");
		}
		System.out.print("\n");
	}

}
