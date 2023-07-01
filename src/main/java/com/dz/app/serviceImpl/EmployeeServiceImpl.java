package com.dz.app.serviceImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.orm.hibernate5.HibernateTemplate;

import com.dz.app.model.entity.Employee;
import com.dz.app.service.EmployeeService;



/**
 * @author dz Jun 30, 2023
 *
 */


public class EmployeeServiceImpl implements EmployeeService {

	private HibernateTemplate template;
	
	@Transactional
	@Override
	public Employee saveEmployee(Employee employee) {
		this.template.save(employee);
		return employee;
	}

	@Transactional
	@Override
	public void updateEmployee(Employee empTrn) {
		this.template.update(empTrn);
	}

	@Transactional
	@Override
	public void deleteEmployee(Employee empTrn) {
		this.template.delete(empTrn);
	}

	@Override
	public Employee findById(long eid) {
		Employee emp=this.template.get(Employee.class, eid);
		return emp;
	}

	@Override
	public List<Employee> getAllEmployees() {
		List<Employee> employees=this.template.loadAll(Employee.class);
		return employees;
	}

	public HibernateTemplate getTemplate() {
		return template;
	}

	public void setTemplate(HibernateTemplate template) {
		this.template = template;
	}
	
	/*static Employee employee=null;
	static Session session=null;
	static Transaction tx=null;
	static Integer rs=0;
	List<Employee> employees = new ArrayList<Employee>();
	
	@Override
	public Employee saveEmployee(Employee employee) {
		
		try(Session session = Factory.getSessionFactory().openSession()) {
			
			tx = session.beginTransaction();
			
			SQLQuery query = session.createSQLQuery("SELECT * FROM adpemployee a where a.firstname='"+ employee.getFirstName() + "' and a.lastname='" + employee.getLastName() + "'");
			Object obj = query.uniqueResult();
			if (obj == null) {
				session.save(employee);
			}
			session.save(employee);
			tx.commit();

		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
			throw e;
		} 
		return employee;
	}

	@Override
	public Employee updateEmployee(Employee employee) {
		
	try(Session session = Factory.getSessionFactory().openSession()) {
			
			tx = session.beginTransaction();
			session.update(employee);
			tx.commit();

		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
			throw e;
		} 
		return employee;
	}

	@Override
	public void deleteEmployee(Employee empTrn) {
		
		try(Session session = Factory.getSessionFactory().openSession()) {
			
			tx = session.beginTransaction();
			session.delete(employee);
			tx.commit();

		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public Employee findById(long eid) {
		
		try(Session session = Factory.getSessionFactory().openSession()) {
			
			tx = session.beginTransaction();
			employee=session.get(Employee.class,eid);
			tx.commit();

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return employee;
	}

	@Override
	public List<Employee> getAllEmployees() {
		
		try(Session session = Factory.getSessionFactory().openSession()) {
			
			Criteria criteria=session.createCriteria(Employee.class);
			employees=criteria.list();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return employees;
	}

	@Override
	public void deleteAll() {
		
		try(Session session = Factory.getSessionFactory().openSession()) {
			
			tx = session.beginTransaction();
			
			SQLQuery query =session.createSQLQuery("delete from AdpEmployee");
			Object obj = query.executeUpdate();
			
			tx.commit();

		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
			throw e;
		}
		
	}
*/	
}
