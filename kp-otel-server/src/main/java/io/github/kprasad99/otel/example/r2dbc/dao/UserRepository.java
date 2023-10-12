package io.github.kprasad99.otel.example.r2dbc.dao;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

import io.github.kprasad99.otel.example.r2dbc.domain.User;

@Repository
public interface UserRepository extends ReactiveCrudRepository<User, Integer> {

}
