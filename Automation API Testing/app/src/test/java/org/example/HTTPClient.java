package org.example;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import java.io.IOException;

public class HTTPClient {
     // Membuat instance OkHttpClient
     private static final OkHttpClient client = new OkHttpClient();

     // Method untuk melakukan GET request
     public static String sendGetRequest(String url) throws IOException {
         Request request = new Request.Builder()
                 .url(url) // URL yang akan dipanggil
                 .build();
 
         // Melakukan request dan mendapatkan response
         try (Response response = client.newCall(request).execute()) {
             if (!response.isSuccessful()) {
                 throw new IOException("Unexpected code " + response);
             }
             return response.body().string(); // Mengambil isi response sebagai string
         }
     }
}
