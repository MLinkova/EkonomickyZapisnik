package EnitaaDao;


import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import java.util.HashMap;
import java.util.Map;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

public class MySqlPolozkaDao implements PolozkaDao{
   
  private JdbcTemplate jdbcTemplate;
  private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    
    public MySqlPolozkaDao() {
        MysqlDataSource dataSource = new MysqlDataSource();
        
        dataSource.setUrl("jdbc:mysql://localhost/Ekonomika");
	dataSource.setUser("mLinkova");
	dataSource.setPassword("mLinkova123");
	jdbcTemplate = new JdbcTemplate(dataSource);
         this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(this.jdbcTemplate);
        
    }

    @Override
    public void pridaj(Polozka polozka) {
        Map<String, Object> pridatHodnoty = new HashMap<String, Object>();
        pridatHodnoty.put("id", polozka.getId());
        pridatHodnoty.put("nazov", polozka.getNazov());
        pridatHodnoty.put("datum", polozka.getDatum());
        pridatHodnoty.put("suma", polozka.getSuma());
        pridatHodnoty.put("kategoria", polozka.getKategoria());
          
        
  
        
        String sql = "INSERT INTO PravdyViery VALUES(:id, :nazov, :datum, :suma, :kategoria)";

        KeyHolder keyHolder = new GeneratedKeyHolder();
        namedParameterJdbcTemplate.update(sql, new MapSqlParameterSource(pridatHodnoty), keyHolder);
        int id = keyHolder.getKey().intValue();
        polozka.setId(id);
    }

    @Override
    public void odstanit(Polozka polozka) {
        String sql="Delete from Polozka where Id= ?";
        jdbcTemplate.update(sql,polozka.getId());
    }

    @Override
    public List<Polozka> dajVsetky() {
        String sql = "Select * from Polozka";
        BeanPropertyRowMapper<Polozka> mapper = BeanPropertyRowMapper.newInstance(Polozka.class);
        return jdbcTemplate.query(sql, mapper);
    }

    @Override
    public List<Polozka> vypisPrijmyCelkovo() {
       String sql= "select * from polozka where kategoria like 'prijem'";
        BeanPropertyRowMapper<Polozka> mapper = BeanPropertyRowMapper.newInstance(Polozka.class);
        return jdbcTemplate.query(sql, mapper);
    }

    @Override
    public List<Polozka> vypisPrijmyMesacne(int mesiac) {
        String sql="select * from Polozka where month(datum)="+ mesiac +" and kategoria like 'prijem'";
        BeanPropertyRowMapper<Polozka> mapper = BeanPropertyRowMapper.newInstance(Polozka.class);
        return jdbcTemplate.query(sql, mapper);
    }

    @Override
    public List<Polozka> vypisVydavkyCelkovo() {
        String sql= "select * from polozka where kategoria like 'vydavky'";
        BeanPropertyRowMapper<Polozka> mapper = BeanPropertyRowMapper.newInstance(Polozka.class);
        return jdbcTemplate.query(sql, mapper);
    }

    @Override
    public List<Polozka> vypisVydajvkyMesacne(int mesiac) {
        String sql="select * from Polozka where month(datum)="+ mesiac +" and kategoria like 'vydavky'";
        BeanPropertyRowMapper<Polozka> mapper = BeanPropertyRowMapper.newInstance(Polozka.class);
        return jdbcTemplate.query(sql, mapper);
    }

    @Override
    public double sumaPrijmyCelkovo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public double sumaPrijmyMesacne(int mesiac) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public double sumaVydajkyMesacne(int mesiac) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public double sumaVydavkyCelkovo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Polozka> hladat(String s) {
        String sql = "Select * from Polozka where nazov like '%"+s+"%'";
        BeanPropertyRowMapper<Polozka> mapper = BeanPropertyRowMapper.newInstance(Polozka.class);
        return jdbcTemplate.query(sql, mapper);
    }

    @Override
    public void upravit(Polozka polozka) {
        String sql= "Update Polozka Set nazov=?, datum=?, suma=?, kategoria= ? where Id= ? ";
        jdbcTemplate.update(sql,polozka.getNazov(),polozka.getDatum(),polozka.getSuma(),polozka.getKategoria(),polozka.getId());
    }
    
}
