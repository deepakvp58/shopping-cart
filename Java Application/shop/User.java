package shop;

import java.io.*;
import java.util.*;
public class User implements Serializable
{
  public void buyItem()throws IOException,FileNotFoundException{
    try{
    Admin a = new Admin();
    Userpurchase UP = new Userpurchase();
    Masterpurchase MP = new Masterpurchase();
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    System.out.println("Enter your name:");
    String uname = br.readLine();
    int count = 0;
    boolean con = true;
    while(con){
    System.out.println("Enter the item name you want to buy:");
    String itna = br.readLine();
    count +=1;
    UP.setItemname(itna);
    addPurchase(UP,uname);
    System.out.println("Do you wish to continue shopping?(yes/no)");
    String choo = br.readLine();
    String yes = "yes";
    if(choo.equals(yes)){
      con = true;
    }
    else{
      con = false;
      break;
    }
  }
  MP.setUsername(uname);
  MP.setCount(count);
  addMpurchase(MP);
}
  catch(IOException ioe){
    ioe.printStackTrace();
  }
}
public void addPurchase(Userpurchase UP,String uname) throws IOException
{
  ObjectToFileWrite<Userpurchase> obu = new ObjectToFileWrite<>();
  obu.saveItem("Purchases\\"+uname+".txt", UP);
}
public void addMpurchase(Masterpurchase MP) throws IOException
{
  ObjectToFileWrite<Masterpurchase> obm = new ObjectToFileWrite<>();
  obm.saveItem("maspurchase.txt", MP);
}

public void requestItem(){
    try{
    Admin arr = new Admin();
    BufferedReader brrr = new BufferedReader(new InputStreamReader(System.in));
    System.out.println("Please enter the item name you want :");
    String requestItem = brrr.readLine();
    Requests R = new Requests();
    R.setRequest(requestItem);
    addRequest(R);
  }
  catch(IOException ex){
    ex.printStackTrace();
  }
  }
  public void addRequest(Requests R) throws IOException
  {
    ObjectToFileWrite<Requests> obr = new ObjectToFileWrite<>();
    obr.saveItem("relis.txt", R);
  }
}
