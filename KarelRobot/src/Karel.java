import java.util.ArrayList;
import javax.swing.*;

public class Karel extends JFrame implements Runnable {
	public static void main(String[] args){
		ArrayList<String> argList = new ArrayList<String>();
		
		argList.add("program=stanford.karel.KarelProgram");
		String[] argArray = new String[argList.size()];
		for (int i = 0; i < argArray.length; i++) {
			argArray[i] = argList.get(i);
		}
		//KarelProgram.main(argArray);
	}
	
	public void start(String[] args) {
		KarelProgram program = new KarelProgram();
		//program.setStartupObject(this);
		//program.start(args);
	}
	
	public void run(){
		
	}
}
