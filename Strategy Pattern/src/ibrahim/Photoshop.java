package ibrahim;

import vpt.Image;
import vpt.algorithms.display.Display2D;
import vpt.algorithms.io.Load;

public class Photoshop {

	public static void main(String[] args) {
		 Image img = Load.invoke("lennaGray.png");
		System.out.printf("Main: \n");
		MorpholntDetection md = new MorpholntDetection();
		img = md.implementAlgorithm(img);
		Display2D.invoke(img);
		
		Image img1 = Load.invoke("lennaGray.png");
		MorphoExtDetection me = new MorphoExtDetection();
		img1 = me.implementAlgorithm(img1);
		Display2D.invoke(img1);
		
		Image img2 = Load.invoke("lennaGray.png");
		AverageAlgorithm aa = new AverageAlgorithm();
		img2 = aa.implementAlgorithm(img2);
		Display2D.invoke(img2);
		
		Image img3 = Load.invoke("lennaGray.png");
		MedianAlgorithm ma = new MedianAlgorithm();
		img3 = ma.implementAlgorithm(img3);
		Display2D.invoke(img3);
	}

}
