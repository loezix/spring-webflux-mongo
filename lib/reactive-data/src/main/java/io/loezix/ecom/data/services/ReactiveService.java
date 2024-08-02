package io.loezix.ecom.data.services;

import io.loezix.ecom.data.data.ReactiveRepository;

public abstract class ReactiveService<T, R extends ReactiveRepository<T>> {

  private final R repository;

  public ReactiveService(R repository) {
    this.repository = repository;
  }

  public R repository() {
    return repository;
  }
}
