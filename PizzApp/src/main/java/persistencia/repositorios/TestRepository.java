package persistencia.repositorios;

import modelo.TestUno;

public class TestRepository
        extends HibernateGenericDAO<TestUno>
        implements GenericRepository<TestUno> {


    @Override
    protected Class<TestUno> getDomainClass() {
        return TestUno.class;
    }
}
