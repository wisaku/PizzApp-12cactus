package persistencia.repositorios;

import modelo.TestUno;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate4.HibernateCallback;
import org.springframework.stereotype.Repository;

@Repository
public class TestRepository
        extends HibernateGenericDAO<TestUno>
        implements GenericRepository<TestUno> {


    @Override
    protected Class<TestUno> getDomainClass() {
        return TestUno.class;
    }


    @SuppressWarnings({ "unchecked", "rawtypes" })
    public TestUno filterUno(final String pattern) {

        return (TestUno) this.getHibernateTemplate().execute(new HibernateCallback() {
            @Override
            public TestUno doInHibernate(final Session session) throws HibernateException {
                Criteria criteria = session.createCriteria(TestUno.class);
                criteria.add(Restrictions.like("uno", "%" + pattern + "%"));
                return (TestUno)criteria.uniqueResult();
            }

        });
    }
}
