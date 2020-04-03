package br.com.emprestimomvc.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.emprestimomvc.model.negocio.Usuario;
import br.com.emprestimomvc.model.repository.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository repository;

	public UsuarioRepository getRepository() {
		return repository;
	}

	public void setRepository(UsuarioRepository repository) {
		this.repository = repository;
	}

	public boolean isValid(String login, String senha) {
		return "admin".equalsIgnoreCase(login) && "admin".equalsIgnoreCase(senha);
	}

	public List<Usuario> ObterLista() {
		return (List<Usuario>)repository.findAll();
				
				/*Arrays.asList(new Usuario(1, "Hugo 1", "dwedwdw", "dewd"), new Usuario(2, "Hugo 2", "dwedwdw", "dewd"),
				new Usuario(3, "Hugo 3", "dwedwdw", "dewd"), new Usuario(4, "Hugo 4", "dwedwdw", "dewd"));
				*/
	}

	public void Incluir(Usuario usuario) {
		
		repository.save(usuario);
		//System.out.println("cadatro do " + usuario.getNome() + " realizado com sucesso");

	}

	public void Excluir(int id) {

		repository.deleteById(id);
		
		//System.out.println("Id excluido com sucesso,  " + id);
	}
}
