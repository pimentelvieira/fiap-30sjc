package fiap.scj.springmvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.netgifx.dao.GenericDAO;
import br.com.netgifx.entity.Usuario;

@Controller
public class UsuarioController {

	private GenericDAO<Usuario> usuarioDAO = new GenericDAO<>(Usuario.class);
	
	@RequestMapping(value = "/usuario/form_cadastro", method = RequestMethod.GET)
	public String exibirFormCadastro(Model model) {
		model.addAttribute("usuario", new Usuario());
		return "cadastrar_usuario";
	}
	@RequestMapping(value = "/usuario/form_update/{id}", method = RequestMethod.GET)
	public String exibirFormUpdate(@PathVariable(value="id") int id, Model model) {
		model.addAttribute("usuario", usuarioDAO.buscar(id));
		return "alterar_usuario";
	}
	@RequestMapping(value = "/usuario/form_remove/{id}", method = RequestMethod.GET)
	public String exibirFormRemove(Model model, @PathVariable("id") int id) {
		model.addAttribute("usuario", usuarioDAO.buscar(id));
		return "remover_usuario";
	}
	@RequestMapping(value = "/usuario/cadastrar", method = RequestMethod.POST)
	public String cadastrar(Model model, @ModelAttribute("usuario") Usuario usuario) {
		usuarioDAO.adicionar(usuario);
		return "redirect:/usuario";
	}
	@RequestMapping(value = "/usuario", method = RequestMethod.GET)
	public String listar(Model model, Usuario usuario) {
		model.addAttribute("usuario", usuarioDAO.listar());
		return "usuarios";
	}
	@RequestMapping(value = "/usuario/alterar", method = RequestMethod.POST)
	public String alterar(@ModelAttribute("usuario") Usuario usuario) {
		usuarioDAO.atualizar(usuario);
		return "redirect:/usuario";
	}
	@RequestMapping(value = "/usuario/remover", method = RequestMethod.POST)
	public String remover(@ModelAttribute("usuario") Usuario usuario) {
		usuarioDAO.remover(usuarioDAO.buscar(usuario.getId()));
		return "redirect:/usuario";
	}
}
