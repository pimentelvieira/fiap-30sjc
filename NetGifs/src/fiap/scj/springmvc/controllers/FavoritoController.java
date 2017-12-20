package fiap.scj.springmvc.controllers;

import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fiap.scj.springmvc.beans.Gif;
import fiap.scj.springmvc.beans.Usuario;
import fiap.scj.springmvc.daos.GenericDAO;
import fiap.scj.springmvc.util.UsuarioUtil;

@Controller
public class FavoritoController {

	@RequestMapping(value = "/addFavorito/{id}", method = RequestMethod.GET)
	public String noLogin(Model model, HttpServletRequest req, @PathVariable("id") int id) {
		Set<Gif> gifsFavoritos  = (Set<Gif>) req.getSession().getAttribute("gifsFavoritos");
		Usuario usrLogado = (Usuario) req.getSession().getAttribute("usrLogado");
		gifsFavoritos.add(new GenericDAO<>(Gif.class).buscar(id));
		req.getSession().setAttribute("gifsFavoritos", gifsFavoritos);
		
		if (UsuarioUtil.isAdmin(usrLogado)) {
			return "redirect:/homeAdm";
		} else {
			return "redirect:/home";
		}
	}
	@RequestMapping(value = "/favoritos", method = RequestMethod.GET)
	public String MostrarFavoritos(Model model, HttpServletRequest req) {
		Set<Gif> gifsFavoritos  = (Set<Gif>) req.getSession().getAttribute("gifsFavoritos");
		model.addAttribute("gifsFavoritos", gifsFavoritos);
		return "favoritosForm";
	}
	@RequestMapping(value = "/favorito/home", method = RequestMethod.GET)
	public String favoritoHome(Model model, HttpServletRequest req) {
		Usuario usrLogado = (Usuario) req.getSession().getAttribute("usrLogado");
		
		if (UsuarioUtil.isAdmin(usrLogado)) {
			return "redirect:/homeAdm";
		} else {
			return "redirect:/home";
		}
	}
	@RequestMapping(value = "/removeFavorito/{id}", method = RequestMethod.GET)
	public String removeFavorito(Model model, HttpServletRequest req, @PathVariable("id") int id) {
		Set<Gif> gifsFavoritos  = (Set<Gif>) req.getSession().getAttribute("gifsFavoritos");
		gifsFavoritos.removeIf(gif -> gif.getId() == id);
		req.getSession().setAttribute("gifsFavoritos", gifsFavoritos);
		
		return "redirect:/favoritos";
	}
}
