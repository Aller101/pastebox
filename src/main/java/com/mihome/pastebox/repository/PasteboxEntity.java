/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mihome.pastebox.repository;

import java.time.LocalDateTime;
import lombok.Data;

/**
 *
 * @author alekseynesterov
 */
@Data
public class PasteboxEntity {
    private int id;
    private String data;
    private String hash;
    private LocalDateTime lifetime;
    private boolean isPublic;
    
    
}
