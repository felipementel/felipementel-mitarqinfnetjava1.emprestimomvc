package br.com.emprestimomvc.model.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.emprestimomvc.model.negocio.Usuario;

@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, Integer> {

}