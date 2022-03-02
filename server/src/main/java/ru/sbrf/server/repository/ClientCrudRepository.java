package ru.sbrf.server.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.sbrf.server.entity.Client;

@Repository
public interface ClientCrudRepository extends CrudRepository<Client, Long> {
}
