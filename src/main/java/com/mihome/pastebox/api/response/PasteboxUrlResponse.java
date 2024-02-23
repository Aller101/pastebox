/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mihome.pastebox.api.response;

import lombok.Data;
import lombok.RequiredArgsConstructor;

/**
 *
 * @author alekseynesterov
 */
@Data
@RequiredArgsConstructor
public class PasteboxUrlResponse {
    private final String url; 
}
