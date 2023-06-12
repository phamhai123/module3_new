package com.example.case_study_module3.repository.employee;

import com.example.case_study_module3.model.Employee;
import com.example.case_study_module3.model.infomation.employee.Division;
import com.example.case_study_module3.model.infomation.employee.Education;
import com.example.case_study_module3.model.infomation.employee.Position;
import com.example.case_study_module3.repository.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeRepositoryImpl implements EmployeeRepository {
    public static final String INSERT_INTO_EMPLOYEE = "insert into nhan_vien(ho_ten,ngay_sinh,so_cmnd,luong,so_dien_thoai,email,dia_chi,ma_vi_tri,ma_trinh_do,ma_bo_phan) value(?,?,?,?,?,?,?,?,?,?)";
    public static final String DELETE_EMPLOYEE = "delete from nhan_vien where (ma_nhan_vien = ?);";
    public static final String SELECT_EMPLOYEES_ID = "select * from nhan_vien where ma_nhan_vien = ?";
    public static final String UPDATE_EMPLOYEE = "update nhan_vien set ho_ten=?, ngay_sinh=?, so_cmnd=?, luong=?,so_dien_thoai=?, email=?,dia_chi=?,ma_vi_tri=?,ma_trinh_do=?,ma_bo_phan=? where ma_nhan_vien=?";

    @Override
    public List<Employee> findALL() {
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<Employee> employees = new ArrayList<>();
        if (connection != null) {
            try {
                statement = connection.prepareStatement("select * from nhan_vien");
                resultSet = statement.executeQuery();
                Employee employee = null;
                while (resultSet.next()) {
                    int id = resultSet.getInt("ma_nhan_vien");
                    String name = resultSet.getString("ho_ten");
                    String birthday = resultSet.getString("ngay_sinh");
                    String idCard = resultSet.getString("so_cmnd");
                    double salary = resultSet.getDouble("luong");
                    String phone = resultSet.getString("so_dien_thoai");
                    String email = resultSet.getString("email");
                    String address = resultSet.getString("dia_chi");
                    int position = resultSet.getInt("ma_vi_tri");
                    int education = resultSet.getInt("ma_trinh_do");
                    int division = resultSet.getInt("ma_bo_phan");
                    employee = new Employee(id, name, birthday, idCard, salary, phone, email, address, position, education, division);
                    employees.add(employee);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    resultSet.close();
                    statement.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                DBConnection.close();
            }
        }
        return employees;
    }

    @Override
    public List<Position> positionAll() {
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<Position> list = new ArrayList<>();
        if (connection != null) {
            try {
                statement = connection.prepareStatement("select * from vi_tri");
                resultSet = statement.executeQuery();
                Position position = null;
                while (resultSet.next()) {
                    int id = resultSet.getInt("ma_vi_tri");
                    String name = resultSet.getString("ten_vi_tri");
                    position = new Position(id, name);
                    list.add(position);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    resultSet.close();
                    statement.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                DBConnection.close();
            }
        }
        return list;
    }

    @Override
    public List<Education> educationAll() {
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<Education> list = new ArrayList<>();
        if (connection != null) {
            try {
                statement = connection.prepareStatement("select * from trinh_do");
                resultSet = statement.executeQuery();
                Education education = null;
                while (resultSet.next()) {
                    int id = resultSet.getInt("ma_trinh_do");
                    String name = resultSet.getString("ten_trinh_do");
                    education = new Education(id, name);
                    list.add(education);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    resultSet.close();
                    statement.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                DBConnection.close();
            }
        }
        return list;
    }

    @Override
    public List<Division> divisionAll() {
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<Division> list = new ArrayList<>();
        if (connection != null) {
            try {
                statement = connection.prepareStatement("select * from bo_phan");
                resultSet = statement.executeQuery();
                Division division = null;
                while (resultSet.next()) {
                    int id = resultSet.getInt("ma_bo_phan");
                    String name = resultSet.getString("ten_bo_phan");
                    division = new Division(id, name);
                    list.add(division);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    resultSet.close();
                    statement.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                DBConnection.close();
            }
        }
        return list;
    }

    @Override
    public void save(Employee employee) {
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        if (connection != null) {
            try {
                statement = connection.prepareStatement(INSERT_INTO_EMPLOYEE);
                statement.setString(1, employee.getName());
                statement.setDate(2, java.sql.Date.valueOf(employee.getBirthday()));
                statement.setString(3, employee.getIdCard());
                statement.setDouble(4, employee.getSalary());
                statement.setString(5, employee.getPhone());
                statement.setString(6, employee.getEmail());
                statement.setString(7, employee.getAddress());
                statement.setInt(8, employee.getPosition());
                statement.setInt(9, employee.getEducation());
                statement.setInt(10, employee.getDivision());
                statement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                DBConnection.close();
            }
        }
    }

    @Override
    public Employee findById(int id) {
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<Employee> employees = new ArrayList<>();
        Employee employee = null;
        if (connection != null) {
            try {
                statement = connection.prepareStatement(SELECT_EMPLOYEES_ID);
                statement.setInt(1, id);
                resultSet = statement.executeQuery();

                while (resultSet.next()) {
                    String name = resultSet.getString("ho_ten");
                    String birthday = resultSet.getString("ngay_sinh");
                    String idCard = resultSet.getString("so_cmnd");
                    double salary = resultSet.getDouble("luong");
                    String phone = resultSet.getString("so_dien_thoai");
                    String email = resultSet.getString("email");
                    String address = resultSet.getString("dia_chi");
                    int position = resultSet.getInt("ma_vi_tri");
                    int education = resultSet.getInt("ma_trinh_do");
                    int division = resultSet.getInt("ma_bo_phan");
                    employee = new Employee(id, name, birthday, idCard, salary, phone, email, address, position, education, division);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    resultSet.close();
                    statement.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                DBConnection.close();
            }
        }
        return employee;
    }

    @Override
    public void update(int id, Employee employee) {
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        if (connection != null) {
            try {
                statement = connection.prepareStatement(UPDATE_EMPLOYEE);
                statement.setString(1, employee.getName());
                statement.setDate(2, java.sql.Date.valueOf(employee.getBirthday()));
                statement.setString(3, employee.getIdCard());
                statement.setDouble(4, employee.getSalary());
                statement.setString(5, employee.getPhone());
                statement.setString(6, employee.getEmail());
                statement.setString(7, employee.getAddress());
                statement.setInt(8, employee.getPosition());
                statement.setInt(9, employee.getEducation());
                statement.setInt(10, employee.getDivision());
                statement.setInt(11,id);
                statement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                DBConnection.close();
            }
        }
    }

    @Override
    public void delete(int id) {
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        if (connection != null) {
            try {
                statement = connection.prepareStatement(DELETE_EMPLOYEE);
                statement.setInt(1, id);
                statement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                DBConnection.close();
            }
        }
    }
}
