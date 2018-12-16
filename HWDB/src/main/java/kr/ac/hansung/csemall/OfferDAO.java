package kr.ac.hansung.csemall;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

public class OfferDAO {
	private JdbcTemplate jdbcTemplate;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public int getRowCount() {
		String sqlStatement = "select count(*) from subject";
		return jdbcTemplate.queryForObject(sqlStatement, Integer.class);

	}

	public Offer getOffer(String name) {
		String sqlStatement = "select * from subject where name=?";

		return jdbcTemplate.queryForObject(sqlStatement, new Object[] { name }, new RowMapper<Offer>() {
			public Offer mapRow(ResultSet rs, int rowNum) throws SQLException {
				Offer offer = new Offer();

				offer.setYear(rs.getInt("year"));
				offer.setSemester(rs.getInt("semester"));
				offer.setCode(rs.getString("code"));
				offer.setName(rs.getString("name"));
				offer.setDivision(rs.getString("division"));
				offer.setCredit(rs.getInt("credit"));

				return offer;
			}
		});
	}

	public List<Offer> getOffers() {
		String sqlStatement = "select * from subject";

		return jdbcTemplate.query(sqlStatement, new RowMapper<Offer>() {
			public Offer mapRow(ResultSet rs, int rowNum) throws SQLException {

				Offer offer = new Offer();

				offer.setYear(rs.getInt("year"));
				offer.setSemester(rs.getInt("semester"));
				offer.setCode(rs.getString("code"));
				offer.setName(rs.getString("name"));
				offer.setDivision(rs.getString("division"));
				offer.setCredit(rs.getInt("credit"));

				return offer;
			}

		});
	}
	
	public boolean insert(Offer offer) {
		
		String name = offer.getName();
		int year = offer.getYear();
		int credit = offer.getCredit();
		String division = offer.getDivision();
		int semester = offer.getSemester();
		String code = offer.getCode();
		
		String sqlStatement="insert into subject (year, semester, code, name, division, credit) values (?,?,?,?,?,?)";
	
	return (jdbcTemplate.update(sqlStatement, new Object[] {year, semester, code, name, division, credit}) ==1);
	}
	
	
public boolean update(Offer offer) {
		
		String name = offer.getName();
		int year = offer.getYear();
		int credit = offer.getCredit();
		String division = offer.getDivision();
		int semester = offer.getSemester();
		String code = offer.getCode();
		
		String sqlStatement="update subject set year=?, semester=?, code,=? name=?, division=?, credit=?";
	
	return (jdbcTemplate.update(sqlStatement, new Object[] {year, semester, code, name, division, credit}) ==1);
	}


}