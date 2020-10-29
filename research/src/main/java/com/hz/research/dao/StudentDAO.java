package com.hz.research.dao;

import com.hz.research.model.Student;
import org.apache.ibatis.annotations.Param;

public interface StudentDAO {

    public Student getStudentById(@Param("id")int id);
}