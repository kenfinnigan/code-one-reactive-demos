package io.quarkus.sse;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.atomic.AtomicLong;

@Path("/data")
@ApplicationScoped
public class DataResource {
    private AtomicLong count = new AtomicLong(1);

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public CompletionStage<Long> get() {
        return CompletableFuture.supplyAsync(() -> count.getAndIncrement());
    }
}
