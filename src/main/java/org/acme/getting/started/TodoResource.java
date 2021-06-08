package org.acme.getting.started;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("/todo")
public class TodoResource {

    TodoService todoService;

    public TodoResource(TodoService todoService) {
        this.todoService = todoService;
    }

    @POST
    @Path("/item")
    public Response addItem(TodoItem item) {
        todoService.addItem(item);
        return Response.ok().build();
    }

}
