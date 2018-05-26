package persistencia.servicios;

import modelo.TestUno;
import persistencia.servicios.dto.TestDTO;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

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
    public Response getUno(@PathParam("uno") final String uno){
        TestUno testUno = this.getTestService().filterUno(uno);
        if(testUno==null){
            throw new NotFoundException("el elemento buscado no existe");
        }
        return Response.ok(toDTO(testUno)).build();
    }

    @POST
    @Path("/put")
    @Produces("application/json")
    @Consumes("application/json")
    public Response putUno(TestDTO testUno){
        this.getTestService().save(fromDTO(testUno));
        return Response.ok(testUno).build();
    }

    private TestDTO toDTO(TestUno testUno) {
        TestDTO dto = new TestDTO();
        dto.setUno(String.valueOf(testUno.getUno()));
        return dto;
    }

    private TestUno fromDTO(TestDTO dto){
        TestUno testUno = new TestUno();
        testUno.setUno(dto.getUno());
        return testUno;
    }
}
