/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tcpclient;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

/**
 *
 * @author USER
 */
public class TcpClient {

    private static  int PORT = 4884;
    private static BufferedReader BR1,BR2;
    private static PrintStream PS;
    private static String serverHost = "127.0.0.1";
    private static Socket clientSocket;
    
    public static void main(String[] args) {
        try {
            clientSocket = new Socket(serverHost, PORT);
            BR1 = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PS = new PrintStream(clientSocket.getOutputStream());
            BR2 = new BufferedReader(new InputStreamReader(System.in));
            String inputKarakter = "";
            while(!inputKarakter.equalsIgnoreCase("EXIT")){
                System.out.print("Me  : ");
                inputKarakter=BR2.readLine();
                PS.println(inputKarakter);
                inputKarakter=BR1.readLine();
                System.out.print("You : "+inputKarakter+"\n");
            }
            clientSocket.close();
            BR1.close();
            PS.close();
            BR2.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
