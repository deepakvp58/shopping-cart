package shop;

import java.io.*;
import java.util.*;
public class shopnew
{
  public static void main(String args[])throws IOException,FileNotFoundException
  {
    Admin a = new Admin();
    User u = new User();
  	int ch;
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  	Scanner read = new Scanner(System.in);
  	while(true){
  		System.out.println("1.Admin\n2.User\n3.Exit");
  		System.out.println("Enter your choice:");
  		ch = Integer.parseInt(br.readLine());
      boolean con = true;
  		switch(ch)
  		{
  		case 1:{
        int choice;
        do{
        System.out.println("1.1.Add Item\n1.2.Display Item\n1.3.View Requests\n1.4.View Purchases\n1.5.Exit");
        System.out.println("Enter your choice:");
        choice = Integer.parseInt(br.readLine());

      	switch(choice)
      	{
      	case 11:{
          System.out.println("Add Item:");
          System.out.println("Enter Itemname:");
          String iname = br.readLine();
          System.out.println("Enter quantity:");
          int quantity = Integer.parseInt(br.readLine());
          System.out.println("Enter price:");
          int price = Integer.parseInt(br.readLine());
          Items I = new Items();
          I.setIname(iname);
          I.setQuantity(quantity);
          I.setPrice(price);
          a.addItem(I);
          break;
        }
        case 12:{
          System.out.println("Number of Items available:\nItem name\tQuantity\tPrice\n");
          a.dispItem();
          break;
        }
        case 13:{
          System.out.println("Items requested by users are...");
          a.dispRequest();
          break;
        }
        case 14:{
          System.out.println("Master purchase list.");
          a.dispPurchase();
          break;
        }
        case 15:{
          break;
        }
        default:{
          System.out.println("Enter valid choice..");
        }
      }

    }while(choice>10 && choice<15);
    break;
    }
  		case 2:{
        int choic;
        do{
        System.out.println("Hello User!!!\n");
        System.out.println("Number of Items available:\nItem name\tQuantity\tPrice\n");
        a.dispItem();
        System.out.println("2.1.Buy\n2.2.Request\n2.3.Exit\n");
        System.out.println("Enter your choice:");
      	choic = Integer.parseInt(br.readLine());
        switch(choic)
        {
          case 21:{
            u.buyItem();
            break;
          }
          case 22:{
            u.requestItem();
            System.out.println("Your request has been sent successfully...");
            break;
          }
          case 23:{
            break;
          }
          default:{
            System.out.println("Enter valid choice..");
          }
        }
      }while(choic>20 && choic<23);
      break;
      }
      case 3:{
        System.exit(0);
      }
  		default:{
        System.out.println("Please enter valid choice!!");
      }
  	}
  }
}
}
