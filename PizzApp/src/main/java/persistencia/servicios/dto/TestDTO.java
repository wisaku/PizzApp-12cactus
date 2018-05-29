package persistencia.servicios.dto;

public class TestDTO {

    private String uno;

    public TestDTO(){}

    public TestDTO(String test){
        this.uno=test;
    }

    public String getUno() {
        return uno;
    }

    public void setUno(String uno) {
        this.uno = uno;
    }
}
