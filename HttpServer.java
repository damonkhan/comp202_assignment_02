import java.net.*;
import java.io.*;
import java.util.*;
class HttpServer
{
  public static void main(String args[])
  {

    /*
    * TODO uncomment code to
    * allow users to specify the
    * port number*/

    int portNum = 8080;

    // test001
    //if (args.length != 1)
    //{
      //System.err.println("Usage: <portnum>");
      //return;
    //}

    //test002
    //if (portNum < 1024)
    //{
      //System.err.println("Port number cannot be less than 1024");
      //return;
    //}



    try
    {
      ServerSocket server = new ServerSocket(portNum);
      System.out.println("web server starting");

      while(true)
      {
        System.out.println("Server listening on port " + portNum);
        Socket client = server.accept(); // wait for client to connect
        HttpServerSession serverSession = new HttpServerSession(client);
        System.out.println("Connection received.");
      }
    }
    catch(IOException e)
    {
      System.err.println("Stress: " + e.getMessage());
    }
  }
}

class HttpServerSession extends Thread
{
  private Socket client;


  public HttpServerSession(Socket client)
  {
    client = client;
  }
}
