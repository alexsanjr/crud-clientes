package com.alexsanjr.crudclientes.services;

import com.alexsanjr.crudclientes.dto.ClientDTO;
import com.alexsanjr.crudclientes.entities.Client;
import com.alexsanjr.crudclientes.repositories.ClientRepository;
import com.alexsanjr.crudclientes.repositories.exceptions.ResourceNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.nio.file.ReadOnlyFileSystemException;

@Service
public class ClientService {

    @Autowired
    private ClientRepository repository;

    @Autowired
    private ModelMapper modelMapper;

    @Transactional(readOnly = true)
    public ClientDTO findById(Long id) {
        Client client = repository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Recurso não Encontrado"));
        return modelMapper.map(client, ClientDTO.class);
    }

}
