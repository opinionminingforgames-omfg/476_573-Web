/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import static org.hibernate.criterion.Expression.sql;
/**
 *
 * @author yukselkaradeniz
 */
public class DBLayer extends Exception {
    int recipeId = 0;
    private Connection conn;
    String dbUrl = "jdbc:derby://localhost:1527/OMFG";
    String name = "omfg";String pass = "123";
    public static String user="";
    public static String trend="";
    
    
    
   public class Node {

   /** The element stored at this node */

   String name;     // reference to the element stored at this node
   boolean action;      // reference to the element stored at this node
   boolean raceAndCar;      // reference to the element stored at this node
   boolean card;        // reference to the element stored at this node
   boolean strategy;        // reference to the element stored at this node
   boolean adventure;       // reference to the element stored at this node
   boolean online;      // reference to the element stored at this node
   boolean simulation;      // reference to the element stored at this node
   boolean management;      // reference to the element stored at this node
   boolean horror;      // reference to the element stored at this node
   boolean mental;      // reference to the element stored at this node
   
   String comment;
   double rate;
   String gameName;
   boolean commentOwner;
   /** A reference to the subsequent node in the list */
   private Node next;         // reference to the subsequent node in the list

   public Node(String name, boolean action, boolean raceAndCar, boolean card, boolean strategy, boolean adventure,
                    boolean online, boolean simulation, boolean management, boolean horror, boolean mental) {
       
       this.name = name;
       this.action=action;
       this.raceAndCar=raceAndCar;
       this.card=card;
       this.strategy=strategy;
       this.adventure=adventure;
       this.online=online;
       this.simulation=simulation;
       this.management=management;
       this.horror=horror;
       this.mental=mental;
   }

        private Node(String comment, double rate, String gameName, boolean commentOwner) {
            this.comment = comment;
            this.rate = rate;
            this.gameName = gameName;
            this.commentOwner = commentOwner;
        }

   public String getName() { return name; }
   public boolean getAction() { return action; }
   public boolean getRaceAndCar() { return raceAndCar; }
   public boolean getCard() { return card; }
   public boolean getStrategy()  { return strategy; }
   public boolean getAdventure() { return adventure; }
   public boolean getOnline() { return online; }
   public boolean getSimulation() { return simulation; }
   public boolean getManagement() { return management; }
   public boolean getHorror() { return horror; }
   public boolean getMental() { return mental; }

   public void setName(String name){this.name=name;}
   public void setAction(boolean action){this.action=action;}
   public void setRaceAndCar(boolean raceAndCar){this.raceAndCar=raceAndCar;}
   public void setCard(boolean card){this.card=card;}
   public void setStrategy(boolean strategy){this.strategy=strategy;}
   public void setAdventure(boolean adventure){this.adventure=adventure;}
   public void setOnline(boolean online){this.online=online;}
   public void setSimulation(boolean simulation){this.simulation=simulation;}
   public void setMnagement(boolean management){this.management=management;}
   public void setHorror(boolean horror){this.horror=horror;}
   public void setMental(boolean mental){this.mental=mental;}

   /**
    * Returns the node that follows this one (or null if no such node).
    * @return the following node
    */
   public Node getNext() { return next; }
   

   // Modifier methods
   /**
    * Sets the node's next reference to point to Node n.
    * @param n    the node that should follow this one
    */
   public void setNext(Node n) { next = n; }
   
 } //----------- end of nested Node class -----------
    
   public Connection connect(){
        try{
            Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
            conn = DriverManager.getConnection(dbUrl, name, pass);
            System.out.println("connected");
        }
        catch(Exception e){
            System.out.println("connection problem");
        }
        return conn;
   }
    /*
    public void PrintList(){
        if(conn == null){
            System.out.println("Database is NOT connected");
            connect();
        }
        
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select * from MAIN");
            ResultSetMetaData rsmd = rs.getMetaData();
            System.out.println("User Name : \nPassword : ");
            while(rs.next()){
//                System.out.println(""+rs.getString(0)+" \n "+rs.getString(1) );
            }
            stmt.close();
        } catch (Exception e) {
            Logger.getLogger(DBLayer.class.getName()).log(Level.SEVERE, null, e);
        }
        
    }
    */
    public void addUser(String name, String password,String trend ){
        if(conn == null){
            System.out.println("Database is NOT connected");
            connect();
        }
        try {
            Statement stmt = conn.createStatement();
            trend = trend.toLowerCase();
            String sql = "INSERT INTO USERINF "+"VALUES ('"+name+"','"+password+"','"+trend+"')";
            stmt.executeUpdate(sql);
            System.out.println("executed successfully!");
            stmt.close();
        }catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
    }
    
