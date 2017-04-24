/**
 * 
 */
package fzb.Thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;


/**
 * @author fzb
 * @since  2017年4月7日 下午12:07:34
 */
public class DownLoadHtml {
	private final Executor exec;

	public DownLoadHtml(Executor exec) {
		super();
		this.exec = exec;
	}
	
	void startDown(HtmlSource source){
		List<ImageInfo> images=source.getImages();
		CompletionService<ImageData> completionService=new ExecutorCompletionService<ImageData>(exec);
		for(final ImageInfo  imageInfo:images){
			completionService.submit(new Callable<DownLoadHtml.ImageData>() {
				@Override
				public ImageData call() throws Exception {
					// TODO Auto-generated method stub
					return imageInfo.downImage();
				}
			});
		}
		
		try {
			paraText(source);
			for(int i=0,n=images.size();i<n;i++){
				Future<ImageData> future =completionService.take();
				ImageData image =future.get();
				paraImage(image);
			}
			System.out.println("没了");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			Thread.currentThread().interrupt();
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void paraImage(ImageData image) {
		// TODO Auto-generated method stub
		System.out.println("开始解析html图片");
		System.out.println("html图片内显示：");
		System.out.println(image.toString());
	}

	private void paraText(HtmlSource source) throws InterruptedException {
		// TODO Auto-generated method stub
		System.out.println("开始解析html文本");
		System.out.println("html文本内容是：");
		source.getText();
	}

	static class HtmlSource{
		private List<ImageInfo> images;
		String text;
		public HtmlSource(List<ImageInfo> images,String text) {
			super();
			this.images = images;
			this.text=text;
		}
		public List<ImageInfo> getImages() {
			return images;
		}
		public void setImages(List<ImageInfo> images) {
			this.images = images;
		}
		@SuppressWarnings("static-access")
		public String getText() throws InterruptedException {
			Thread.currentThread().sleep(100);
			System.out.println("html text:"+text);
			return text;
		}
		public void setText(String text) {
			this.text = text;
		}
		
		
	}
	static class ImageInfo{
		private ImageData imageData;
		public ImageInfo(ImageData imageData) {
			super();
			this.imageData = imageData;
		}
		@SuppressWarnings("static-access")
		public ImageData downImage() throws InterruptedException{
			Thread.currentThread().sleep(1000);
			return this.imageData;
		}
	}
	
	
	static class ImageData{
		String image;
		public ImageData(String image) {
			super();
			this.image = image;
		}
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return image;
		}
		
	}
	
	
	public static void main(String[] args) {
		List <ImageInfo> imageInfos=new ArrayList<ImageInfo>();
		String []images= {"猪","羊","牛","马","鹿","猴子","老虎","狮子","蛇","鸟","小猫","小狗"};
		for(int i=0;i<10;i++){
			ImageData imageData=new ImageData(images[i]);
			imageInfos.add(new ImageInfo(imageData));
		}
		HtmlSource source=new  HtmlSource(imageInfos,"动物园里面有:");
		Executor exec=Executors.newFixedThreadPool(10);
		DownLoadHtml dwonLoadHtml=new DownLoadHtml(exec);
		dwonLoadHtml.startDown(source);
	}
	
	
	
	
	
	
	
	
	
	
	
}
