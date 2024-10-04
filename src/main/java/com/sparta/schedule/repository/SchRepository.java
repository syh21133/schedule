package com.sparta.schedule.repository;

import com.sparta.schedule.dto.PageDto;
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
        jdbcTemplate.update(sql, schedule.getEmail(), schedule.getTodo(),schedule.getPassword());

    return schedule;
    }


    public List<SchResponseDto> findAll() {
        String sql = "SELECT id,email,todo,create_date,update_date,user_name FROM schedule,user where schedule.email=user.user_email ORDER BY update_date DESC";

        return jdbcTemplate.query(sql, new RowMapper<SchResponseDto>() {
            @Override
            public SchResponseDto mapRow(ResultSet rs, int rowNum) throws SQLException {
                int id = rs.getInt("id");
                String email = rs.getString("email");
                String todo = rs.getString("todo");
                String create_date = new SimpleDateFormat("yyyy-MM-dd").format(rs.getTimestamp("create_date"));
                String update_date = new SimpleDateFormat("yyyy-MM-dd").format(rs.getTimestamp("update_date"));
                String name = rs.getString("user_name");
                return new SchResponseDto(id,email, todo,null, create_date, update_date,name);
            }
        });
    }

    public Schedule findByEmail(String email) {
//        System.out.println(id);


        String sql = "SELECT * FROM schedule,user WHERE schedule.email = user.user_email AND schedule.email = ?";


        return jdbcTemplate.query(sql, resultSet -> {
            if (resultSet.next()) {
                Schedule schedule = new Schedule();
                schedule.setId(resultSet.getInt("id"));
                schedule.setEmail(resultSet.getString("email"));
                schedule.setTodo(resultSet.getString("todo"));
                schedule.setPassword(resultSet.getString("password"));
                schedule.setCreate_date(new SimpleDateFormat("yyyy-MM-dd").format(resultSet.getTimestamp("create_date")));
                schedule.setUpdate_date(new SimpleDateFormat("yyyy-MM-dd").format(resultSet.getTimestamp("update_date")));
                schedule.setName(resultSet.getString("user_name"));

                return schedule;
            } else {
                return null;
            }
        }, email);

    }

    public void update(SchRequestDto schDto) {

        String sql = "UPDATE schedule SET todo = ? WHERE email = ?";
        jdbcTemplate.update(sql, schDto.getTodo(), schDto.getEmail());

        sql = "UPDATE user SET user_name = ? WHERE user_email = ?";
        jdbcTemplate.update(sql, schDto.getName(), schDto.getEmail());


    }


    public void delete(String email) {
        String sql = "DELETE FROM schedule WHERE email = ?";
        jdbcTemplate.update(sql, email);

    }


    public List<SchResponseDto> page(int page, int limit) {

        int offset = limit * (page-1);

        String sql = "SELECT id,email,todo,create_date,update_date,user_name FROM schedule,user WHERE schedule.email = user.user_email limit ? offset ?";

        return jdbcTemplate.query(sql, new RowMapper<SchResponseDto>() {
            @Override
            public SchResponseDto mapRow(ResultSet rs, int rowNum) throws SQLException {
                int id = rs.getInt("id");
                String email = rs.getString("email");
                String todo = rs.getString("todo");
                String create_date = new SimpleDateFormat("yyyy-MM-dd").format(rs.getTimestamp("create_date"));
                String update_date = new SimpleDateFormat("yyyy-MM-dd").format(rs.getTimestamp("update_date"));
                String name = rs.getString("user_name");
                return new SchResponseDto(id,email, todo,null, create_date, update_date,name);

            }
        },limit,offset);

    }
}
