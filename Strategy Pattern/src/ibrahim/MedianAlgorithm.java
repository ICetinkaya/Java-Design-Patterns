package ibrahim;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import vpt.Image;
import vpt.algorithms.display.Display2D;
import vpt.algorithms.io.Load;

public class MedianAlgorithm implements Smoothing {

	@Override
	public Image implementAlgorithm(Image sampleImage) {
		int changingValue;
		Image newImg = sampleImage.newInstance(false);
		System.out.printf("gen %d",newImg.getXDim());
		int i =0;
		System.out.printf("yükseklik %d",newImg.getYDim());
		for(int x = 0 ; x < newImg.getXDim() ; x = x + 1){
			for(int y = 0 ; y < newImg.getYDim(); y = y + 1 ){
				if(x == 0 && y == 0){ //sol köþe
					System.out.printf("UP_left_CORNER \n");
					changingValue = upLeftCornerFillArray(x,y,sampleImage);
					newImg.setXYByte(x,y,changingValue);
					continue;
				}
				if(x == 1 && y == 0){//4x3 matrix üstsol
					changingValue = upLeftPixelFourThreeMatrix(x,y,sampleImage);
					newImg.setXYByte(x,y,changingValue);
					continue;
				}
				if(x == 0 && y == 1){
					changingValue = otherPixelMatrixLeftUp(x,y,sampleImage);
					newImg.setXYByte(x,y,changingValue);
					continue;
				}
				if(x == 0 && y == (newImg.getYDim() - 2) ){
					changingValue = otherPixelMatrixLeftDown(x,y,sampleImage);
					newImg.setXYByte(x,y,changingValue);
					continue;
				}
				if(x == (newImg.getXDim() - 1) && y == 1){
					changingValue = otherPixelMatrixRightUp(x,y,sampleImage);
					newImg.setXYByte(x,y,changingValue);
					continue;
				}
				if(x == (newImg.getXDim() - 1) && y == (newImg.getYDim() - 2)){
					changingValue = otherPixelMatrixRightDown(x,y,sampleImage);
					newImg.setXYByte(x,y,changingValue);
					continue;
				}
				if(x == 1 && y == 1){
					changingValue = innerLeftUpCorner(x,y,sampleImage);
					newImg.setXYByte(x,y,changingValue);
					continue;
				}
				if(x == 1 &&  y == (newImg.getYDim() - 2)){
					changingValue = innerLeftDownCorner(x,y,sampleImage);
					newImg.setXYByte(x,y,changingValue);
					continue;
				}
 				if(x == (newImg.getXDim() - 2) && y == 1)
				{
 					changingValue = innerRightUpCorner(x,y,sampleImage);
 					newImg.setXYByte(x,y,changingValue);
 					continue;
				}
				if(x == (newImg.getXDim() - 2) && y == (newImg.getYDim() - 2)) {
					changingValue = innerRightDownCorner(x,y,sampleImage);
					newImg.setXYByte(x,y,changingValue);
					continue;
				}
				if( (x >= 2 && x <=(newImg.getXDim() - 3)) && y == 0){//üst
					changingValue = upPixelMatrix(x,y,sampleImage);
					newImg.setXYByte(x,y,changingValue);
					continue;
				}
				if( (x >= 2 && x <=(newImg.getXDim() - 3)) && y == 1){//üst iç
					changingValue = innerUpPixelMatrix(x,y,sampleImage);
					newImg.setXYByte(x,y,changingValue);
					continue;
				}
				if(x == 0 && y == (newImg.getYDim() - 1)) {
					changingValue = leftDownKornerFillArray(x,y,sampleImage);
					newImg.setXYByte(x,y,changingValue);
					continue;
				}
				if(x == 1 && y == (newImg.getYDim() - 1)) {
					changingValue = leftDownPixelFourThreeMatrix(x,y,sampleImage);
					newImg.setXYByte(x,y,changingValue);
					continue;
				}
				if(x == (newImg.getXDim() - 1)  && y == 0) {
					changingValue = rightUpKornerFillArray(x,y,sampleImage);
					newImg.setXYByte(x,y,changingValue);
					continue;
				}
				if(x == (newImg.getXDim() - 2)  && y == 0) {//4x3 matrix üst sað
					changingValue = upRightPixelFourThreeMatrix(x,y,sampleImage);
					newImg.setXYByte(x,y,changingValue);
					continue;
				}
				if(x == (newImg.getXDim() - 1) && y == (newImg.getYDim() - 1)) {
					changingValue = rightDownKornerFillArray(x,y,sampleImage);
					newImg.setXYByte(x,y,changingValue);
					continue;
				}
				if(x == (newImg.getXDim() - 2)  && y == (newImg.getYDim() - 1))  {//4x3 matrix alt sað
					changingValue = rightDownPixelFourThreeMatrix(x,y,sampleImage);
					newImg.setXYByte(x,y,changingValue);
					continue;
				}
				if(x == 0 && (y >= 2 && y <=(newImg.getYDim() - 3)) ){//sol
					// System.out.printf("LEFT_matrix_%d_%d \n",x,y);
					changingValue = leftPixelMatrix(x,y,sampleImage);
					newImg.setXYByte(x,y,changingValue); 
					continue;
				}
				if(x == 1 && (y >= 2 && y <=(newImg.getYDim() - 3)) ){//sol iç
					//System.out.printf("INNER LEFT_matrix_%d_%d \n",x,y);
					changingValue = innerLeftPixelMatrix(x,y,sampleImage);
					newImg.setXYByte(x,y,changingValue);
					continue;
				}
				if(x == (newImg.getXDim() - 1) && (y >= 2 && y <=(newImg.getYDim() - 3)) ){//sað
					 //System.out.printf("RIGHT_matrix_%d_%d \n",x,y);
					changingValue = rightPixelMatrix(x,y,sampleImage);
					newImg.setXYByte(x,y,changingValue);
					continue;
				}
				if(x == (newImg.getXDim() - 2) && (y >= 2 && y <=(newImg.getYDim() - 3)) ){//sað iç
					changingValue = innerRightPixelMatrix(x,y,sampleImage);
					newImg.setXYByte(x,y,changingValue);
					continue;
				}
				if(x >= 2 && x <=(newImg.getYDim() - 3) &&  y == (newImg.getYDim() - 1) ){//alt
					changingValue = downPixelMatrix(x,y,sampleImage);
					newImg.setXYByte(x,y,changingValue);
					continue;
				}
				if(x >= 2 && x <=(newImg.getYDim() - 3) &&  y == (newImg.getYDim() - 2) ){//alt iç
					 System.out.printf("INNER DOWN_matrix_%d_%d \n",x,y);
					 changingValue = innerDownPixelMatrix(x,y,sampleImage);
					 newImg.setXYByte(x,y,changingValue);
					 continue;
				}
				else{
					System.out.printf("MATRIX_%d_%d \n",x,y);
					changingValue = pixelMatrix(x,y,sampleImage);
					newImg.setXYByte(x,y,changingValue);
				}
			}
		}
		return newImg;
	}
	private int upLeftCornerFillArray(int x,int y,Image image){
		List<Integer>  array = new ArrayList();
		for(int i = x; i < x + 3  ; i++){
			for(int j = y; j < y + 3; j++ ){
				array.add(image.getXYByte(i, j));			
			}
		}
		Collections.sort(array);
		int newValue = array.get(4);
		return newValue;
	}
	private int leftDownKornerFillArray(int x,int y,Image image){
		List<Integer>  array = new ArrayList();
		for(int i = x; i < x + 3  ; i++){
			for(int j = y-2; j <= y; j++ ){
				array.add(image.getXYByte(i, j));			
			}
		}
		Collections.sort(array);
		return array.get(4);
	}
	private int rightUpKornerFillArray(int x,int y,Image image){
		List<Integer>  array = new ArrayList();
		for(int i = x-2; i <= x  ; i++){
			for(int j = y; j < y+3; j++ ){
				array.add(image.getXYByte(i, j));
				
			}
		}
		Collections.sort(array);
		return array.get(4);
	}
	private int rightDownKornerFillArray(int x,int y,Image image){
		List<Integer>  array = new ArrayList();
		for(int i = x-2; i <= x  ; i++){
			for(int j = y-2; j <= y; j++ ){
				array.add(image.getXYByte(i, j));
				
			}
		}
		Collections.sort(array);
		 int newValue = array.get(4);
		 return newValue;
	}
	private int upLeftPixelFourThreeMatrix(int x,int y,Image image){
		List<Integer>  array = new ArrayList();
		for(int i = x -1 ; i < x + 3; i++){
			for(int j = y; j <= y+2; j++ ){
				array.add(image.getXYByte(i, j));
				
			}
		}
		Collections.sort(array);
		 int newValue = (array.get(5) + array.get(6)) /2; 
		 return newValue;
	}
	private int upPixelMatrix(int x,int y,Image image){
		List<Integer>  array = new ArrayList();
		for(int i = x - 2 ; i <= x + 2; i++){
			for(int j = y; j <= y+2; j++ ){
				array.add(image.getXYByte(i, j));
				
			}
		}
		Collections.sort(array);
		return array.get(7);
	}
	private int upRightPixelFourThreeMatrix(int x,int y,Image image){
		List<Integer>  array = new ArrayList();
		for(int i = x-2; i <= x + 1  ; i++){
			for(int j = y; j < y + 3; j++ ){
				array.add(image.getXYByte(i, j));			
			}
		}
		Collections.sort(array);
		int newValue = (array.get(5) + array.get(6)) /2;
		return newValue;
	}
	private int leftDownPixelFourThreeMatrix(int x,int y,Image image){
		List<Integer>  array = new ArrayList();
		for(int i = x-1; i <= x + 2  ; i++){
			for(int j = y-2; j <= y ; j++ ){
				array.add(image.getXYByte(i, j));				
			}
		}
		Collections.sort(array);
		int newValue = (array.get(5) + array.get(6)) /2;
		return newValue;
	}
	private int rightDownPixelFourThreeMatrix(int x,int y,Image image){
		List<Integer>  array = new ArrayList();
		for(int i = x-2; i <= x + 1  ; i++){
			for(int j = y-2; j <= y ; j++ ){
				array.add(image.getXYByte(i, j));	
			}
		}
		Collections.sort(array);
		int newValue = (array.get(5) + array.get(6)) /2;
		return newValue;
	}
	private int leftPixelMatrix(int x,int y,Image image){
		List<Integer>  array = new ArrayList();
		for(int i = x  ; i <= x + 2; i++){
			for(int j = y-2; j <= y+2; j++ ){
				array.add(image.getXYByte(i, j));			
			}
		}	
		Collections.sort(array);
		return array.get(7);
	}
	private int rightPixelMatrix(int x,int y,Image image){
		List<Integer>  array = new ArrayList();
		for(int i = x-2  ; i <= x ; i++){
			for(int j = y-2; j <= y+2; j++ ){
				array.add(image.getXYByte(i, j));				
			}
		}		
		Collections.sort(array);
		return array.get(7);
	}
	private int downPixelMatrix(int x,int y,Image image){
		List<Integer>  array = new ArrayList();
		for(int i = x-2  ; i <= x+2 ; i++){
			for(int j = y-2; j <= y; j++ ){
				array.add(image.getXYByte(i, j));				
			}
		}
		Collections.sort(array);
		return array.get(7);
	}
	private int innerLeftUpCorner(int x,int y,Image image){
		List<Integer>  array = new ArrayList();
		for(int i = x-1  ; i <= x+2 ; i++){
			for(int j = y-1; j <= y+2; j++ ){
				array.add(image.getXYByte(i, j));			
			}
		}		
		Collections.sort(array);
		int newValue = (array.get(7) + array.get(8)) /2;
		return newValue;
	}
	private int innerRightUpCorner(int x,int y,Image image){
		List<Integer>  array = new ArrayList();
		for(int i = x-2  ; i <= x+1 ; i++){
			for(int j = y-1; j <= y+2; j++ ){
				array.add(image.getXYByte(i, j));				
			}
		}
		Collections.sort(array);
		int newValue = (array.get(7) + array.get(8)) /2;
		return newValue;
	}
	private int innerRightDownCorner(int x,int y,Image image){
		List<Integer>  array = new ArrayList();
		for(int i = x-2  ; i <= x+1 ; i++){
			for(int j = y-2; j <= y+1; j++ ){
				array.add(image.getXYByte(i, j));				
			}
		}
		Collections.sort(array);
		int newValue = (array.get(7) + array.get(8)) /2;
		return newValue;
	}
	private int innerLeftDownCorner(int x,int y,Image image){
		List<Integer>  array = new ArrayList();
		for(int i = x-1  ; i <= x+2 ; i++){
			for(int j = y-2; j <= y+1; j++ ){
				array.add(image.getXYByte(i, j));				
			}
		}
		Collections.sort(array);
		int newValue = (array.get(7) + array.get(8)) /2;
		return newValue;
	}
	private int innerUpPixelMatrix(int x,int y,Image image){
		List<Integer>  array = new ArrayList();
		for(int i = x-2  ; i <= x+2 ; i++){
			for(int j = y-1; j <= y+2; j++ ){
				array.add(image.getXYByte(i, j));				
			}
		}
		Collections.sort(array);
		int newValue = (array.get(9) + array.get(10)) /2;
		return newValue;
	}
	private int innerLeftPixelMatrix(int x,int y,Image image){
		List<Integer>  array = new ArrayList();
		for(int i = x-1  ; i <= x+2 ; i++){
			for(int j = y-2; j <= y+2; j++ ){
				array.add(image.getXYByte(i, j));				
			}
		}
		Collections.sort(array);
		int newValue = (array.get(9) + array.get(10)) /2;
		return newValue;
	}
	private int innerRightPixelMatrix(int x,int y,Image image){
		List<Integer>  array = new ArrayList();
		for(int i = x-2  ; i <= x+1 ; i++){
			for(int j = y-2; j <= y+2; j++ ){
				array.add(image.getXYByte(i, j));				
			}
		}
		Collections.sort(array);
		int newValue = (array.get(9) + array.get(10)) /2;
		return newValue;
	}
	private int innerDownPixelMatrix(int x,int y,Image image){
		List<Integer>  array = new ArrayList();
		for(int i = x-2  ; i <= x+2 ; i++){
			for(int j = y-2; j <= y+1; j++ ){
				array.add(image.getXYByte(i, j));				
			}
		}
		Collections.sort(array);
		int newValue = (array.get(9) + array.get(10)) /2;
		return newValue;
	}
	private int pixelMatrix(int x,int y,Image image){
		List<Integer>  array = new ArrayList();
		for(int i = x-2  ; i <= x+2 ; i++){
			for(int j = y-2; j <= y+2; j++ ){
				array.add(image.getXYByte(i, j));				
			}
		}
		Collections.sort(array);
		return array.get(12);
	}
	private int otherPixelMatrixLeftDown(int x,int y,Image image){
		List<Integer>  array = new ArrayList();
		for(int i = x  ; i <= x+2 ; i++){
			for(int j = y-2; j <= y+1; j++ ){
				array.add(image.getXYByte(i, j));				
			}
		}
		Collections.sort(array);
		int newValue = (array.get(5) + array.get(6)) /2;
		return newValue;
	}
	private int otherPixelMatrixRightUp(int x,int y,Image image){
		List<Integer>  array = new ArrayList();
		for(int i = x - 2   ; i <= x ; i++){
			for(int j = y-1; j <= y+2; j++ ){
				array.add(image.getXYByte(i, j));				
			}
		}
		Collections.sort(array);
		int newValue = (array.get(5) + array.get(6)) /2;
		return newValue;
	}
	private int otherPixelMatrixLeftUp(int x,int y,Image image){
		List<Integer>  array = new ArrayList();
		for(int i = x  ; i <= x+2 ; i++){
			for(int j = y-1; j <= y+2; j++ ){
				array.add(image.getXYByte(i, j));			
			}
		}
		Collections.sort(array);
		int newValue = (array.get(5) + array.get(6)) /2;
		return newValue;
	}
	private int otherPixelMatrixRightDown(int x,int y,Image image){
		List<Integer>  array = new ArrayList();
		for(int i = x - 2  ; i <= x ; i++){
			for(int j = y-2; j <= y+1; j++ ){
				array.add(image.getXYByte(i, j));				
			}
		}
		Collections.sort(array);
		int newValue = (array.get(5) + array.get(6)) /2;
		return newValue;
	}
	public static void main(String[] args) {
		Image img = Load.invoke("lennaGray.png");
		System.out.printf("Main: \n");
		MedianAlgorithm ma = new MedianAlgorithm();
		img = ma.implementAlgorithm(img);
		Display2D.invoke(img);
	}
}
