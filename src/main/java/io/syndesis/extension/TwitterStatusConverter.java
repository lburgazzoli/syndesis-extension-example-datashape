package io.syndesis.extension;

import io.syndesis.integration.runtime.api.SyndesisExtensionAction;
import org.apache.camel.Body;
import org.apache.camel.Handler;

@SyndesisExtensionAction(
    id = "status-converter",
    name = "status-converter",
    description = "status-converter",
    inputDataShape = "java:twitter4j.Status",
    outputDataShape = "java:io.syndesis.extension.TwitterUser"
)
public class TwitterStatusConverter {
    @Handler
    public io.syndesis.extension.TwitterUser convert(@Body twitter4j.Status status) {
        TwitterUser user = new TwitterUser();
        user.setName(status.getUser().getName());

        return user;
    }
}
