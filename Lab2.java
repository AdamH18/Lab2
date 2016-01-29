//I made them work infinitely, so as long as the format remains the same for 1 and 3 they'll keep going if they can.
//3 does have an easy to expand limit of 100 blocks though.
public class Lab2
{
  public static void turnRight(){
    Robot.turnLeft();
    Robot.turnLeft();
    Robot.turnLeft();
  }
  public static void turnAround(){
    Robot.turnLeft();
    Robot.turnLeft();
  }
  public static void twoMove(){
    Robot.move();
    Robot.move();
  }
  public static void corner(){
    Robot.turnLeft();
    Lab2.twoMove();
    Robot.turnLeft();
  }
  public static void testLightCandles1()
  {
    Robot.load("candles1.txt");
    Robot.setDelay(0.05);
    Lab2.lightCandles();
  }
  
  public static void testLightCandles2()
  {
    Robot.load("candles2.txt");
    Robot.setDelay(0.05);
    Lab2.lightCandles();
  }
  
  public static void lightCandles()
  {
    boolean cont = true;
    
    Robot.turnLeft();
    Robot.move();
    Robot.move();
    Lab2.turnRight();
    Robot.move();
    
    while(cont){
      if(Robot.frontIsClear()){
        Lab2.turnRight();
        if(Robot.frontIsClear()){
          Robot.move();
          Robot.makeDark();
          Lab2.turnAround();
          Robot.move();
          Lab2.turnRight();
        }
        else{
          Robot.makeDark();
          Robot.turnLeft();
        }
        Robot.move();
        if(Robot.frontIsClear()){
          Robot.move();
        }
      }
      else{
        cont = false;
      }
    }
  }
  
  //Run this method to test completeRoom on map room1.txt
  public static void testCompleteRoom1()
  {
    Robot.load("room1.txt");
    Robot.setDelay(0.05);
    Lab2.completeRoom();
  }
  
  //Run this method to test completeRoom on map room2.txt
  public static void testCompleteRoom2()
  {
    Robot.load("room2.txt");
    Robot.setDelay(0.05);
    Lab2.completeRoom();
  }
  
  //Complete this method.  You will need to write additional helper methods.
  public static void completeRoom()
  {
    for(int i = 0; i < 4; i++){
      for(int j = 0; j < 5; j++){
        Robot.turnLeft();
        if(Robot.frontIsClear()){
          Robot.move();
          if(!Robot.onDark()){
            Robot.makeDark();
          }
          Lab2.turnAround();
          Robot.move();
          Robot.turnLeft();
        }
        else{
          Lab2.turnRight();
        }
        if(j != 4){
          Robot.move();
        }
      }
      Lab2.turnRight();
    }
  }
  
  //Run this method to test swapAll on map swap1.txt
  public static void testSwapAll1()
  {
    Robot.load("swap1.txt");
    Robot.setDelay(0.05);
    Lab2.swapAll();
  }
  
  //Run this method to test swapAll on map swap2.txt
  public static void testSwapAll2()
  {
    Robot.load("swap2.txt");
    Robot.setDelay(0.05);
    Lab2.swapAll();
  }
  
  //Complete this method.  You will need to write additional helper methods.
  public static void swapAll()
  {
    int[] leftSide;
    leftSide = new int[99];
    int[] rightSide;
    rightSide = new int[99];
    boolean cont = true;
    int dist = 0;
    
    Lab2.turnRight();
    Robot.move();
    Robot.turnLeft();
    
    while(cont){
      System.out.println(dist);
      if(Robot.onDark()){
        rightSide[dist] = 1;
      }
      else{
        rightSide[dist] = 0;
      }
      dist++;
      if(Robot.frontIsClear()){
        Robot.move();
      }
      else{
        cont = false;
      }
    }
    
    dist--;
    cont = true;
    Lab2.corner();
    
    while(cont){
      System.out.println(dist);
      if(Robot.onDark()){
        leftSide[dist] = 1;
      }
      else{
        leftSide[dist] = 0;
      }
      dist--;
      if(Robot.frontIsClear()){
        Robot.move();
      }
      else{
        cont = false;
      }
    }
    
    dist++;
    cont = true;
    Lab2.corner();
    
    while(cont){
      System.out.println(dist);
      if(leftSide[dist] == 1 && !Robot.onDark()){
        Robot.makeDark();
      }
      else if(leftSide[dist] == 0 && Robot.onDark()){
        Robot.makeLight();
      }
      dist++;
      if(Robot.frontIsClear()){
        Robot.move();
      }
      else{
        cont = false;
      }
    }
    
    dist--;
    cont = true;
    Lab2.corner();
    
    while(cont){
      System.out.println(dist);
      if(rightSide[dist] == 1 && !Robot.onDark()){
        Robot.makeDark();
      }
      else if(rightSide[dist] == 0 && Robot.onDark()){
        Robot.makeLight();
      }
      dist--;
      if(Robot.frontIsClear()){
        Robot.move();
      }
      else{
        cont = false;
      }
    }
  }
}