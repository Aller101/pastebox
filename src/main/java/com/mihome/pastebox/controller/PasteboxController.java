/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mihome.pastebox.controller;

import com.mihome.pastebox.api.request.PasteboxRequest;
import java.util.Collections;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author alekseynesterov
 */
@RestController
public class PasteboxController {
    
    @GetMapping("/{hash}")
    public String getByHash(@PathVariable String hash){
        return hash;
    }
    
    @GetMapping("/")
    public List<String> getPublicPastelist(){
        return Collections.EMPTY_LIST;
    }
    
    @PostMapping("/")
    public String add(@RequestBody PasteboxRequest request){
        return request.getData();
    } 
    
     
    
    
    
}
