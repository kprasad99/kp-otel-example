package io.github.kprasad99.otel.example.service;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.kprasad99.otel.example.mappers.UserMapper;
import io.github.kprasad99.otel.example.r2dbc.dao.UserRepository;
import io.github.kprasad99.otel.example.service.model.User;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@AllArgsConstructor
@RestController
@RequestMapping("kp-otel-example/api/")
public class KpUserService {

	private final UserRepository repository;

	@GetMapping("/users")
	public Flux<User> list() {
		log.info("Listing users");
		return repository.findAll().doOnEach(v->log.info("user retrieved {}", v)).map(UserMapper.INSTANCE::toModel);
	}

	@PostMapping("/users/{id}")
	public Mono<User> add(@RequestBody User user, @PathVariable("id")int id) {
		log.info("Adding user {}", user.getName());
		return repository.save(UserMapper.INSTANCE.toDomain(user)).doOnNext(v->log.info("Added user {}", user.getName())).map(UserMapper.INSTANCE::toModel);
		
	}
	
	@PutMapping("/users/{id}")
	public Mono<User> update(@RequestBody User user, @PathVariable("id")int id) {
		log.info("Updating user {}", user.getName());
		return repository.save(UserMapper.INSTANCE.toDomain(user)).doOnNext(v->log.info("updated user {}", user.getName())).map(UserMapper.INSTANCE::toModel);
		
	}
	
	@DeleteMapping("/users/{id}")
	public Mono<Void> remove(@PathVariable("id")int id) {
		log.info("Removing user with id {}", id);
		return repository.deleteById(id).doOnSuccess(v->log.info("removed user {}", id));
	}
}
