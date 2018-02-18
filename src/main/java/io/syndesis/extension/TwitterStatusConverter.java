package io.syndesis.extension;

import io.syndesis.extension.api.annotations.Action;
import io.syndesis.extension.api.annotations.DataShape;

import org.apache.camel.Body;
import org.apache.camel.Handler;

@Action(
    id = "status-converter",
    name = "status-converter",
    description = "status-converter",
    inputDataShape = @DataShape(
        type = "java:twitter4j.Status"
    ),
    outputDataShape = @DataShape(
        kind = "java", 
        type = "io.syndesis.extension.TwitterUser"
    )
)
public class TwitterStatusConverter {
    @Handler
    public TwitterUser convert(@Body twitter4j.Status status) {
        TwitterUser user = new TwitterUser();
        user.setName(status.getUser().getName());

        return user;
    }
}
