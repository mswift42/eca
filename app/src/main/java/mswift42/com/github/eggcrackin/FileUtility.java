package mswift42.com.github.eggcrackin;


import android.content.Context;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStreamReader;

public class FileUtility {
    private static final String savedFavourites = "favourites.json";

    public static void writeToFile(Context context, String content) {
        FileOutputStream outputStream;
        try {
            outputStream = context.getApplicationContext()
                    .openFileOutput(savedFavourites, Context.MODE_PRIVATE);
            outputStream.write(content.getBytes());
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String restoreFromFile(Context context) throws FileNotFoundException {
        try {
            FileInputStream fi = context.getApplicationContext()
                    .openFileInput(savedFavourites);
            InputStreamReader isr = new InputStreamReader(fi);
            BufferedReader br = new BufferedReader(isr);
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }
            return sb.toString();
        } catch (Exception e) {
            throw new FileNotFoundException();
        }
    }

}



