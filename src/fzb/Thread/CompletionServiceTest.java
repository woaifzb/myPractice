/**
 * @author fzb
 * @date   2017-4-23下午04:03:30
 */
package fzb.Thread;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class CompletionServiceTest {
	public static class Render{
		private final ExecutorService executor;

		public Render(ExecutorService executor) {
			super();
			this.executor = executor;
		}
		
		void renderPage(List<ImageInfo> info ,String text){
			CompletionService<ImageData> completionService=new ExecutorCompletionService<ImageData>(executor);
			for(final ImageInfo imageInfo:info){
				completionService.submit(new Callable<ImageData>(){

					@Override
					public ImageData call() throws Exception {
						return imageInfo.downladImage();
					}
					
				});
			}
			
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("the text is "+text);
			
			try {
				long endNanos=System.nanoTime()+10000;
				for(int t=0,n=info.size();t<n;t++){
					long timeLeft=endNanos-System.nanoTime();
					Future<ImageData>f=completionService.take();
					System.out.println(timeLeft);
					ImageData imageData=f.get(timeLeft,TimeUnit.MICROSECONDS);
					imageData.display();
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (TimeoutException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public  static class ImageInfo{
		ImageData imageData;

		public ImageInfo(ImageData imageData) {
			super();
			this.imageData = imageData;
		}
		ImageData downladImage() throws InterruptedException{
			Thread.sleep(3000);
			return this.imageData;
		}
	}
	
	public static class ImageData{
		String image;

		public ImageData(String image) {
			super();
			this.image = image;
		}
		void display(){
			System.out.println("the image is "+image);
		}
	}
	
	
	public static void main(String[] args) {
		ExecutorService pool=Executors.newCachedThreadPool();
		List<ImageInfo> info= new ArrayList<ImageInfo>();
		info.add(	new ImageInfo(new ImageData("猴子")));
		info.add(	new ImageInfo(new ImageData("猪")));
		Render r=new Render(pool);
		r.renderPage(info, "zoo!!");
	}
}
