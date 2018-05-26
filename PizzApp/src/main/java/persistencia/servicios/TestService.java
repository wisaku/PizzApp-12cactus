package persistencia.servicios;

import modelo.TestUno;
import org.springframework.transaction.annotation.Transactional;
import persistencia.repositorios.TestRepository;

public class TestService extends GenericService<TestUno>{

    private TestRepository testRepository;

    public TestRepository getTestRepository() {
        return testRepository;
    }

    public void setTestRepository(TestRepository testRepository) {
        this.testRepository = testRepository;
    }

    @Transactional
    public TestUno filterUno(final String pattern){
        TestUno testUno = this.getTestRepository().filterUno(pattern);
        return testUno;
    }
}
