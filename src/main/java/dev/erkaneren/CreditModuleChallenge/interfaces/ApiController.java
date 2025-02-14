package dev.erkaneren.CreditModuleChallenge.interfaces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

public abstract class ApiController<T> {

    @Autowired ServiceFor<T> service;

    public ServiceFor<T> getService() {
        return service;
    }

    public void setService(ServiceFor<T> service) {
        this.service = service;
    }

    @GetMapping("/{id}/exists")
    public boolean exists(@PathVariable Long id) {
        return getService().existsById(id);
    }
}
