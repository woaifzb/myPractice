/**
 * 
 */
package fzb.proxy;

/**
 * @author fzb
 * @since  2017��3��18�� ����6:53:04
 */
public class Persion implements IPersion{
	String name;
	String age;
	int score;
	float height;
	
	
	public Persion() {
		super();
	}
	public Persion (String name,String age,int score,float height){
		this.name=name;
		this.age=age;
		this.score=score;
		this.height=height;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	
	
	
	private float getHeight() {
		return height;
	}
	private void setHeight(float height) {
		this.height = height;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		System.out.println("name: "+name+" age:"+age+" score:"+score+" height:"+height);
		return super.toString();
	}
	
	
}
