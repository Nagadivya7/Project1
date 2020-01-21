package com.atos.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class EmployeeDao {
	JdbcTemplate template;

	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}

	public int save(Employee p) {
		String sql = "insert into registration_22(first_name,last_name,emp_id,emailid,password,confirm_password,mobile_no,category,location) values(id_seq.nextval,'" + p.getFname()
				+ "','" +p.getLname()+"','"+p.getId()+"','"+p.getEmail()+"','"+p.getPassword() + "','" +p.getCpassword()+"','"+ p.getCategory() + "','"+p.getMobile()+"','" + p.getLocation() + "')";
		return template.update(sql);
	}

	public List<Employee> getEmployees() {
		return template.query("select * from user1", new RowMapper<Employee>() {
			public Employee mapRow(ResultSet rs, int row) throws SQLException {
				Employee e = new Employee();
				e.setFname(rs.getString(1));
				e.setLname(rs.getString(2));
				e.setId(rs.getString(3));
				e.setEmail(rs.getString(4));
				e.setPassword(rs.getString(5));
				e.setCpassword(rs.getString(6));
				e.setMobile(rs.getLong(7));
				e.setCategory(rs.getString(8));
				e.setLocation(rs.getString(9));
				return e;
			}
		});
	}
}
