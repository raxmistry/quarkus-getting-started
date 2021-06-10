package org.acme.getting.started;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import java.util.UUID;

@Path("/todo")
public class TodoResource {

    TodoService todoService = new TodoService(new InMemoryItemsRepository());

    public TodoResource() {
    }

    @POST
    @Path("/item")
    public Response addItem(TodoItemDto item) {
        UUID uuid = todoService.addItem(new TodoItem(item.description));
        return Response.ok(uuid).build();
    }

}
