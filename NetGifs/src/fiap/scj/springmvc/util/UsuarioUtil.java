package fiap.scj.springmvc.util;

import fiap.scj.springmvc.beans.Usuario;

public class UsuarioUtil {

	public static boolean isAdmin(Usuario usuario) {
		return usuario.getNome().equals("Administrador");
	}
}