    public boolean loginUser(String name, String password){
        if(conn == null){
            System.out.println("Database is NOT connected");
            connect();
        }
        try {
            Statement stmt = conn.createStatement();
            String sql = "SELECT * FROM USERINF WHERE NAME = '"+name+"' AND PASSWORD = '"+password+"'";
            ResultSet rs = stmt.executeQuery(sql);
            ResultSetMetaData rsmd = rs.getMetaData();
            if(rs.next() == false){
                System.out.println("Invalid Password or username!!! ");
                return false;
            }else{
                System.out.println("Succesfully Login");
                this.trend = (String) rs.getObject("TREND");
            }
            this.user = name;
            stmt.close();
        }catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return true;
    }
    
    public void addGame(String name, boolean action, boolean raceAndCar, boolean card, boolean strategy, boolean adventure,
                                boolean online, boolean simulation, boolean management, boolean horror, boolean mental){
        if(conn == null){
            System.out.println("Database is NOT connected");
            connect();
        }
        try {
            Statement stmt = conn.createStatement();
            String sql = "INSERT INTO GAMEINF "+"VALUES ( '"+name+"' , "+action+" , '"+raceAndCar+"' , '"+card+"' , '"+ strategy
                    +"' , '"+adventure+"' , '"+online+"' , '"+simulation+"' , '"+management+"' , '"+horror+"' , '"+mental+"' )";
            stmt.executeUpdate(sql);
                stmt.close();
        }catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    public LinkedList getGame(String game){
        LinkedList<Node> list = new LinkedList();
         if(conn == null){
            System.out.println("Database is NOT connected");
            connect();
        }
        try {
            Statement stmt = conn.createStatement();
            String sql = "SELECT * FROM GAMEINF WHERE NAME = '"+game+"' ";
            ResultSet rs = stmt.executeQuery(sql);
            ResultSetMetaData rsmd = rs.getMetaData();
            if(rs.next() == false){
                System.out.println("Invalid or Empty");
                return null;
            }else{
                while(rs.next()!= false){
                    String name = (String) rs.getObject("NAME");
                    boolean action = (boolean)rs.getObject("ACTION") ;
                    boolean raceAndCar = (boolean) rs.getObject("RACEANDCAR") ;
                    boolean card = (boolean) rs.getObject("CARD") ;
                    boolean strategy = (boolean) rs.getObject("STRATEGY") ;
                    boolean adventure = (boolean) rs.getObject("ADVENTURE") ;
                    boolean online = (boolean) rs.getObject("ONLINE") ;
                    boolean simulation = (boolean) rs.getObject("SIMULATION") ;
                    boolean management = (boolean) rs.getObject("MANAGEMENT") ;
                    boolean horror = (boolean) rs.getObject("HORROR") ;
                    boolean mental = (boolean) rs.getObject("MENTAL") ;


                    Node newest;
                    newest = new Node(name, action,raceAndCar, card, strategy,adventure,online,simulation,management,horror,mental);
                    list.add(newest);
                }
            }
            stmt.close();
        }catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
        return list;
        

    }
    
        public LinkedList getGameFromRate(double rate){
        LinkedList<Node> list = new LinkedList();
         if(conn == null){
            System.out.println("Database is NOT connected");
            connect();
        }
        try {
            Statement stmt = conn.createStatement();
            String sql = "SELECT * FROM GAMEINF WHERE RATE >= "+rate;
            ResultSet rs = stmt.executeQuery(sql);
            ResultSetMetaData rsmd = rs.getMetaData();
            if(rs.next() == false){
                System.out.println("Invalid or Empty");
                return null;
            }else{
                while(rs.next()!= false){
                    String name = (String) rs.getObject("NAME");
                    boolean action = (boolean)rs.getObject("ACTION") ;
                    boolean raceAndCar = (boolean) rs.getObject("RACEANDCAR") ;
                    boolean card = (boolean) rs.getObject("CARD") ;
                    boolean strategy = (boolean) rs.getObject("STRATEGY") ;
                    boolean adventure = (boolean) rs.getObject("ADVENTURE") ;
                    boolean online = (boolean) rs.getObject("ONLINE") ;
                    boolean simulation = (boolean) rs.getObject("SIMULATION") ;
                    boolean management = (boolean) rs.getObject("MANAGEMENT") ;
                    boolean horror = (boolean) rs.getObject("HORROR") ;
                    boolean mental = (boolean) rs.getObject("MENTAL") ;


                    Node newest;
                    newest = new Node(name, action,raceAndCar, card, strategy,adventure,online,simulation,management,horror,mental);
                    list.add(newest);
                }
            }
            stmt.close();
        }catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
        return list;
        

    }
    
    public LinkedList getComment(String game){
        LinkedList<Node> list = new LinkedList();
         if(conn == null){
            System.out.println("Database is NOT connected");
            connect();
        }
        try {
            Statement stmt = conn.createStatement();
            String sql = "SELECT * FROM FEEDBACKINF WHERE NAME = '"+game+"' ";
            ResultSet rs = stmt.executeQuery(sql);
            ResultSetMetaData rsmd = rs.getMetaData();
            if(rs.next() == false){
                System.out.println("Invalid or Empty");
                return null;
            }else{
                while(rs.next()!= false){
                    String comment = (String) rs.getObject("COMMENT");
                    double rate = (double)rs.getObject("RATE") ;
                    String gameName = (String) rs.getObject("GAMENAME") ;
                    boolean commentOwner = (boolean) rs.getObject("COMMENTOWNER") ;
                    Node newest;
                    newest = new Node(comment, rate,gameName, commentOwner);
                    list.add(newest);
                }
            }
            stmt.close();
        }catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
        return list;
        

    }
    
    public LinkedList getCommentBucket(String trend) throws Exception{
        LinkedList<Node> list = new LinkedList();
         if(conn == null){
            System.out.println("Database is NOT connected");
            connect();
        }
        try {
            String sql="";
            if(trend.equals("action"))
                sql = "SELECT * FROM GAMEINF WHERE ACTION = '"+true+"' ";
            else if(trend.equals("raceAndCar"))
                sql = "SELECT * FROM GAMEINF WHERE RACEANDCAR = '"+true+"' ";
            else if(trend.equals("card"))
                sql = "SELECT * FROM GAMEINF WHERE ACTION = '"+true+"' ";
            else if(trend.equals("strategy"))
                sql = "SELECT * FROM GAMEINF WHERE ACTION = '"+true+"' ";
            else if(trend.equals("adventure"))
                sql = "SELECT * FROM GAMEINF WHERE ACTION = '"+true+"' ";
            else if(trend.equals("online"))
                sql = "SELECT * FROM GAMEINF WHERE ACTION = '"+true+"' ";
            else if(trend.equals("simulation"))
                sql = "SELECT * FROM GAMEINF WHERE ACTION = '"+true+"' ";
            else if(trend.equals("management"))
                sql = "SELECT * FROM GAMEINF WHERE ACTION = '"+true+"' ";
            else if(trend.equals("horror"))
                sql = "SELECT * FROM GAMEINF WHERE ACTION = '"+true+"' ";
            else if(trend.equals("mental"))
                sql = "SELECT * FROM GAMEINF WHERE ACTION = '"+true+"' ";
            else{
                Exception exception = new Exception("INVALID TREND TYPE");
                throw exception;
            }

            Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql);
            ResultSetMetaData rsmd = rs.getMetaData();
            if(rs.next() == false){
                System.out.println("Invalid or Empty");
                return null;
            }else{
                while(rs.next()!= false){
                    String name = (String) rs.getObject("NAME");
                    boolean action = (boolean)rs.getObject("ACTION") ;
                    boolean raceAndCar = (boolean) rs.getObject("RACEANDCAR") ;
                    boolean card = (boolean) rs.getObject("CARD") ;
                    boolean strategy = (boolean) rs.getObject("STRATEGY") ;
                    boolean adventure = (boolean) rs.getObject("ADVENTURE") ;
                    boolean online = (boolean) rs.getObject("ONLINE") ;
                    boolean simulation = (boolean) rs.getObject("SIMULATION") ;
                    boolean management = (boolean) rs.getObject("MANAGEMENT") ;
                    boolean horror = (boolean) rs.getObject("HORROR") ;
                    boolean mental = (boolean) rs.getObject("MENTAL") ;


                    Node newest;
                    newest = new Node(name, action,raceAndCar, card, strategy,adventure,online,simulation,management,horror,mental);
                    list.add(newest);
                }
            }
            stmt.close();
        }catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        LinkedList listComment = new LinkedList();
        for(int i = 0 ;i<list.size();i++){
            String g = list.get(i).name;
            listComment.add(getComment(g));
        }
        
        
        return listComment;
        
    }

    
    public static void main(String args[]){
        DBLayer dblayer = new DBLayer();//....Test Platform
        dblayer.loginUser("name","password");
        
    }
}
 