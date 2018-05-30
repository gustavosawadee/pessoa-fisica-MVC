package persistence;
import java.util.List;
//import java.util.logging.Logger;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.jboss.logging.Logger;
import model.PessoaFisica;

public class PessoaHibernateDAO<T> implements IDAO<T>{

	Logger logger = Logger.getLogger(PessoaHibernateDAO.class.getName());
	private Transaction currentTransaction;
	Session session;
	
	public PessoaHibernateDAO(Session session) {
		this.session = session;
	}
	
	public int encontrarPeloNome(String nome) {
		logger.info("public int encontrarPeloNome(String nome) {...");
		CriteriaBuilder cB = this.session.getCriteriaBuilder();
		CriteriaQuery<PessoaFisica> qry = cB.createQuery(PessoaFisica.class);
		Root<PessoaFisica> from = qry.from(PessoaFisica.class);
		qry.select(from);
		qry.where(cB.and(
				cB.equal(from.get("nome"), nome)//,cB.equal(from.get("OutroCampo"), vlrParaProcurar)
		));
		Query<PessoaFisica> createdQuery = session.createQuery(qry);
		List<PessoaFisica> resultList = createdQuery.getResultList();
		return resultList.size();
	}

	public void persistir(T o){
		// TODO Auto-generated method stub
		session.save(o);
	}
	
	public void excluiTodos() {
		CriteriaBuilder cB = this.session.getCriteriaBuilder();
		CriteriaDelete<PessoaFisica> qryDelete = cB.createCriteriaDelete(PessoaFisica.class);
		Root<PessoaFisica> deleteFrom = qryDelete.from(PessoaFisica.class);
		this.session.createQuery(qryDelete).executeUpdate();
	}
	
	public List<T> Listar() {
		CriteriaBuilder cB = this.session.getCriteriaBuilder();
		CriteriaQuery<PessoaFisica> qry = cB.createQuery(PessoaFisica.class);
		qry.select(qry.from(PessoaFisica.class));
		Query<T> createdQuery = (Query<T>) this.session.createQuery(qry);
		return createdQuery.getResultList();
	}

	public void alterar(T e){
		// TODO Auto-generated method stub
		this.session.merge(e);
	}
	
	public void excluir(Integer id){
		// TODO Auto-generated method stub
		this.session.remove(id);
	}

	public T encontraPeloID(Integer id){
		// TODO Auto-generated method stub
		return (T) this.session.byId(PessoaFisica.class).load(id);
	}
	
	public void closeSession() {
		this.session.close();
	}
	public void beginTransaction() {
		this.currentTransaction = this.session.beginTransaction();
	}
	public void commit() {
		this.currentTransaction.commit();
	}

	public void alterar(Integer id) throws Exception {
		// TODO Auto-generated method stub
		
	}
}