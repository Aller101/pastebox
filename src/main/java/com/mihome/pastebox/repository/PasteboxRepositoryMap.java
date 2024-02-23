/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mihome.pastebox.repository;

import com.mihome.pastebox.exception.NotFoundEntityException;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;
import org.springframework.stereotype.Repository;

/**
 *
 * @author alekseynesterov
 */
@Repository
public class PasteboxRepositoryMap implements PasteboxRepository{
    
    private final Map<String,PasteboxEntity> vault = new ConcurrentHashMap<>();

    @Override
    public PasteboxEntity getByHash(String hash) {
        PasteboxEntity pasteboxEntity = vault.get(hash);
        
        if(pasteboxEntity == null){
            throw new NotFoundEntityException("Pastebox not found with hash = " + hash); 
        }
        
        return pasteboxEntity;
    }

    @Override
    public List<PasteboxEntity> getListOfPublicAndlive(int amount) {
        LocalDateTime now = LocalDateTime.now();
//                .atZone(ZoneId.systemDefault()).toInstant().getEpochSecond();
        
        return vault.values().stream()
                .filter(PasteboxEntity::isPublic)
                .filter(pasteboxEntity->pasteboxEntity.getLifetime().isAfter(now))
                .sorted(Comparator.comparing(PasteboxEntity::getId).reversed())
                .limit(amount)
                .collect(Collectors.toList());
    }

    @Override
    public void add(PasteboxEntity pasteboxEntity) {
        vault.put(pasteboxEntity.getHash(), pasteboxEntity);
    }

    
}
