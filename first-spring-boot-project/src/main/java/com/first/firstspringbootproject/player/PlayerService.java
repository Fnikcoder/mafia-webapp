package com.first.firstspringbootproject.player;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.*;
import com.google.firebase.cloud.FirestoreClient;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

@Service
public class PlayerService {
    public static final String COL_NAME="players";

    public List<Player> getAllPlayersDetails() throws InterruptedException, ExecutionException {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        ApiFuture<QuerySnapshot> players = dbFirestore.collection(COL_NAME).get();
        List<Player> playerList=new ArrayList<>();
        int i = 0;
        for (QueryDocumentSnapshot documentReference : players.get()){
            i++;
            Player player = documentReference.toObject(Player.class);
            playerList.add(player);
//            if(i==3) break;

        }

        return playerList;



//        document
//        Player player = null;
//
//        if(document.exists()) {
//            player = document.toObject(Player.class);
//            return player;
//        }else {
//            return null;
//        }
    }

    public String getPlayerDetails(String id) throws InterruptedException, ExecutionException {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        DocumentReference documentReference = dbFirestore.collection(COL_NAME).document(id);
        ApiFuture<DocumentSnapshot> future = documentReference.get();
        DocumentSnapshot document = future.get();

        Player player = null;

        if(document.exists()) {
            player = document.toObject(Player.class);
            return String.valueOf(player);
        }else {
            return null;
        }
    }

    public String savePlayer(Player player) throws InterruptedException, ExecutionException {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> collectionsApiFuture = dbFirestore.collection(COL_NAME).document(String.valueOf(player.getChat_id())).set(player);
        return collectionsApiFuture.get().getUpdateTime().toString();
    }
    public String updatePlayer(Player player) throws InterruptedException, ExecutionException {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> collectionsApiFuture = dbFirestore.collection(COL_NAME).document(String.valueOf(player.getChat_id())).set(player);
        return collectionsApiFuture.get().getUpdateTime().toString();
    }
    public String deletePlayer(String id) {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> writeResult = dbFirestore.collection(COL_NAME).document(id).delete();
        return "Document with Player ID "+id+" has been deleted";
    }

}
