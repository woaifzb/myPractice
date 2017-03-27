package fzb;

public class StackOF {
	int stacklength;
	private void stack(){
		stacklength++;
		stack();
	}
	public static void main(String[] args) {
		StackOF sof=new StackOF();
		sof.stack();
	}
}
