package controllers;
import com.google.gson.*;
import java.io.IOException;
import java.lang.reflect.Type;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.HashMap;

import com.google.gson.reflect.TypeToken;
import models.Id;


public class IdController {
    String serverIdsUrl = "http://zipcode.rocks:8085/ids";
    private HashMap<String, Id> allIds;


    Id myId;

    public IdController() {
    }

    public ArrayList<Id> getIds() {
        try {
        Gson gson = new Gson();

        ArrayList<Id> allServerIds;
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(serverIdsUrl))
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        Type serverIdsListType = new TypeToken<ArrayList<Id>>(){}.getType();
        allServerIds = gson.fromJson(response.body(), serverIdsListType);

        return allServerIds;
        }catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    public static void main(String[] args) {
        IdController idc = new IdController();
        System.out.println(idc.getIds());
    }

    public Id postId(Id id) {
        // create json from id
        // call server, get json result Or error
        // result json to Id obj

        return null;
    }

    public Id putId(Id id) {
        return null;
    }
 
}