/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package e09.sockets;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author riversong
 */
public class TratamentoClass extends Thread{

    private Socket cliente;
    
    TratamentoClass(Socket c){
        this.cliente = c;
    }
    
    public void run(){
        
        try {
            Scanner s = new Scanner (cliente.getInputStream());
            while (s.hasNextLine()) {
              System.out.println (s.nextLine());
            }
            s.close();
        } catch (IOException ex) {
            Logger.getLogger(TratamentoClass.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }    
}
