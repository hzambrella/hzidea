package com.hz.ideaweb.dao;

import com.hz.ideaweb.model.Student;
import org.apache.ibatis.annotations.Param;

public interface StudentDAO {

    public Student getStudentById(@Param("id")int id);
}