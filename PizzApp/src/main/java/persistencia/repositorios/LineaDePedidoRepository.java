package persistencia.repositorios;

import modelo.LineaDePedido;
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
    public List<LineaDePedido> findByPedido(int id){
        return (List<LineaDePedido>) this.getHibernateTemplate().execute(new HibernateCallback() {
            @Override
            public List<LineaDePedido> doInHibernate(final Session session) throws HibernateException {
                Criteria criteria = session.createCriteria(LineaDePedido.class);
                criteria.add(Restrictions.eq("pedido.id", id ));
                return (List<LineaDePedido>)criteria.list();
            }

        });
    }
}
