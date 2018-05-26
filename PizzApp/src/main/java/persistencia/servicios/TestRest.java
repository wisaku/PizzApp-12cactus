package persistencia.servicios;

import modelo.TestUno;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

@Path("/testRest")
public class TestRest {

    private TestService testService;

    public TestService getTestService() {
        return testService;
    }

    public void setTestService(TestService testService) {
        this.testService = testService;
    }

    @GET
    @Path("/get/{uno}")
    @Produces("application/json")
    public TestUno getUno(@PathParam("uno") final String uno){
        return this.getTestService().filterUno(uno);
    }
}
