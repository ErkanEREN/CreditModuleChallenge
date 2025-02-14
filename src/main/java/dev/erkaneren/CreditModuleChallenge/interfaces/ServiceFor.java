package dev.erkaneren.CreditModuleChallenge.interfaces;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

public abstract class ServiceFor<T> {
    
    private RepositoryOf<T> repository;

    public RepositoryOf<T> getRepository() {
        return repository;
    }
    
    @Autowired
    private void setRepository(RepositoryOf<T> repository) {
        this.repository = repository;
    }

    public boolean existsById(Long id) {
        return repository.findById(id).isPresent();
    }

    public List<T> findById(Long id) {
        return repository.findAllById(List.of(id));
    }

    public T save(T entity){
        // ideally you should use DAO
        return repository.save(entity);
    }

    public List<T> saveAll(Iterable<T> entities){
        // ideally you should use DAO
        return repository.saveAll(entities);
    }

    public List<T> findAll(){
        return repository.findAll();
    }
}
