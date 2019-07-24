package game;

public class game {

	public static void main(String[] args) {
		ML obj = new ML();
		
		obj.Init();
		
		String retValue = obj.GetValue("This game is very good");
		
		System.out.println("Predict class : "+retValue);
	}

}
