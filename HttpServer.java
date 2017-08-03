import java.net.*;
import java.io.*;
import java.util.*;
class HttpServer
{
  public static void main(String args[])
  {
    // test 001
    if (args.length != 1)
    {
      System.err.println("Usage: <portnum>");
      return;
    }

    //test 002
    int portNum = Integer.parseInt(args[0]);

    if (portNum < 1024)
    {
      System.err.println("Port number cannot be less than 1024");
      return;
    }


    try
    {
      ServerSocket server = new ServerSocket(portNum);
      System.out.println("web server starting");
    }
    catch(IOException e)
    {
      System.err.println("Stress: " + e.getMessage());
    }
  }
}
