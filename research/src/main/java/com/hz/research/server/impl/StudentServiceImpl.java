package com.hz.research.server.impl;

import com.hz.research.dao.StudentDAO;
import com.hz.research.model.Student;
import com.hz.research.server.IStudentService;
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