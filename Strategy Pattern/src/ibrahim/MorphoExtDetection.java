package ibrahim;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import vpt.Image;
import vpt.algorithms.display.Display2D;
import vpt.algorithms.io.Load;

public class MorphoExtDetection implements EdgeDetection {
	@Override
	public Image implementAlgorithm(Image sampleImage) {
		int changingValue;
		Image newImg = sampleImage.newInstance(false);
		for(int x = 0 ; x < newImg.getXDim() ; x = x + 1){
			for(int y = 0 ; y < newImg.getYDim(); y = y + 1 ){
				if(x == 0 && y == 0){ //sol köþe
					System.out.printf("UP_left_CORNER \n");
					changingValue = upLeftCornerFillArray(x,y,sampleImage);
					newImg.setXYByte(x,y,changingValue);
					continue;
				}
				if(x == 1 && y == 0){//4x3 matrix üstsol
					//System.out.printf("UP_left_matrix \n");
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
					//System.out.printf("INNER LEft UP_PIXEL_MATRIX_%d_%d \n ",x,y);
					changingValue = innerLeftUpCorner(x,y,sampleImage);
					newImg.setXYByte(x,y,changingValue);
					continue;
				}
				if(x == 1 &&  y == (newImg.getYDim() - 2)){
					//System.out.printf("INNER LEft Down_PIXEL_MATRIX_%d_%d \n ",x,y);
					changingValue = innerLeftDownCorner(x,y,sampleImage);
					newImg.setXYByte(x,y,changingValue);
					continue;
				}
 				if(x == (newImg.getXDim() - 2) && y == 1)
				{
					//System.out.printf("INNER Right UP_PIXEL_MATRIX_%d_%d \n ",x,y);
 					changingValue = innerRightUpCorner(x,y,sampleImage);
 					newImg.setXYByte(x,y,changingValue);
 					continue;
				}
				if(x == (newImg.getXDim() - 2) && y == (newImg.getYDim() - 2)) {
					//System.out.printf("INNER Right Down_PIXEL_MATRIX_%d_%d \n ",x,y);
					changingValue = innerRightDownCorner(x,y,sampleImage);
					newImg.setXYByte(x,y,changingValue);
					continue;
				}
				if( (x >= 2 && x <=(newImg.getXDim() - 3)) && y == 0){//üst
					//System.out.printf("UP_PIXEL_MATRIX_%d_%d \n ",x,y);
					changingValue = upPixelMatrix(x,y,sampleImage);
					newImg.setXYByte(x,y,changingValue);
					continue;
				}
				if( (x >= 2 && x <=(newImg.getXDim() - 3)) && y == 1){//üst iç
					//System.out.printf("INNER UP_PIXEL_MATRIX_%d_%d \n ",x,y);
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
					//System.out.printf("LEFT_DOWN_PIXEL_MATRIX_%d_%d \n ",x,y);
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
					//To do
					//System.out.printf("UP_right_matrix_%d_%d \n",x,y);
					changingValue = upRightPixelFourThreeMatrix(x,y,sampleImage);
					newImg.setXYByte(x,y,changingValue);
					continue;
				}
				if(x == (newImg.getXDim() - 1) && y == (newImg.getYDim() - 1)) {
					System.out.printf("DOWN_right_matrix_%d_%d \n",x,y);
					changingValue = rightDownKornerFillArray(x,y,sampleImage);
					newImg.setXYByte(x,y,changingValue);
					continue;
				}
				if(x == (newImg.getXDim() - 2)  && y == (newImg.getYDim() - 1))  {//4x3 matrix alt sað
					//To do
					//System.out.printf("DOWN_right_matrix_%d_%d \n",x,y);
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
					// System.out.printf("INNER RIGHT_matrix_%d_%d \n",x,y);
					changingValue = innerRightPixelMatrix(x,y,sampleImage);
					newImg.setXYByte(x,y,changingValue);
					continue;
				}
				if(x >= 2 && x <=(newImg.getYDim() - 3) &&  y == (newImg.getYDim() - 1) ){//alt
					 //System.out.printf("DOWN_matrix_%d_%d \n",x,y);
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
				//System.out.printf("i : %d pixel %d\n",i,sampleImage.getXYByte(x, y));
				//i++;
			}
		}
		return newImg;
		// TODO Auto-generated method stub
			
	}
	private int upLeftCornerFillArray(int x,int y,Image image){
		List<Integer>  array = new ArrayList();
		int tempX = x;
		int tempY = y;
		for(int i = x; i < x + 3  ; i++){
			for(int j = y; j < y + 3; j++ ){
				array.add(image.getXYByte(i, j));			
			}
		}
		Collections.sort(array);
		int newValue = array.get(array.size() - 1);
		if(newValue > image.getXYByte(tempX, tempY)){
			newValue = newValue - image.getXYByte(tempX, tempY);
		}
		if(newValue < image.getXYByte(tempX, tempY)){
			newValue =  image.getXYByte(tempX, tempY) - newValue ;
		}
		return newValue;
		
	}
	private int leftDownKornerFillArray(int x,int y,Image image){
		List<Integer>  array = new ArrayList();
		int tempX = x;
		int tempY = y;
		for(int i = x; i < x + 3  ; i++){
			for(int j = y-2; j <= y; j++ ){
				array.add(image.getXYByte(i, j));			
			}
		}
		Collections.sort(array);
		int newValue = array.get(array.size() - 1);
		if(newValue > image.getXYByte(tempX, tempY)){
			newValue = newValue - image.getXYByte(tempX, tempY);
		}
		if(newValue < image.getXYByte(tempX, tempY)){
			newValue =  image.getXYByte(tempX, tempY) - newValue ;
		}
		return newValue;
	}
	private int rightUpKornerFillArray(int x,int y,Image image){
		List<Integer>  array = new ArrayList();
		int tempX = x;
		int tempY = y;
		for(int i = x-2; i <= x  ; i++){
			for(int j = y; j < y+3; j++ ){
				array.add(image.getXYByte(i, j));		
			}
		}
		Collections.sort(array);
		int newValue = array.get(array.size() - 1);
		if(newValue > image.getXYByte(tempX, tempY)){
			newValue = newValue - image.getXYByte(tempX, tempY);
		}
		if(newValue < image.getXYByte(tempX, tempY)){
			newValue =  image.getXYByte(tempX, tempY) - newValue ;
		}
		return newValue;
	}
	private int rightDownKornerFillArray(int x,int y,Image image){
		List<Integer>  array = new ArrayList();
		int tempX = x;
		int tempY = y;
		for(int i = x-2; i <= x  ; i++){
			for(int j = y-2; j <= y; j++ ){
				array.add(image.getXYByte(i, j));				
			}
		}
		Collections.sort(array);
		int newValue = array.get(array.size() - 1);
		if(newValue > image.getXYByte(tempX, tempY)){
			newValue = newValue - image.getXYByte(tempX, tempY);
		}
		if(newValue < image.getXYByte(tempX, tempY)){
			newValue =  image.getXYByte(tempX, tempY) - newValue ;
		}
		return newValue;
	}
	private int upLeftPixelFourThreeMatrix(int x,int y,Image image){
		List<Integer>  array = new ArrayList();
		int tempX = x;
		int tempY = y;
		for(int i = x -1 ; i < x + 3; i++){
			for(int j = y; j <= y+2; j++ ){
				array.add(image.getXYByte(i, j));		
			}
		}
		Collections.sort(array);
		int newValue = array.get(array.size() - 1);
		if(newValue > image.getXYByte(tempX, tempY)){
			newValue = newValue - image.getXYByte(tempX, tempY);
		}
		if(newValue < image.getXYByte(tempX, tempY)){
			newValue =  image.getXYByte(tempX, tempY) - newValue ;
		}
		return newValue;
	}
	private int upPixelMatrix(int x,int y,Image image){
		List<Integer>  array = new ArrayList();
		int tempX = x;
		int tempY = y;
		for(int i = x - 2 ; i <= x + 2; i++){
			for(int j = y; j <= y+2; j++ ){
				array.add(image.getXYByte(i, j));	
			}
		}
		Collections.sort(array);
		int newValue = array.get(array.size() - 1);
		if(newValue > image.getXYByte(tempX, tempY)){
			newValue = newValue - image.getXYByte(tempX, tempY);
		}
		if(newValue < image.getXYByte(tempX, tempY)){
			newValue =  image.getXYByte(tempX, tempY) - newValue ;
		}
		return newValue;
	}
	private int upRightPixelFourThreeMatrix(int x,int y,Image image){
		List<Integer>  array = new ArrayList();
		int tempX = x;
		int tempY = y;
		for(int i = x-2; i <= x + 1  ; i++){
			for(int j = y; j < y + 3; j++ ){
				array.add(image.getXYByte(i, j));
				
			}
		}
		Collections.sort(array);
		int newValue = array.get(array.size() - 1);
		if(newValue > image.getXYByte(tempX, tempY)){
			newValue = newValue - image.getXYByte(tempX, tempY);
		}
		if(newValue < image.getXYByte(tempX, tempY)){
			newValue =  image.getXYByte(tempX, tempY) - newValue ;
		}
		return newValue;
	}
	private int leftDownPixelFourThreeMatrix(int x,int y,Image image){
		List<Integer>  array = new ArrayList();
		int tempX = x;
		int tempY = y;
		for(int i = x-1; i <= x + 2  ; i++){
			for(int j = y-2; j <= y ; j++ ){
				array.add(image.getXYByte(i, j));			
			}
		}
		Collections.sort(array);
		int newValue = array.get(array.size() - 1);
		if(newValue > image.getXYByte(tempX, tempY)){
			newValue = newValue - image.getXYByte(tempX, tempY);
		}
		if(newValue < image.getXYByte(tempX, tempY)){
			newValue =  image.getXYByte(tempX, tempY) - newValue ;
		}
		return newValue;
	}
	private int rightDownPixelFourThreeMatrix(int x,int y,Image image){
		List<Integer>  array = new ArrayList();
		int tempX = x;
		int tempY = y;
		for(int i = x-2; i <= x + 1  ; i++){
			for(int j = y-2; j <= y ; j++ ){
				array.add(image.getXYByte(i, j));				
			}
		}
		Collections.sort(array);
		int newValue = array.get(array.size() - 1);
		if(newValue > image.getXYByte(tempX, tempY)){
			newValue = newValue - image.getXYByte(tempX, tempY);
		}
		if(newValue < image.getXYByte(tempX, tempY)){
			newValue =  image.getXYByte(tempX, tempY) - newValue ;
		}
		return newValue;
	}
	private int leftPixelMatrix(int x,int y,Image image){
		List<Integer>  array = new ArrayList();
		int tempX = x;
		int tempY = y;
		for(int i = x  ; i <= x + 2; i++){
			for(int j = y-2; j <= y+2; j++ ){
				array.add(image.getXYByte(i, j));				
			}
		}	
		Collections.sort(array);
		int newValue = array.get(array.size() - 1);
		if(newValue > image.getXYByte(tempX, tempY)){
			newValue = newValue - image.getXYByte(tempX, tempY);
		}
		if(newValue < image.getXYByte(tempX, tempY)){
			newValue =  image.getXYByte(tempX, tempY) - newValue ;
		}
		return newValue;
	}
	private int rightPixelMatrix(int x,int y,Image image){
		List<Integer>  array = new ArrayList();
		int tempX = x;
		int tempY = y;
		for(int i = x-2  ; i <= x ; i++){
			for(int j = y-2; j <= y+2; j++ ){
				array.add(image.getXYByte(i, j));				
			}
		}
		Collections.sort(array);
		int newValue = array.get(array.size() - 1);
		if(newValue > image.getXYByte(tempX, tempY)){
			newValue = newValue - image.getXYByte(tempX, tempY);
		}
		if(newValue < image.getXYByte(tempX, tempY)){
			newValue =  image.getXYByte(tempX, tempY) - newValue ;
		}
		return newValue;
	}
	private int downPixelMatrix(int x,int y,Image image){
		List<Integer>  array = new ArrayList();
		int tempX = x;
		int tempY = y;
		for(int i = x-2  ; i <= x+2 ; i++){
			for(int j = y-2; j <= y; j++ ){
				array.add(image.getXYByte(i, j));				
			}
		}
		Collections.sort(array);
		int newValue = array.get(array.size() - 1);
		if(newValue > image.getXYByte(tempX, tempY)){
			newValue = newValue - image.getXYByte(tempX, tempY);
		}
		if(newValue < image.getXYByte(tempX, tempY)){
			newValue =  image.getXYByte(tempX, tempY) - newValue ;
		}
		return newValue;
	}
	private int innerLeftUpCorner(int x,int y,Image image){
		List<Integer>  array = new ArrayList();
		int tempX = x;
		int tempY = y;
		for(int i = x-1  ; i <= x+2 ; i++){
			for(int j = y-1; j <= y+2; j++ ){
				array.add(image.getXYByte(i, j));			
			}
		}		
		Collections.sort(array);
		int newValue = array.get(array.size() - 1);
		if(newValue > image.getXYByte(tempX, tempY)){
			newValue = newValue - image.getXYByte(tempX, tempY);
		}
		if(newValue < image.getXYByte(tempX, tempY)){
			newValue =  image.getXYByte(tempX, tempY) - newValue ;
		}
		return newValue;
	}
	private int innerRightUpCorner(int x,int y,Image image){
		List<Integer>  array = new ArrayList();
		int tempX = x;
		int tempY = y;
		for(int i = x-2  ; i <= x+1 ; i++){
			for(int j = y-1; j <= y+2; j++ ){
				array.add(image.getXYByte(i, j));				
			}
		}
		Collections.sort(array);
		int newValue = array.get(array.size() - 1);
		if(newValue > image.getXYByte(tempX, tempY)){
			newValue = newValue - image.getXYByte(tempX, tempY);
		}
		if(newValue < image.getXYByte(tempX, tempY)){
			newValue =  image.getXYByte(tempX, tempY) - newValue ;
		}
		return newValue;
	}
	private int innerRightDownCorner(int x,int y,Image image){
		List<Integer>  array = new ArrayList();
		int tempX = x;
		int tempY = y;
		for(int i = x-2  ; i <= x+1 ; i++){
			for(int j = y-2; j <= y+1; j++ ){
				array.add(image.getXYByte(i, j));				
			}
		}
		Collections.sort(array);
		int newValue = array.get(array.size() - 1);
		if(newValue > image.getXYByte(tempX, tempY)){
			newValue = newValue - image.getXYByte(tempX, tempY);
		}
		if(newValue < image.getXYByte(tempX, tempY)){
			newValue =  image.getXYByte(tempX, tempY) - newValue ;
		}
		return newValue;
	}
	private int innerLeftDownCorner(int x,int y,Image image){
		List<Integer>  array = new ArrayList();
		int tempX = x;
		int tempY = y;
		for(int i = x-1  ; i <= x+2 ; i++){
			for(int j = y-2; j <= y+1; j++ ){
				array.add(image.getXYByte(i, j));
				
			}
		}
		Collections.sort(array);
		int newValue = array.get(array.size() - 1);
		if(newValue > image.getXYByte(tempX, tempY)){
			newValue = newValue - image.getXYByte(tempX, tempY);
		}
		if(newValue < image.getXYByte(tempX, tempY)){
			newValue =  image.getXYByte(tempX, tempY) - newValue ;
		}
		return newValue;
	}
	private int innerUpPixelMatrix(int x,int y,Image image){
		List<Integer>  array = new ArrayList();
		int tempX = x;
		int tempY = y;
		for(int i = x-2  ; i <= x+2 ; i++){
			for(int j = y-1; j <= y+2; j++ ){
				array.add(image.getXYByte(i, j));				
			}
		}
		Collections.sort(array);
		int newValue = array.get(array.size() - 1);
		if(newValue > image.getXYByte(tempX, tempY)){
			newValue = newValue - image.getXYByte(tempX, tempY);
		}
		if(newValue < image.getXYByte(tempX, tempY)){
			newValue =  image.getXYByte(tempX, tempY) - newValue ;
		}
		return newValue;
	}
	private int innerLeftPixelMatrix(int x,int y,Image image){
		List<Integer>  array = new ArrayList();
		int tempX = x;
		int tempY = y;
		for(int i = x-1  ; i <= x+2 ; i++){
			for(int j = y-2; j <= y+2; j++ ){
				array.add(image.getXYByte(i, j));				
			}
		}
		Collections.sort(array);
		int newValue = array.get(array.size() - 1);
		if(newValue > image.getXYByte(tempX, tempY)){
			newValue = newValue - image.getXYByte(tempX, tempY);
		}
		if(newValue < image.getXYByte(tempX, tempY)){
			newValue =  image.getXYByte(tempX, tempY) - newValue ;
		}
		return newValue;
	}
	private int innerRightPixelMatrix(int x,int y,Image image){
		List<Integer>  array = new ArrayList();
		int tempX = x;
		int tempY = y;
		for(int i = x-2  ; i <= x+1 ; i++){
			for(int j = y-2; j <= y+2; j++ ){
				array.add(image.getXYByte(i, j));				
			}
		}
		Collections.sort(array);
		int newValue = array.get(array.size() - 1);
		if(newValue > image.getXYByte(tempX, tempY)){
			newValue = newValue - image.getXYByte(tempX, tempY);
		}
		if(newValue < image.getXYByte(tempX, tempY)){
			newValue =  image.getXYByte(tempX, tempY) - newValue ;
		}
		return newValue;
	}
	private int innerDownPixelMatrix(int x,int y,Image image){
		List<Integer>  array = new ArrayList();
		int tempX = x;
		int tempY = y;
		for(int i = x-2  ; i <= x+2 ; i++){
			for(int j = y-2; j <= y+1; j++ ){
				array.add(image.getXYByte(i, j));				
			}
		}
		Collections.sort(array);
		int newValue = array.get(array.size() - 1);
		if(newValue > image.getXYByte(tempX, tempY)){
			newValue = newValue - image.getXYByte(tempX, tempY);
		}
		if(newValue < image.getXYByte(tempX, tempY)){
			newValue =  image.getXYByte(tempX, tempY) - newValue ;
		}
		return newValue;
	}
	private int pixelMatrix(int x,int y,Image image){
		List<Integer>  array = new ArrayList();
		int tempX = x;
		int tempY = y;
		for(int i = x-2  ; i <= x+2 ; i++){
			for(int j = y-2; j <= y+2; j++ ){
				array.add(image.getXYByte(i, j));				
			}
		}
		Collections.sort(array);
		int newValue = array.get(array.size() - 1);
		if(newValue > image.getXYByte(tempX, tempY)){
			newValue = newValue - image.getXYByte(tempX, tempY);
		}
		if(newValue < image.getXYByte(tempX, tempY)){
			newValue =  image.getXYByte(tempX, tempY) - newValue ;
		}
		return newValue;
	}
	private int otherPixelMatrixLeftDown(int x,int y,Image image){
		List<Integer>  array = new ArrayList();
		int tempX = x;
		int tempY = y;
		for(int i = x  ; i <= x+2 ; i++){
			for(int j = y-2; j <= y+1; j++ ){
				array.add(image.getXYByte(i, j));			
			}
		}
		Collections.sort(array);
		int newValue = array.get(array.size() - 1);
		if(newValue > image.getXYByte(tempX, tempY)){
			newValue = newValue - image.getXYByte(tempX, tempY);
		}
		if(newValue < image.getXYByte(tempX, tempY)){
			newValue =  image.getXYByte(tempX, tempY) - newValue ;
		}
		return newValue;
	}
	private int otherPixelMatrixRightUp(int x,int y,Image image){
		List<Integer>  array = new ArrayList();
		int tempX = x;
		int tempY = y;
		for(int i = x - 2   ; i <= x ; i++){
			for(int j = y-1; j <= y+2; j++ ){
				array.add(image.getXYByte(i, j));				
			}
		}
		Collections.sort(array);
		int newValue = array.get(array.size() - 1);
		if(newValue > image.getXYByte(tempX, tempY)){
			newValue = newValue - image.getXYByte(tempX, tempY);
		}
		if(newValue < image.getXYByte(tempX, tempY)){
			newValue =  image.getXYByte(tempX, tempY) - newValue ;
		}
		return newValue;
	}
	private int otherPixelMatrixLeftUp(int x,int y,Image image){
		List<Integer>  array = new ArrayList();
		int tempX = x;
		int tempY = y;
		for(int i = x  ; i <= x+2 ; i++){
			for(int j = y-1; j <= y+2; j++ ){
				array.add(image.getXYByte(i, j));				
			}
		}
		Collections.sort(array);
		int newValue = array.get(array.size() - 1);
		if(newValue > image.getXYByte(tempX, tempY)){
			newValue = newValue - image.getXYByte(tempX, tempY);
		}
		if(newValue < image.getXYByte(tempX, tempY)){
			newValue =  image.getXYByte(tempX, tempY) - newValue ;
		}
		return newValue;
	}
	private int otherPixelMatrixRightDown(int x,int y,Image image){
		List<Integer>  array = new ArrayList();
		int tempX = x;
		int tempY = y;
		for(int i = x - 2  ; i <= x ; i++){
			for(int j = y-2; j <= y+1; j++ ){
				array.add(image.getXYByte(i, j));			
			}
		}
		Collections.sort(array);
		int newValue = array.get(array.size() - 1);
		if(newValue > image.getXYByte(tempX, tempY)){
			newValue = newValue - image.getXYByte(tempX, tempY);
		}
		if(newValue < image.getXYByte(tempX, tempY)){
			newValue =  image.getXYByte(tempX, tempY) - newValue ;
		}
		return newValue;
	}
	public static void main(String[] args) {
		Image img = Load.invoke("lennaGray.png");
		System.out.printf("Main: \n");
		MorphoExtDetection ma = new MorphoExtDetection();
		img = ma.implementAlgorithm(img);
		Display2D.invoke(img);
	}
}
