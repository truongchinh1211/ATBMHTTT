/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Socket;

//import java.net.Socket;

import Cipher.CeaserCipher;
import Cipher.RSACipher;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

//import org.jsoup.Connection;
//import org.jsoup.Jsoup;

/**
 *
 * @author lamanhhai
 */
//public class IPConfig {
public class socketManager {
    private static socketManager instance = null;
    private Socket commandSocket,dataSocket;
    private BufferedWriter commandWriter,dataWriter;
    private BufferedReader commandReader,dataReader;
    
    private socketManager() {
        try {
            IPConfig ipConfig = new IPConfig();
            String ipServer = ipConfig.getIPServer();
            // Khởi tạo kết nối TCP socket
            commandSocket = new Socket(ipServer, 1234);
            // Khởi tạo BufferedReader và BufferedWriter để gửi và nhận dữ liệu
            commandReader = new BufferedReader(new InputStreamReader(commandSocket.getInputStream()));
            commandWriter = new BufferedWriter(new OutputStreamWriter(commandSocket.getOutputStream()));    

        } catch (Exception e) {
//            e.printStackTrace();
        }
    }
    public static socketManager getInstance(){
        if(instance == null){
            instance = new socketManager();
        }
        return instance;
    }
    public String getKey(String username,String password,String key) throws Exception{
        String access ="login "+ username + " "+password+" "+key;
        writeLineAndFlush(access, commandWriter);
        String serverKey = commandReader.readLine();
        disconnect();
        return serverKey;
    }
    public String register(String username,String password,String key) throws Exception{
        String access ="register " +username + " "+password+" "+key;
        writeLineAndFlush(access, commandWriter);
        String serverKey = commandReader.readLine();
        disconnect();
        return serverKey;
    }
    public void disconnect() throws IOException{
        commandReader.close();
        commandWriter.close();
        commandSocket.close();
        instance=null;
    }
    public void writeLineAndFlush(String content, BufferedWriter writer) throws Exception {
        content = RSACipher.encrypt(content, RSACipher.server_key_e, RSACipher.server_key_n);
        writer.append(content);
        writer.newLine();
        writer.flush();
    }
    public static void main(String[] args) {
        try {
            int key = CeaserCipher.generateRandomKey();
            String res = socketManager.getInstance().register("2", "2", key+"");
            System.out.println(CeaserCipher.decrypt(res, key));
        } catch (Exception ex) {
            Logger.getLogger(socketManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
