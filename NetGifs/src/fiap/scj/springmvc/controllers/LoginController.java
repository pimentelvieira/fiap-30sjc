package fiap.scj.springmvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import fiap.scj.springmvc.beans.Usuario;

@Controller
public class LoginController {

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String exibirAdmFormulario(Model model, Usuario usuario) {
		model.addAttribute("gifs", usuario);
		return "home";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String exibirFormulario() {
		return "formLogin";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String cadastar(Usuario usuario, Model model, RedirectAttributes attr) {	
		if (usuario.getLogin().equals("fiap") && usuario.getSenha().equals("fiap")) {
			System.out.println("login efetuado com sucesso");
			model.addAttribute("gifs", usuario);
			return "home";
		} else {
			if (usuario.getLogin().equals("fiap") && usuario.getSenha().equals("fiapadm")) {
				model.addAttribute("gifs", usuario);
				System.out.println("login ADM efetuado com sucesso");
				return "formAdm";
			} else {
				model.addAttribute("mensagem", "Usuario ou senha invalidos");
				System.out.println("Usuario ou senha invalidos");
				return "formLogin";
			}

		}

	}

}
