package br.com.erudio.services;

import br.com.erudio.model.Person;
import br.com.erudio.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonServices {
    @Autowired
    PersonRepository repository;

    public Person create(Person person){
        return repository.save(person);
    }

    public Person update(Person person){
        Person entity = repository.findById(person.getId()).orElseThrow(()-> new ResourceNotFoundException("No records found for this ID"));

        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        entity.setAddress(person.getAddress());
        entity.setGender(person.getGender());

        return repository.save(entity);
    }


    public Person findById(Long id){

        return repository.findById(id).orElseThrow(()-> new ResourceNotFoundException("No records found for this ID"));
    }

    public List<Person> findAll(){

        return repository.findAll();
    }

    public void delete(Long id){
        Person entity = repository.findById(id).orElseThrow(()-> new ResourceNotFoundException("No records found for this ID"));
        repository.delete(entity);
    }
}
