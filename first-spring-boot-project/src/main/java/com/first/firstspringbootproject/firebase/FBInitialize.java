package com.first.firstspringbootproject.firebase;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.Firestore;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.FirestoreClient;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.FileInputStream;
import java.io.InputStream;

@Service
public class FBInitialize {

    @PostConstruct
    public void initialize() {
        try {
            InputStream serviceAccount = new FileInputStream("src/main/resources/striped-micron-310912-f34876a5b382.json");
            GoogleCredentials credentials = GoogleCredentials.fromStream(serviceAccount);
            FirebaseOptions options = new FirebaseOptions.Builder()
                    .setCredentials(credentials)
                    .build();
            FirebaseApp.initializeApp(options);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
