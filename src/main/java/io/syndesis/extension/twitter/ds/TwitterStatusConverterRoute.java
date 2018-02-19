package io.syndesis.extension.twitter.ds;

import org.apache.camel.builder.RouteBuilder;

import io.syndesis.extension.api.annotations.Action;
import io.syndesis.extension.api.annotations.DataShape;

@Action(
    id = "status-converter-route",
    name = "status-converter-route",
    description = "status-converter-route",
    entrypoint = "direct:twitter-status-converter",
    inputDataShape = @DataShape(
        type = "java:twitter4j.Status"
    ),
    outputDataShape = @DataShape(
        kind = "java", 
        type = "io.syndesis.extension.twitter.ds.TwitterUser"
    )
)
public class TwitterStatusConverterRoute extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        from("direct:twitter-status-converter")
            .transform().body(twitter4j.Status.class, status -> {
                TwitterUser user = new TwitterUser();
                user.setName(status.getUser().getName());

                return user;
            });
    }
}
