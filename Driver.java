
import java.util.LinkedList;


public class Driver {
    
    
    public static void main(String arg[]){
        LinkedList<DBLayer.Node> ratedGames = new LinkedList();
        String dataset = ".\\Dataset\\dataset.txt";
        ML ml = new ML(dataset);
        String result = ml.GetValue("herhangibir yorum");   // kullanıcı yorumları
        double resultd = Double.parseDouble(result);
        DBLayer db = new DBLayer();  
        ratedGames = db.getGameFromRate(resultd);
        ratedGames = elimination(ratedGames,DBLayer.trend);
        // mithat a gönder basması için// öner ratedGames
        
        
        
    }

    public static LinkedList elimination(LinkedList<DBLayer.Node> ratedGames, String trend){
        LinkedList<DBLayer.Node> newest = new LinkedList();
        trend = trend.toUpperCase();
        for(int i =0 ;i< ratedGames.size();i++){
            DBLayer.Node temp = ratedGames.get(i);
            if(temp.action && trend.equals("ACTION")){
                newest.add(temp);
            }
            if(temp.raceAndCar && trend.equals("RACEANDCAR")){
                newest.add(temp);
            }
            if(temp.card && trend.equals("CARD")){
                newest.add(temp);
            }
            if(temp.strategy && trend.equals("STRATEGY")){
                newest.add(temp);
            }
            if(temp.adventure && trend.equals("ADVENTURE")){
                newest.add(temp);
            }
            if(temp.online && trend.equals("ONLINE")){
                newest.add(temp);
            }
            if(temp.simulation && trend.equals("SIMULATION")){
                newest.add(temp);
            }
            if(temp.management && trend.equals("MANAGEMENT")){
                newest.add(temp);
            }
            if(temp.horror && trend.equals("HORROR")){
                newest.add(temp);
            }
            if(temp.mental && trend.equals("MENTAL")){
                newest.add(temp);
            }
            if(temp.action && trend.equals("ACTION")){
                newest.add(temp);
            }
            
            
        }        
            
        return newest;
        
    }
}
