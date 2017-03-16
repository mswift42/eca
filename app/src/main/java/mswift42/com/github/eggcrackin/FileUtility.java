package mswift42.com.github.eggcrackin;


import android.content.Context;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;

public class FileUtility {
    Context mContext;
    FileOutputStream outputStream;
    String savedFavourites = "favourites.json";

    FileUtility(Context context) {
        mContext = context;
    }

    public void writeToFile(String content) {
        try {
            outputStream = mContext.getApplicationContext()
                    .openFileOutput(savedFavourites, Context.MODE_PRIVATE);
            outputStream.write(content.getBytes());
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String restoreFromFile(String content) throws FileNotFoundException {
        try {
            FileInputStream fi = mContext.getApplicationContext()
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



