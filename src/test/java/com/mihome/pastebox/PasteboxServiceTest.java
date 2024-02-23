/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mihome.pastebox;

import com.mihome.pastebox.api.response.PasteboxResponse;
import com.mihome.pastebox.exception.NotFoundEntityException;
import com.mihome.pastebox.repository.PasteboxEntity;
import com.mihome.pastebox.repository.PasteboxRepository;
import com.mihome.pastebox.service.PasteboxService;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

/**
 *
 * @author alekseynesterov
 */
@SpringBootTest
public class PasteboxServiceTest {
    
    @Autowired
    private PasteboxService pasteboxService;
    
    @MockBean
    private PasteboxRepository pasteboxRepository;
    
    @Test
    public void notExistHash(){
        when(pasteboxRepository.getByHash(anyString())).thenThrow(NotFoundEntityException.class);
        assertThrows(NotFoundEntityException.class, () -> pasteboxService.getByHash("cercer"));
    }
    
    @Test
    public void getExistHash(){
        PasteboxEntity entity = new PasteboxEntity();
        entity.setHash("1");
        entity.setData("fedia");
        entity.setPublic(true);
        when(pasteboxRepository.getByHash("1")).thenReturn(entity);
        
        PasteboxResponse expected = new PasteboxResponse("fedia", true);
        PasteboxResponse actual = pasteboxService.getByHash("1");
        
        assertEquals(expected, actual);
    
    }
    
}
