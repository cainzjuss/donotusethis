package workffs

import io.micronaut.context.annotation.Factory
import io.vertx.reactivex.pgclient.PgPool
//import io.vertx.pgclient.PgPool
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get

@Factory
class DatabaseService {
    private final PgPool client

    DatabaseService(PgPool client) {
        this.client = client
    }

    void performQuery() {
	    client.query("SELECT * FROM books").execute().onComplete(ar -> {
        if (ar.succeeded()) {
            System.out.println("Database connection successful");
        } else {
            System.out.println("Database connection failed");
            ar.cause().printStackTrace();
        }
    });
	}
}

@Controller("/books")
class AllBooks{
	private final DatabaseService databaseService

    AllBooks(DatabaseService databaseService) {
        this.databaseService = databaseService
    }

    @Get("/all")
    void getAllBooks() {
        databaseService.performQuery()
    }
}