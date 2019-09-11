package io.quarkus.compstage;

import org.eclipse.microprofile.rest.client.inject.RestClient;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.concurrent.CompletionStage;

@Path("/compstage")
public class CompStageResource {
    @RestClient
    private MessageService greetings;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public CompletionStage<String> greeting() {
        return greetings.get();
    }
}
