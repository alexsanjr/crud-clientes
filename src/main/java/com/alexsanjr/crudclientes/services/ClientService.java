package com.alexsanjr.crudclientes.services;

import com.alexsanjr.crudclientes.dto.ClientDTO;
import com.alexsanjr.crudclientes.entities.Client;
import com.alexsanjr.crudclientes.repositories.ClientRepository;
import com.alexsanjr.crudclientes.services.exceptions.ResourceNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.orm.jpa.JpaObjectRetrievalFailureException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Transactional(readOnly = true)
    public Page<ClientDTO> findAll(Pageable pageable) {
        Page<Client> entity = repository.findAll(pageable);
        return entity.map(c -> modelMapper.map(c, ClientDTO.class));
    }

    @Transactional
    public ClientDTO insert(ClientDTO dto) {
        Client entity = modelMapper.map(dto, Client.class);
        entity = repository.save(entity);
        return modelMapper.map(entity, ClientDTO.class);
    }

    @Transactional
    public ClientDTO update(Long id, ClientDTO dto) {
        try {
            Client entity = repository.getReferenceById(id);
            dto.setId(id);
            entity = modelMapper.map(dto, Client.class);
            entity = repository.save(entity);
            return modelMapper.map(entity, ClientDTO.class);
        }
        catch (JpaObjectRetrievalFailureException e) {
            throw new ResourceNotFoundException("Recurso não encontrado");
        }
    }

    @Transactional
    public void delete(Long id) {
        if(!repository.existsById(id)){
            throw new ResourceNotFoundException("Recurso não encontrado");
        }
        repository.deleteById(id);
    }
}
