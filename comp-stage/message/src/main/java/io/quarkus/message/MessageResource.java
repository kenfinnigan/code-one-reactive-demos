package io.quarkus.message;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.atomic.AtomicInteger;

@Path("/msg")
@ApplicationScoped
public class MessageResource {
    private AtomicInteger count = new AtomicInteger(0);

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public CompletionStage<String> message() {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "Greetings from CompletionStage! [" + count.getAndIncrement() + "]\n";
        });
    }
}
