import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Handler implements URLHandler {
    // The one bit of state on the server: a number that will be manipulated by
    // various requests.
    ArrayList StringList = new ArrayList<String>();

    public String handleRequest(URI url) {
        if (url.getPath().equals("/")) {
            return StringList.toString();
        } else if (url.getPath().equals("/addString")) {
            StringList.add("NewString");
            return String.format("String added!");
        } else {
            // Adding a String
            System.out.println("Path: " + url.getPath());
            if (url.getPath().contains("/adding")) {
                String[] parameters = url.getQuery().split("=");
                if (parameters[0].equals("s")) {
                    StringList.add((String)parameters[1]);
                    return "String: " + parameters[1] + " has been added";
                }
            }
            // Finding which Strings contain the query
            else if (url.getPath().contains("/find")) {
                String[] parameters = url.getQuery().split("=");
                if (parameters[0].equals("s")) {
                    ArrayList<String> returning = new ArrayList<String>();
                    for (int i = 0; i < StringList.size(); i++) {
                        String check = (String)StringList.get(i);
                        if (check.contains((String)parameters[1])) {
                            returning.add(check);
                        }
                    }
                    return returning.toString();
                }
            }
            return "404 Not Found!";
        }
    }
}

class SearchEngine {
    public static void main(String[] args) throws IOException {
        if(args.length == 0){
            System.out.println("Missing port number! Try any number between 1024 to 49151");
            return;
        }

        int port = Integer.parseInt(args[0]);

        Server.start(port, new Handler());
    }
}
