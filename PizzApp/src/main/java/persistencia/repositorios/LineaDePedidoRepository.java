package persistencia.repositorios;

import modelo.LineaDePedido;
import modelo.Pedido;
import modelo.TestUno;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate4.HibernateCallback;

import java.util.List;

public class LineaDePedidoRepository
        extends HibernateGenericDAO<LineaDePedido>
        implements GenericRepository<LineaDePedido> {

    @Override
    protected Class<LineaDePedido> getDomainClass() {
        return null;
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    public List<LineaDePedido> findByPedido(Pedido pedido){
        return (List<LineaDePedido>) this.getHibernateTemplate().execute(new HibernateCallback() {
            @Override
            public List<LineaDePedido> doInHibernate(final Session session) throws HibernateException {
                Criteria criteria = session.createCriteria(TestUno.class);
                criteria.add(Restrictions.eq("pedido", "%" + pedido + "%"));
                return (List<LineaDePedido>)criteria.uniqueResult();
            }

        });
    }
}
