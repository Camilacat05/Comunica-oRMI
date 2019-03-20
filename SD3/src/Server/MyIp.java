/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import java.net.InetAddress;
import java.rmi.UnknownHostException;

/**
 *
 * @author Sam
 */
public class MyIp {
    public String get() throws java.net.UnknownHostException{
     
        try {
            InetAddress ipAddr = InetAddress.getLocalHost();
            return(ipAddr.getHostAddress());
        } catch (Exception e) {}
        return "127.0.0.1";
    }
}
