import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ThreadLocalRandom;
import java.util.logging.Level;
import java.util.logging.Logger;

// Server class
class Server {
    static Logger logger;
    static {
        logger = Logger.getLogger(Server.class.getName());
    }
    public static void main(String[] args)
    {
        ServerSocket server = null;

        try {

            // server is listening on port 1234
            server = new ServerSocket(1234);
            server.setReuseAddress(true);
            logger.log(Level.INFO,"Server connected at port 1234");
            // running infinite loop for getting
            // client request
            while (true) {

                // socket object to receive incoming client
                // requests
                Socket client = server.accept();

                // Displaying that new client is connected
                // to server
                logger.log(Level.INFO,"New client connected"
                        + client.getInetAddress()
                        .getHostAddress());

                // create a new thread object
                ClientHandler clientSock
                        = new ClientHandler(client);

                // This thread will handle the client
                // separately
                new Thread(clientSock).start();
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            if (server != null) {
                try {
                    server.close();
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    // ClientHandler class
    public static class ClientHandler implements Runnable {
        private final Socket clientSocket;
        //map containing clientID and price sorted based on the basis of message
        ConcurrentMap<Integer,Double> buyingBook = new ConcurrentHashMap<>();
        ConcurrentMap<Integer,Double> sellingBook = new ConcurrentHashMap<>();
        PrintWriter out = null;
        BufferedReader in = null;
        // Constructor
        public ClientHandler(Socket socket)
        {
            this.clientSocket = socket;
        }
        private void matchingEngine(int clientID, double price) {
            if(buyingBook.containsKey(clientID)){
                buyingBook.remove(clientID,price);
                out.println("Trade successful");
                logger.log(Level.INFO,"Trade successful");
            }else{
                out.println("Trade unsuccessful");
                logger.log(Level.INFO,"Trade unsuccessful");


            }
        }
        public void run()
        {
            int minClientId = 10000;
            int maxClientId = 99999;
            int clientID;
            clientID = ThreadLocalRandom.current().nextInt(minClientId, maxClientId+1);

            try {

                // get the outputstream of client
                out = new PrintWriter(
                        clientSocket.getOutputStream(), true);

                // get the inputstream of client
                in = new BufferedReader(
                        new InputStreamReader(
                                clientSocket.getInputStream()));

                String line1;
                String line2;


                   line1 = in.readLine();

                   // writing the received message from
                   // client
                   System.out.printf(" Sent from the client: %s\n", line1);
                   out.println(clientID);

                   List<String> commands = new ArrayList<>(Arrays.asList(line1.split(",")));
                   System.out.println(commands);
                   System.out.println(commands.get(0).getClass());
                   if (commands.get(0).equalsIgnoreCase("new")) {
                       double price = Double.parseDouble(commands.get(1));
                       buyingBook.put(clientID, price);
                       out.println("Bought successfully");
                       logger.log(Level.INFO,"Bought successfully");
                   } else if (commands.get(0).equalsIgnoreCase("cancel")) {
                       double price = Double.parseDouble(commands.get(1));
                       matchingEngine(clientID, price);

                   }



            }
            catch (IOException e) {
                e.printStackTrace();
            }
            finally {
                try {
                    if (out != null) {
                        out.close();
                    }
                    if (in != null) {
                        in.close();
                        clientSocket.close();
                    }
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }
}