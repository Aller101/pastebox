/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mihome.pastebox.controller;

import com.mihome.pastebox.api.request.PasteboxRequest;
import com.mihome.pastebox.api.response.PasteboxResponse;
import com.mihome.pastebox.api.response.PasteboxUrlResponse;
import com.mihome.pastebox.service.PasteboxService;
import java.util.Collection;
import lombok.RequiredArgsConstructor;
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
@RequiredArgsConstructor
public class PasteboxController {
    
    private final PasteboxService pasteboxService;
    
    @GetMapping("/{hash}")
    public PasteboxResponse getByHash(@PathVariable String hash){
        return pasteboxService.getByHash(hash);
    }
    
    @GetMapping("/")
    public Collection<PasteboxResponse> getPublicPastelist(){
        return pasteboxService.getFirstPublicPasteboxes();
    }
    
    @PostMapping("/")
    public PasteboxUrlResponse add(@RequestBody PasteboxRequest request){
        return pasteboxService.create(request);
    } 
    
     
    
    
    
}
