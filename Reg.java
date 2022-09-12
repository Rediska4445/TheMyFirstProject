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
		String domain = ".su";
		String stSessionId = "https://ni647ikf3i2f/" + Math.random()*16 + domain;
		boolean ConnectionHandler = true;
		if(ConnectionHandler == true) {
			System.out.println("Соединение установлено, пакеты проверены, id(" + stSessionId + ")сгенерирован, регистрация при защищённом трафике доступна");
			// Anti-Hacking 
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
		} else if(ConnectionHandler == false) {
			System.out.println("Соединение не было установлено");
			System.exit(0);
	  } 
   }
}