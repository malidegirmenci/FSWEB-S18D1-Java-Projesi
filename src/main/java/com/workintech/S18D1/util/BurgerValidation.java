package com.workintech.S18D1.util;

import com.workintech.S18D1.exception.BurgerException;
import org.springframework.http.HttpStatus;

public class BurgerValidation {
    public static void checkName(String name){
        if(name == null || name.isEmpty()){
            throw new BurgerException("Name is null or empty!", HttpStatus.BAD_REQUEST);
        }
    }
}
