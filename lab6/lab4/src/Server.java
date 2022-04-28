
import java.io.*;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Server {
    public static void main(String[] args){
      try (ServerSocket server= new ServerSocket(9000)){
          System.out.println("Сервер ожидает порт: 9000");
          
          while(true){
              Socket clientConn = server.accept(); //ожидание подключения клиента
                
          try(
               BufferedWriter writer = new BufferedWriter( new OutputStreamWriter(clientConn.getOutputStream()));
                  BufferedReader reader = new BufferedReader(new InputStreamReader(clientConn.getInputStream()))
          ){
            double result ;
            String[] data;
           
            String request = reader.readLine();
            data = request.split(" "); //в массив записываются значения которые передал клиент, данные разделяются пробелом
             for (int i = 0; i < data.length; i+=3) {

System.out.println("Запрос:" + data[i] + data[i+1] + data[i+2]);
myRunnable Thread = new myRunnable(data[i],data[i+1],data[i+2]);
Thread.run();
result = Thread.getResult();
System.out.println("Ответ:" + result);
String buf = Double.toString(result);
writer.write(buf);
writer.newLine();
writer.flush(); //клинбуф
}
  
           
            
            
          }catch(NullPointerException e){e.printStackTrace();}}
          
      }catch(IOException e){throw new RuntimeException(e);}
    
     
    }
}
