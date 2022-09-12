package siteRegAuth;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.Scanner;

public class Reg{
	public static void main(String[] args) {
        String nameReg;
        String passReg;      	
		Scanner scanner = new Scanner(System.in);			
		System.out.println("Имя");
		if(scanner.hasNextLine()) {	
		String RegName = scanner.nextLine();
		System.out.println("Пароль");
		String RegPass = scanner.nextLine();
        try(FileWriter writer = new FileWriter("DBUsers.txt", true))
        {
            nameReg = RegName;
            passReg = RegPass;
            writer.write(nameReg + " " +  passReg + '\n');
            writer.flush();
            System.out.println("Вы успешно зарегистрировались");
			} catch(IOException ex){
          System.out.println(ex.getMessage());
		}
	    }
	} 
   }
}
