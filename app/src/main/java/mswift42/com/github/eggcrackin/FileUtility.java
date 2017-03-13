package mswift42.com.github.eggcrackin;


import android.content.Context;

import java.io.FileOutputStream;

public class FileUtility {
   Context mContext;
   FileOutputStream outputStream;
   String savedFavourites = "favourites.json";

   FileUtility(Context context) {
      mContext = context;
   }

   public void writeToFile(String content) {
      try {
         outputStream = mContext.getApplicationContext().openFileOutput(savedFavourites, Context.MODE_PRIVATE);
         outputStream.write(content.getBytes());
         outputStream.close();
      } catch (Exception e) {
         e.printStackTrace();
      }
   }

}
