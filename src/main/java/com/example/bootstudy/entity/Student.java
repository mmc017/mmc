package com.example.bootstudy.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @author Zz
 */
@Data
public class Student implements Serializable {
        private static final long serialVersionUID = -339516038496531943L;
        private String sno;
        private String name;
        private String sex;
        // get,set略


}
