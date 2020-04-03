package br.com.emprestimomvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import br.com.emprestimomvc.model.negocio.Usuario;
import br.com.emprestimomvc.model.service.UsuarioService;

@Controller
@SessionAttributes("user")
public class UsuarioController {

	@Autowired
	private UsuarioService service;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String ShowInit() {
		return this.ShowLogin();
	}

	public UsuarioService getService() {
		return service;
	}

	public void setService(UsuarioService service) {
		this.service = service;
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String ShowLogin() {
		return "login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String ShowHome(Model model, @RequestParam String login, @RequestParam String senha) {

		if (!service.isValid(login, senha)) {
			model.addAttribute("msg", "Acesso Invalido");
			return "login";
		} else {
			model.addAttribute("user", login);
			return "home";
		}
	}

	@RequestMapping(value = "/usuario", method = RequestMethod.GET)
	public String ShowDetalhe() {
		return "usuario/detalhe";
	}

	@RequestMapping(value = "/usuario", method = RequestMethod.POST)
	public String Incluir(Model model, Usuario usuario) {

		service.Incluir(usuario);

		return this.ObterLista(model);
	}

	@RequestMapping(value = "/usuario/excluir/{id}", method = RequestMethod.GET) //correto usar delete, nao usado devido ao href
	public String Excluir(Model model, @PathVariable int id) {
		
		service.Excluir(id);
		
		return this.ObterLista(model);
	}

	@RequestMapping(value = "/usuarios", method = RequestMethod.GET)
	public String ObterLista(Model model) {

		model.addAttribute("usuarioLista", service.ObterLista());

		return "usuario/lista";
	}
}
