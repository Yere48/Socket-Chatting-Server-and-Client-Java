/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tcpserver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author Yere48
 */
public class TcpServer {

    
    private static int PORT = 4884;
    private static BufferedReader BR1,BR2;
    private static PrintStream PS;
    private static Socket clientSocket;
    
    public static void main(String[] args) {
        try{
            ServerSocket server = new ServerSocket(PORT);
            System.out.println("Server Started...");
            
            clientSocket = server.accept();
            System.out.println("A client try to connect...");
            
            BR1 = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PS = new PrintStream(clientSocket.getOutputStream());
            BR2 = new BufferedReader(new InputStreamReader(System.in));
            String inputKarakter="";
            while(!inputKarakter.equalsIgnoreCase("EXIT")){
                inputKarakter = BR1.readLine();
                System.out.print("You : "+inputKarakter+"\n");
                System.out.print("Me  : ");
                inputKarakter=BR2.readLine();
                PS.println(inputKarakter);
            }
            server.close();
            clientSocket.close();
            BR1.close();
            PS.close();
            BR2.close();
        }catch(IOException ex){
            ex.printStackTrace();
        }
    }
    
}
