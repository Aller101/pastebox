/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mihome.pastebox.api.request;

import lombok.Data;


/**
 *
 * @author alekseynesterov
 */
@Data
public class PasteboxRequest {
    private String data;
    private long expirationTimeSecomds;
    private PublicStatus publicStatus;

}
