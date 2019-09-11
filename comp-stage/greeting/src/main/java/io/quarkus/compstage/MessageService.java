package io.quarkus.compstage;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.concurrent.CompletionStage;

@Path("/msg")
@RegisterRestClient
public interface MessageService {
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    CompletionStage<String> get();
}
