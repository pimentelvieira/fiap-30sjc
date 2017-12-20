package fiap.scj.springmvc.controllers;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import fiap.scj.springmvc.beans.Categoria;
import fiap.scj.springmvc.beans.Gif;
import fiap.scj.springmvc.beans.Usuario;
import fiap.scj.springmvc.daos.GenericDAO;
import fiap.scj.springmvc.daos.UsuarioDAO;
import fiap.scj.springmvc.util.UsuarioUtil;

@Controller
public class LoginController {

	UsuarioDAO usuarioDAO = new UsuarioDAO();
	GenericDAO<Categoria> categoriaDAO = new GenericDAO<>(Categoria.class);
	
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String exibirHome(Model model) {
		List<Categoria> categorias = categoriaDAO.listar();
		model.addAttribute("categorias", categorias);
		return "home";
	}
	@RequestMapping(value = "/homeAdm", method = RequestMethod.GET)
	public String exibirHomeAdm(Model model) {
		List<Categoria> categorias = categoriaDAO.listar();
		model.addAttribute("categorias", categorias);
		return "homeAdm";
	}
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String exibirFormulario() {
		return "formLogin";
	}
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String logar(Usuario usuario, Model model, RedirectAttributes attr, HttpServletRequest req) {	
		Usuario usr = usuarioDAO.buscar(usuario.getLogin(), usuario.getSenha());
		Set<Gif> gifsFavoritos = new HashSet<>();
		
		if(usr != null) {
			if(UsuarioUtil.isAdmin(usr)) {
				System.out.println("login ADM efetuado com sucesso");
				req.getSession().setAttribute("usrLogado", usr);
				req.getSession().setAttribute("gifsFavoritos", gifsFavoritos);
				return "redirect:/homeAdm";
			} else {
				System.out.println("login efetuado com sucesso");
				req.getSession().setAttribute("usrLogado", usr);
				req.getSession().setAttribute("gifsFavoritos", gifsFavoritos);
				return "redirect:/home";
			}
			
		} else {
			model.addAttribute("mensagem", "Usuário ou senha inválidos");
			System.out.println("Usuário ou senha inválidos");
			return "formLogin";
		}
	}
	@RequestMapping(value = "/nologin", method = RequestMethod.GET)
	public String noLogin(Model model, HttpServletRequest req) {	
		model.addAttribute("mensagem", "Nenhum usuário logado");
		return "formLogin";
	}
}
