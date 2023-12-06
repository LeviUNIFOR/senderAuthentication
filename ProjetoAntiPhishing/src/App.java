import java.util.ArrayList;

import Entidades.Contato;
import Entidades.IDandPasswords;
import Entidades.LoginPage;
import Entidades.Mensagem;
import Entidades.Pessoa;

public class App {

	public static void main(String[] args) {
		
		IDandPasswords idandPasswords = new IDandPasswords();
		LoginPage loginPage = new LoginPage(idandPasswords.getLoginInfo());

	}
}