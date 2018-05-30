package modelo;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="testUno")
public class TestUno extends Entity{

    private String uno;

    public TestUno(){}

    public TestUno(String test){
        this.uno=test;
    }

    public String getUno() {
        return uno;
    }

    public void setUno(String uno) {
        this.uno = uno;
    }
}
