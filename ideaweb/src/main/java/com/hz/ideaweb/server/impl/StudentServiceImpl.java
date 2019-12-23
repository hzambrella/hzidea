package com.hz.ideaweb.server.impl;

import com.hz.ideaweb.dao.StudentDAO;
import com.hz.ideaweb.model.Student;
import com.hz.ideaweb.server.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("StudentService")
public class StudentServiceImpl implements IStudentService {
    @Autowired
    StudentDAO studentDao;

   public Student getStudentInfo(int id){
       return studentDao.getStudentById(id);
    }
}