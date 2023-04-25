import java.io.*;
import java.net.URL;
import java.net.URLConnection;

public class App {

    public static void main(String[] args) throws Exception {

        File file = new File("testfile.html");
        String str = urlReader("http://inslaguineueta.cat");

        saveToFile(str, file, true);

        System.out.println(readFromFile(file));
    }

    static String readFromFile(File file) throws IOException {

        FileReader fr = new FileReader(file);
        BufferedReader bufr = new BufferedReader(fr);
        StringBuilder sb = new StringBuilder();
        String line;
        while((line = bufr.readLine()) != null){
            sb.append(line);
        }
        bufr.close();
        return sb.toString();

    }

    static void saveToFile(String str, File file, boolean append)
            throws IOException {

        FileWriter fw = new FileWriter(file, true);
        BufferedWriter bufw = new BufferedWriter(fw);

        bufw.write(str);

        bufw.close();

    }

    public static String urlReader(String url) throws Exception {
            URL oracle = new URL(url);
            URLConnection yc = oracle.openConnection();
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(
                            yc.getInputStream()));
            String inputLine;
            StringBuilder sb = new StringBuilder();
            while ((inputLine = in.readLine()) != null)
                sb.append(inputLine);
            in.close();
            return sb.toString();
    }

}

