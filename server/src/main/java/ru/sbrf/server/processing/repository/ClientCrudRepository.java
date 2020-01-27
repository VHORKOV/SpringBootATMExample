package ru.sbrf.server.processing.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.sbrf.server.processing.entity.Client;

@Repository
public interface ClientCrudRepository extends CrudRepository<Client, Long> {
}
