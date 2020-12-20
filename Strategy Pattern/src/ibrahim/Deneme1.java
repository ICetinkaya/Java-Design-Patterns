package ibrahim;



import vpt.Image;
import vpt.algorithms.display.Display2D;
import vpt.algorithms.io.Load;

public class Deneme1 {
	public static void main(String[] args) {
		// Goruntu belgesini diskten bellege aktar
		Image img = Load.invoke("lennaGray.png");
		System.out.printf("weewrtregt");
		// genisligi ogren
		int genislik = img.getXDim();
		
		// yuksekligi ogren
		int yukseklik = img.getYDim();
		System.err.println(genislik + " " + yukseklik);

		// ayni boyutta bos goruntu olustur
		Image copy = img.newInstance(false);
		
		// 100, 100 konumundaki degeri oku
		int p = img.getXYByte(100, 100);
		System.err.println(p);
		
		// goruntule
		Display2D.invoke(img);
		
		// 100, 100 konumuna yeni deger ata
		for (int i = 0; i < 150; i++)
			for(int j = 0; j < 50; j++)
					img.setXYByte(i,j, 0);
		
		// yeniden goruntule
		Display2D.invoke(img);		
	}
}
