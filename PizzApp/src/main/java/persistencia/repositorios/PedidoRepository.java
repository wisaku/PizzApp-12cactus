package persistencia.repositorios;

import modelo.Pedido;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate4.HibernateCallback;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PedidoRepository
        extends HibernateGenericDAO<Pedido>
        implements GenericRepository<Pedido> {

    @Override
    protected Class<Pedido> getDomainClass() {
        return Pedido.class;
    }

    @SuppressWarnings({"unchecked", "rawtypes"})
    public List<Pedido> getPedidoPorIDCliente(final String pattern) {

        return (List<Pedido>) this.getHibernateTemplate().execute((HibernateCallback) session -> {
            Criteria criteria = session.createCriteria(Pedido.class, "pedido").createAlias("pedido.cliente", "cliente");
            criteria.add(Restrictions.eq("cliente.telefono", pattern));

            return  criteria.list();


        });
    }
}
