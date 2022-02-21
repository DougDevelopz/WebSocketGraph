package dev.wsgraph;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ThreadLocalRandom;

public class CustomServerSocketController {

    private CustomSocketServer socketServer;
    private final Gson gson = new Gson();

    public CustomServerSocketController(int port) {
        CompletableFuture.runAsync(() -> {
            socketServer = new CustomSocketServer(port);
            socketServer.run();
        });
    }

    public void transferData() {
        System.out.println("Data has transferred");
        JsonElement parent = new JsonObject();
        JsonObject jsonObject = parent.getAsJsonObject();
        jsonObject.addProperty("Number One", ThreadLocalRandom.current().nextInt(1, 5));
        jsonObject.addProperty("Number Two", ThreadLocalRandom.current().nextInt(6, 10));
        socketServer.broadcast(gson.toJson(parent));
    }
}
