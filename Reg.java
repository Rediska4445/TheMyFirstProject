package siteRegAuth;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.LineNumberReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Date;
import java.util.Scanner;

public class reg {
	
    static String nameReg;
    static String passReg;
    static Date date = new Date();
    
		public static void reg() throws IOException, InterruptedException {  	
			Scanner scanner = new Scanner(System.in);			
			System.out.println("Имя для регистрации: ");
			if(scanner.hasNextLine()) {	
			String RegName = scanner.nextLine();
			System.out.println("Пароль для регистрации: ");
			String RegPass = scanner.nextLine();
			File file = new File("DBUsers.txt");
	        Scanner sc = new Scanner(file);
	        BufferedReader reader = new BufferedReader(new FileReader("DBUsers.txt"));
	        while(sc.hasNextLine()){    	        	
	            String Read = (sc.nextLine());    
	            boolean isContains = Files
	                    .lines(Paths.get("DBUsers.txt"))
	                    .anyMatch(e->e.contains("Имя: " + RegName));
	            if(isContains == true) {
	            	System.out.println("Упс, твоё самое оригинальное имя, неожиданно зарегистрировали, перерегистрируйся");
	            	Thread.sleep(500);
	        		reg();
	            } 
	        }
	        try(FileWriter writer = new FileWriter("DBUsers.txt", true))
	        {
	            nameReg = RegName;
	            passReg = RegPass;
	            writer.write('\n' + "Имя: " + nameReg + " Пароль: " + passReg);
	            writer.flush();
	            System.out.println("Вы успешно зарегистрировались");
	            auth.auth();
				} catch(IOException ex){
	          System.out.println(ex.getMessage());
			}
	        FileWriter writer = new FileWriter("DBUsersRegDate.txt", true);
	            writer.write(String.format(nameReg + " - Время и дата регистрации: %tc", date) + '\n');
	            writer.flush();
		}
	}
}

