package com.first.firstspringbootproject.user;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.*;
import com.google.firebase.cloud.FirestoreClient;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutionException;

@Service
public class UserService {
    public static final String COL_NAME="users";


    public Integer userExists(User user) throws InterruptedException, ExecutionException {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        CollectionReference usersRef = dbFirestore.collection("users");

        DocumentReference documentReference = dbFirestore.collection(COL_NAME).document(user.getUsername());
        ApiFuture<DocumentSnapshot> future = documentReference.get();
        DocumentSnapshot document = future.get();

        // Create a query to search for documents with a matching email field
        Query query = usersRef.whereEqualTo("email", user.getEmail());

        // Get the first matching document, if any
        DocumentSnapshot document_ = query.get().get().getDocuments().stream().findFirst().orElse(null);

        if (document.exists()){
            return 1;
        }else if(document_ != null){
            return 2;
        }
        return 0;
    }
    public String saveUser(User user) throws InterruptedException, ExecutionException {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> collectionsApiFuture = dbFirestore.collection(COL_NAME).document(String.valueOf(user.getUsername())).set(user);
        return collectionsApiFuture.get().getUpdateTime().toString();
    }
    public String loginUser(User user) throws InterruptedException, ExecutionException {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        DocumentReference documentReference = dbFirestore.collection(COL_NAME).document(user.getUsername());
        ApiFuture<DocumentSnapshot> future = documentReference.get();
        DocumentSnapshot document = future.get();
        return "w";

    }

    public String updateUser(User user) throws InterruptedException, ExecutionException {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> collectionsApiFuture = dbFirestore.collection(COL_NAME).document(String.valueOf(user.getUsername())).set(user);
        return collectionsApiFuture.get().getUpdateTime().toString();
    }
    public String deleteUser(String username) {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> writeResult = dbFirestore.collection(COL_NAME).document(username).delete();
        return "Document with username "+username+" has been deleted";
    }

}
