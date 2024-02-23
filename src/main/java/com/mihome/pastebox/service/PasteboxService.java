/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mihome.pastebox.service;

import com.mihome.pastebox.api.request.PasteboxRequest;
import com.mihome.pastebox.api.response.PasteboxResponse;
import com.mihome.pastebox.api.response.PasteboxUrlResponse;
import java.util.List;

/**
 *
 * @author alekseynesterov
 */
public interface PasteboxService {
    
    PasteboxResponse getByHash(String hash);
    
    List<PasteboxResponse> getFirstPublicPasteboxes();
    
    PasteboxUrlResponse create(PasteboxRequest request);
    
}
