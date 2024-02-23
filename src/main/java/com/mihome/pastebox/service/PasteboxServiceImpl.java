/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mihome.pastebox.service;

import com.mihome.pastebox.api.request.PasteboxRequest;
import com.mihome.pastebox.api.request.PublicStatus;
import com.mihome.pastebox.api.response.PasteboxResponse;
import com.mihome.pastebox.api.response.PasteboxUrlResponse;
import com.mihome.pastebox.repository.PasteboxEntity;
import com.mihome.pastebox.repository.PasteboxRepository;
import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Service;

/**
 *
 * @author alekseynesterov
 */
@Service
@RequiredArgsConstructor
@ConfigurationProperties(prefix = "app")
public class PasteboxServiceImpl implements PasteboxService {

    private String host = "http://abc.ru";
    private int publicListSize=10;

    private final PasteboxRepository repository;
    private AtomicInteger idGenerator = new AtomicInteger(0);

    @Override
    public PasteboxResponse getByHash(String hash) {
        PasteboxEntity pasteboxEntity = repository.getByHash(hash);
        return new PasteboxResponse(pasteboxEntity.getData(), pasteboxEntity.isPublic());
    }

    @Override
    public List<PasteboxResponse> getFirstPublicPasteboxes() {
        List<PasteboxEntity> list = repository.getListOfPublicAndlive(publicListSize);
        return list.stream().map(pasteboxEntity
                -> new PasteboxResponse(pasteboxEntity.getData(), pasteboxEntity.isPublic())
        ).collect(Collectors.toList());
    }

    @Override
    public PasteboxUrlResponse create(PasteboxRequest request) {
        int hash = generateId();
        PasteboxEntity pasteboxEntity = new PasteboxEntity();
        pasteboxEntity.setData(request.getData());
        pasteboxEntity.setId(hash);
        pasteboxEntity.setHash(Integer.toHexString(hash));
        pasteboxEntity.setPublic(request.getPublicStatus() == PublicStatus.PUBLIC);
        pasteboxEntity.setLifetime(LocalDateTime.now().plusSeconds(request.getExpirationTimeSecomds()));
        repository.add(pasteboxEntity);
        return new PasteboxUrlResponse(host + "/" + pasteboxEntity.getHash());
    }

    private int generateId() {
        return idGenerator.getAndIncrement();
    }

}
