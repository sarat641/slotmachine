package slotmachine.web.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import slotmachine.web.entities.Fileuploads;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author SARAT
 */
@Repository
public class FileUploadDAO {

    private final JdbcOperations jdbcOperations;
    private final String insert = "insert into fileuploads (fileName,price,filelocation) values (?,?,?)";
    private final String select = "select *from fileuploads";
    private final String findById = "select *from fileuploads fp where fp.id=?";
    private final String deleteFile = "delete from fileuploads where id=?";
    private final String updateFile = "update fileuploads set fileName=?,price=?,filelocation=? where id=?";
    private final String findAllIds = "select id from fileuploads";

    @Autowired
    public FileUploadDAO(JdbcOperations jdbcOperations) {
        this.jdbcOperations = jdbcOperations;
    }

    public void save(Fileuploads fileuploads) {
        jdbcOperations.update(insert, fileuploads.getFileName(), fileuploads.getPrice(), fileuploads.getFilelocation());
    }

    public void delete(Integer id) {
        jdbcOperations.update(deleteFile, id);
    }

    public void update(Fileuploads fileuploads) {
        jdbcOperations.update(updateFile, fileuploads.getFileName(), fileuploads.getPrice(), fileuploads.getFilelocation(), fileuploads.getId());
    }

    public List<Fileuploads> findAll() {
        return jdbcOperations.query(select, new RowMapper<Fileuploads>() {

            @Override
            public Fileuploads mapRow(ResultSet rs, int i) throws SQLException {
                Fileuploads e = new Fileuploads();
                e.setId(rs.getInt(1));
                e.setFileName(rs.getString(2));
                e.setPrice(rs.getInt(3));
                e.setFilelocation(rs.getString(4));
                return e;
            }
        });
    }

    public Fileuploads findById(Integer id) {
        return jdbcOperations.queryForObject(findById, new Object[]{id},
                new RowMapper<Fileuploads>() {
                    @Override
                    public Fileuploads mapRow(ResultSet rs, int rowNum) throws SQLException {

                        Fileuploads user = new Fileuploads();
                        user.setId(rs.getInt(1));
                        user.setFileName(rs.getString(2));
                        user.setPrice(rs.getInt(3));
                        user.setFilelocation(rs.getString(4));

                        return user;
                    }

                });

    }

    public List<Integer> getListOfFileIds() {
        return jdbcOperations.query(findAllIds, new RowMapper<Integer>() {

            @Override
            public Integer mapRow(ResultSet rs, int i) throws SQLException {
                return rs.getInt(1);
            }
        });
    }
}
