import java.io.*;
import java.net.*;
import java.util.*;

// Client class
class Client {

    // driver code
    public static void main(String[] args)
    {
        // establish a connection by providing host and port
        // number
        try (Socket socket = new Socket("localhost", 1234)) {

            // writing to server
            PrintWriter out = new PrintWriter(
                    socket.getOutputStream(), true);

            // reading from server
            BufferedReader in
                    = new BufferedReader(new InputStreamReader(
                    socket.getInputStream()));

            // object of scanner class
            Scanner sc = new Scanner(System.in);
            String line1 = null;
            String line2 = null;

                //reading the type of transaction to be made
                System.out.println("Enter message(1.new order(type new) or 2.cancel order(type cancel),price");
                System.out.println("Enter 'exit' for stopping the process");
                // reading from user
                line1 = sc.nextLine();

                // sending the user input to server
                out.println(line1);
                out.flush();

                // displaying server reply
                System.out.println("Client ID:" + in.readLine());
                System.out.println(in.readLine());
                // closing the scanner object
                sc.close();

        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}