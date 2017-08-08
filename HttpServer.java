import java.net.*;
import java.io.*;
import java.util.*;

class HttpServerSession extends Thread
{
  private Socket client;

  public HttpServerSession(Socket theClient)
  {
    client = theClient;
  }

  public void run()
  {
   String request = "";
   String garbage = "";

    try
    {
      BufferedReader reader = new BufferedReader(new InputStreamReader(client.getInputStream()));

      if (request != null)
      {
        request = reader.readLine();
        System.out.println(request);
      }

    }
    catch(IOException e)
    {
      System.err.println("Stress: " + e.getMessage());
    }
  }
}


class HttpServer
{
  public static void main(String args[])
  {
    try
    {
      int portNum = 8800;
      ServerSocket server = new ServerSocket(portNum);

      while(true)
      {
        System.out.println("Server listening on port" + Integer.toString(portNum));
        Socket client = server.accept();
        System.out.println("Connection established: " + client.getInetAddress().getHostAddress());
        HttpServerSession session = new HttpServerSession(client);
        session.run();

        client.close();
        //session.close();

      }
    }
    catch(IOException e)
    {
      System.err.println("Stress: " + e.getMessage());
    }
  }
}
