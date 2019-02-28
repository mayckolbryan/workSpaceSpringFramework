/**
 * 
 */
package com.mitocode.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import javax.management.RuntimeErrorException;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mitocode.model.Persona;

/**
 * @author BRYAN
 *
 */
//@Repository es un estereotipo que le indica a spring que esta clase va a representar un acceso a datos, necesario para la inyeccion de dependecias, se almacena en el core container. (Esteoritipo Repository) 
@Repository
public class PersonaDAOImpl extends JdbcDaoSupport implements IPersonaDAO{
	
//	@Autowired
//	private DataSource dataSource;
	
	@Autowired
	public PersonaDAOImpl(DataSource dataSource){
		this.setDataSource(dataSource);
	}
	
	@Override
	public void create(Persona persona) {
		String sql = "INSERT INTO PERSONA(NOMBRES, APELLIDOS) VALUES(?,?)";
		
		//Usando JDBC
//		try (Connection conexion = dataSource.getConnection()){
//			PreparedStatement ps = conexion.prepareStatement(sql);
//			ps.setString(1, persona.getNombres());
//			ps.setString(2, persona.getApellidos());
//			ps.executeUpdate();
//			ps.close();
//			System.out.println("Insertó correctamente: " + persona);
//		} catch (SQLException e) {
//			throw new RuntimeException(e);
//		}
		
		//Usando Spring JDBC Templates
		//.update utilizado para las consultas DML.
		this.getJdbcTemplate().update(sql, new Object[] {persona.getNombres(), persona.getApellidos()});
		
		System.out.println("Persona creada " + persona.getNombres());
	}

	@Override
	public void update(Persona persona) {
		String sql = "UPDATE PERSONA SET NOMBRES = ?, APELLIDOS = ? WHERE ID = ?";
		this.getJdbcTemplate().update(sql, new Object[] {persona.getNombres(), persona.getApellidos(), persona.getId()});
	}

	@Override
	public List<Persona> listAll() {
		String sql = "SELECT ID, NOMBRES, APELLIDOS FROM PERSONA ORDER BY NOMBRES, APELLIDOS";
		List<Persona> lista = getJdbcTemplate().query(sql, new BeanPropertyRowMapper<Persona>(Persona.class));
		return lista;
	}

	@Override
	public Persona find(Integer id) {
		String sql = "SELECT ID, NOMBRES, APELLIDOS FROM PERSONA WHERE ID = ?";
		Persona persona = (Persona)getJdbcTemplate().queryForObject(sql, new Object[] {id}, new BeanPropertyRowMapper<Persona>(Persona.class));
		return persona;
	}

	/*@Transactional se utiliza para indicar que el metodo va a funcionar bajo una Transaccion, indicandole el bean de Transaccion.
	  La Transaccion nos sirve en caso de que suceda algun erroro inconveniente dentro del flujo de ejecucion del metodo, haga un rollback.
	*/
	@Transactional("transactionManager")
	@Override
	public void delete(Integer id) {
		String sql = "DELETE FROM PERSONA WHERE ID = ?";
		getJdbcTemplate().update(sql, new Object[] {id});
		
		sql = "UPDATE PERSONA SET NOMBRES = ?, APELLIDOS = ? WHERE ID = ?";
		getJdbcTemplate().update(sql, new Object[] {null, null, id});
	}

}
