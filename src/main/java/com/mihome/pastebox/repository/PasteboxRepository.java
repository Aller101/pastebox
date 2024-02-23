/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mihome.pastebox.repository;

import java.util.List;

/**
 *
 * @author alekseynesterov
 */
public interface PasteboxRepository {
    
    PasteboxEntity getByHash(String hash);
    
    List<PasteboxEntity> getListOfPublicAndlive(int amount);
    
    void add(PasteboxEntity pasteboxEntity);
    
}
