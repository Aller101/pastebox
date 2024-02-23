/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mihome.pastebox.exception;

/**
 *
 * @author alekseynesterov
 */
public class NotFoundEntityException extends RuntimeException{
    
    public NotFoundEntityException(String s){
        super(s);
    }
}
