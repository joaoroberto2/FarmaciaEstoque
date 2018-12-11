package br.farmacia.estoque.validation;

import br.farmacia.estoque.application.ValidationException;

public interface Validation<T> {
	public void validate(T t) throws ValidationException;
}