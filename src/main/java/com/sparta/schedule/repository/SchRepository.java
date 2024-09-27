package com.sparta.schedule.repository;

import com.sparta.schedule.dto.SchRequestDto;
import com.sparta.schedule.dto.SchResponseDto;
import com.sparta.schedule.entity.Schedule;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.List;

@Component
public class SchRepository {
    private final JdbcTemplate jdbcTemplate;

    public SchRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    public Schedule save(Schedule schedule) {

        String sql = "INSERT INTO schedule VALUES (default,?,?,?, default,default);";
        jdbcTemplate.update(sql, schedule.getName(), schedule.getName(),schedule.getPassword());

    return schedule;
    }


    public List<SchResponseDto> findAll() {
        String sql = "SELECT id,name,todo,create_date,update_date FROM schedule ORDER BY update_date DESC";

        return jdbcTemplate.query(sql, new RowMapper<SchResponseDto>() {
            @Override
            public SchResponseDto mapRow(ResultSet rs, int rowNum) throws SQLException {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String todo = rs.getString("todo");
                String create_date = new SimpleDateFormat("yyyy-MM-dd").format(rs.getTimestamp("create_date"));
                String update_date = new SimpleDateFormat("yyyy-MM-dd").format(rs.getTimestamp("update_date"));
                return new SchResponseDto(id,name, todo,null, create_date, update_date);
            }
        });
    }

    public Schedule findById(int id) {
        System.out.println(id);


        String sql = "SELECT * FROM schedule WHERE id = ?";

        return jdbcTemplate.query(sql, resultSet -> {
            if (resultSet.next()) {
                Schedule schedule = new Schedule();
                schedule.setId(resultSet.getInt("id"));
                schedule.setName(resultSet.getString("name"));
                schedule.setTodo(resultSet.getString("todo"));
                schedule.setPassword(resultSet.getString("password"));
                schedule.setCreate_date(new SimpleDateFormat("yyyy-MM-dd").format(resultSet.getTimestamp("create_date")));
                schedule.setUpdate_date(new SimpleDateFormat("yyyy-MM-dd").format(resultSet.getTimestamp("update_date")));

                return schedule;
            } else {
                return null;
            }
        }, id);

    }

    public void update(String password, SchRequestDto schDto) {

        String sql = "UPDATE schedule SET name = ?, todo = ? WHERE password = ?";

        jdbcTemplate.update(sql, schDto.getName(), schDto.getTodo(), password);

    }


    public void delete(int id) {
        String sql = "DELETE FROM schedule WHERE id = ?";
        jdbcTemplate.update(sql,id);
    }
}
