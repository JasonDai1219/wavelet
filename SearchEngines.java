import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;

class Search implements URLHandler {
    // The one bit of state on the server: a number that will be manipulated by
    // various requests.
    ArrayList<String> Store_list = new ArrayList<>();

    public String handleRequest(URI url) {
        if (url.getPath().equals("/")) {
            return store_list1.toString();
        }
        else {
            System.out.println("Path: " + url.getPath());
            if (url.getPath().contains("/search")) {
                ArrayList<String> store_list2 = new ArrayList<String>();
                String[] elements = url.getQuery().split("=");
                if(elements[0].equals("s")) {
                    for(String s: stringList) {
                        if (s.toUpperCase().contains(elements[1].toUpperCase())) {
                            store_list2.add(s);
                        }
                    }
                    return store_list2.toString();
                }
            }
            elif (url.getPath().contains("/add")) {
                String[] store_list3 = url.getQuery().split("=");
                if (store_list3[0].equals("s")) {
                    store_list1.add(store_list3[1]);
                    return store_list.toString();
                }
                ArrayList<String> store_list = new ArrayList<String>();
                store_list.add(parameters[1]);
                

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

        Server.start(port, new Search());
    }
}