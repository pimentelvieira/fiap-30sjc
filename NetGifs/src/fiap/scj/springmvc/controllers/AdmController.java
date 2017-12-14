package fiap.scj.springmvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fiap.scj.springmvc.beans.Categoria;
import fiap.scj.springmvc.beans.Gif;
import fiap.scj.springmvc.beans.Usuario;

@Controller
public class AdmController {

	@RequestMapping(value = "/adm", method = RequestMethod.GET)
	public String exibirForm(Model m, Gif gif) {
		return "formAdm";		
	}
	
	@RequestMapping(value = "/cadastrarGif", method = RequestMethod.POST)
	public String Cadastrar(Model m, Gif gif, Usuario usuario) {
		usuario.getGifs().add(gif);
		m.addAttribute("mensagem", "Gif "+ gif.getNomeGif() +" cadastrado com sucesso");
		m.addAttribute("gifs", usuario);
		return "formAdm";		
	}
	
	@RequestMapping(value = "/cadastroUsuario", method = RequestMethod.POST)
	public String cadastroUsuario(Model m, Gif gif, Usuario usuario) {
		//new usuario....
		m.addAttribute("mensagem", "Usuario "+ gif.getNomeGif() +" cadastrado com sucesso");
		m.addAttribute("gifs", usuario);
		return "formAdm";		
	}
	
	@RequestMapping(value = "/cadastrarCategoria", method = RequestMethod.POST)
	public String cadastrarCategoria(Model m, Gif gif, Categoria categoria, Usuario usuario) {
		//new categoria....
		m.addAttribute("mensagem", "categoria "+ gif.getNomeGif() +" cadastrado com sucesso");
		m.addAttribute("gifs", usuario);
		return "formAdm";		
	}
}
