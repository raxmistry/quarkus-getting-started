package org.acme.getting.started;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.MediaType;
import com.fasterxml.jackson.databind.ObjectMapper;

@Path("/hello")
public class GreetingResource {

    @Inject
    GreetingService greetingService;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "Hello RESTEasy";
    }

    @Path("/greeting/{name}")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String greeting(@PathParam("name") String name) {
        return greetingService.greeting(name);
    }

    @Path("/json")
    @GET
    public Response json() {
        return Response.ok(new JsonTest("value")).build();
    }
}

class JsonTest {
    String blah;

    public JsonTest() {

    }

    public JsonTest(String blah) {
        this.blah = blah;
    }

    public String getBlah() {
        return blah;
    }
}