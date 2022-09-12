package siteRegAuth;

import java.util.*;
import javax.swing.JFrame;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.*;
import java.nio.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import siteRegAuth.Reg;
import Chat.JoraOvosh;
import siteRegAuth.Frame;

public class Auth{
	
	public static int tryingCommon = 0;
	
	public static void main(String[] args) throws IOException, InterruptedException {
		auth();
	}
	
	protected static void auth() throws IOException, InterruptedException{ 
		try {
	      tryingCommon += 1;
		  while(tryingCommon <= 5) {
	      	if(tryingCommon >= 5) {
	      		System.out.println("Количество попыток превышенно");
				System.exit(0);
	      	  }
		Scanner UserDataTo = new Scanner(System.in);		
			if(UserDataTo.hasNextLine()) {	
    			String UserName = UserDataTo.nextLine(); // Данные пользователя
    			String UserPass = UserDataTo.nextLine(); // Данные пользователя
    			File file = new File("DBUsers.txt");
    	        Scanner sc = new Scanner(file);
    	        BufferedReader reader = new BufferedReader(new FileReader("DBUsers.txt"));
   	        while(sc.hasNextLine()){    	        	
    	            String Read = (sc.nextLine());    
    	            boolean isContains = Files
    	                    .lines(Paths.get("DBUsers.txt"))
    	                    .anyMatch(e->e.contains(UserName + " " + UserPass));
    	    		File file1 = new File("DBUsers.txt");
    		            if(isContains == false) {
    			            	System.out.println("Неправильные введённые данные");
    			            	System.out.println("Попробуй ещё раз \n");
    			            	auth();
    							}
    		            		  if(isContains == true) {
    		        				System.out.println("Ты вошёл в систему!");
    		        				JoraOvosh.main(null);
    		            } else {
    		            	System.out.println("Err: Ошибка авторизации");
    		            }
   	        		}
    			    }
		  	}	
		} catch (IOException e) {
			System.out.println("Err: " + e.getMessage());
	}
    }
}
