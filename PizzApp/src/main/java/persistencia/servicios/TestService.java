package persistencia.servicios;

import modelo.TestUno;
import org.springframework.transaction.annotation.Transactional;
import persistencia.repositorios.TestRepository;

public class TestService extends GenericService<TestUno>{

    private TestRepository repository;

    public TestRepository getRepository() {
        return repository;
    }

    public void setRepository(TestRepository testRepository) {
        this.repository = testRepository;
    }

    @Transactional
    public TestUno filterUno(final String pattern){
        return this.getRepository().filterUno(pattern);
    }
}
