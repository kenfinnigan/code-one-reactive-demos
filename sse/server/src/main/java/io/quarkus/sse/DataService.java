package io.quarkus.sse;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import java.util.concurrent.CompletionStage;

@Path("/data")
@RegisterRestClient
public interface DataService {
    @GET
    CompletionStage<Long> call();
}
