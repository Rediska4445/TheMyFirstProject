package siteRegAuth;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.temporal.ChronoField;
import java.util.Date;
import java.util.Scanner;

public class auth {

	public static int tryingCommon = 0;
	static LocalDateTime now = LocalDateTime.now();
	static int minutes = now.get(ChronoField.MINUTE_OF_HOUR);
	
	protected static void auth() throws IOException, InterruptedException { 
	    InetAddress ip = InetAddress.getLocalHost();
	    String hostname = ip.getHostName();
		try {
	      tryingCommon += 1;
	      	if(tryingCommon >= 5) {
	      	  int minutesBan = minutes + 5;
	      		  if(minutes < minutesBan) {
					System.out.println("Иди нахуй!");
	      		}
	      	 }
		Scanner UserDataTo = new Scanner(System.in);
        System.out.println("Логин: ");
			if(UserDataTo.hasNextLine()) {	
	            System.out.println("Пароль: ");
    			String UserName = UserDataTo.nextLine(); // Данные пользователя
    			String UserPass = UserDataTo.nextLine(); // Данные пользователя
    			File file = new File("DB/DBUsers.txt");
    	        Scanner sc = new Scanner(file);
    	        BufferedReader reader = new BufferedReader(new FileReader("DB/DBUsers.txt"));
   	        while(sc.hasNextLine()){    	        	
    	            String Read = (sc.nextLine());    
    	            boolean isContains = Files
    	                    .lines(Paths.get("DB/DBUsers.txt"))
    	                    .anyMatch(e->e.contains("Имя: " + UserName + " Пароль: " + UserPass));
    	    		File file1 = new File("DB/DBUsers.txt");
    	    		if((UserPass.equals("") || UserName.equals("")) || isContains == false) {
			            System.out.println("Неправильно введённые данные \nПопробуй ещё раз\n");
			            auth();
    	    		} 
    	    		if(isContains == true) {
    					System.out.println("Ты вошёл в систему!");
    					break;
    		            }
   	        		}
    			}
		} catch (IOException e) {
			System.out.println("Err: " + e.getMessage());
		}
	}
}
