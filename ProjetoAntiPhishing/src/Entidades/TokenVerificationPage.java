package Entidades;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.*;

public class TokenVerificationPage implements ActionListener{
	
	JFrame frame = new JFrame();
	JButton verificarButton = new JButton("Verificar");
	JTextField tokenField = new JTextField();
	JLabel tokenLabel = new JLabel("Token:");
	JLabel messageLabel = new JLabel();
	HashMap<String,Mensagem> mensagensEnviadas = new HashMap<String, Mensagem>();
	
	public TokenVerificationPage(HashMap<String,Mensagem> MensagensEnviadas){
		
		mensagensEnviadas = MensagensEnviadas;
		
		tokenLabel.setBounds(50,100,75,25);
		
		messageLabel.setBounds(125,250,2000, 50);
		messageLabel.setFont(new Font(null,Font.ITALIC,25));
		messageLabel.setVisible(false);
		
		tokenField.setBounds(125,100,200,25);
		
		verificarButton.setBounds(125,200,100,25);
		verificarButton.setFocusable(false);
		verificarButton.addActionListener(this);
		

		
		frame.add(tokenLabel);
		frame.add(messageLabel);
		frame.add(tokenField);
		frame.add(verificarButton);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(420,420);
		frame.setLayout(null);
		frame.setVisible(true);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		
		if(e.getSource()==verificarButton) {
			
			String token = tokenField.getText();
			
			if(mensagensEnviadas.containsKey(token)) {
				Mensagem mensagem = mensagensEnviadas.get(token);

				verificarButton.setVisible(false);
				tokenLabel.setVisible(false);
				tokenField.setVisible(false);
				messageLabel.setVisible(true);
				messageLabel.setForeground(Color.green);
				messageLabel.setText(mensagem.toString());
			}
			else {
				messageLabel.setVisible(true);
				messageLabel.setForeground(Color.red);
				messageLabel.setText("Token não encontrado.");
			}
		}
	}
}