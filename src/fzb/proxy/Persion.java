/**
 * 
 */
package fzb.proxy;

/**
 * @author fzb
 * @since  2017年3月18日 下午6:53:04
 */
public class Persion implements IPersion{
	String name;
	String age;
	int score;
	
	public Persion (String name,String age,int score){
		this.name=name;
		this.age=age;
		this.score=score;
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
	
	
}
