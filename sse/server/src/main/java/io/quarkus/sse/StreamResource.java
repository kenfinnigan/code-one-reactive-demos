package io.quarkus.sse;

import io.reactivex.Flowable;
import org.eclipse.microprofile.reactive.streams.operators.PublisherBuilder;
import org.eclipse.microprofile.reactive.streams.operators.ReactiveStreams;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.reactivestreams.Publisher;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.concurrent.TimeUnit;

@Path("/stream")
public class StreamResource {
    @RestClient
    DataService client;

    @GET
    @Produces(MediaType.SERVER_SENT_EVENTS)
    public Publisher<Long> stream() {
        PublisherBuilder<Long> ticks = ReactiveStreams.fromPublisher(Flowable.interval(1, TimeUnit.SECONDS));
        ticks.flatMapCompletionStage(x -> client.call());
        return Flowable.fromPublisher(ticks.buildRs()).repeat();
    }

}
