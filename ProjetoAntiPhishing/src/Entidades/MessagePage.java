package Entidades;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class MessagePage implements ActionListener{
	
	JFrame frame = new JFrame();
	JButton tokenVerification = new JButton("Verificar Token");
	JButton sendButton = new JButton("Enviar");
	JTextField contactField = new JTextField();
	JTextField communicationTypeField = new JTextField();
	JTextField messageField = new JTextField();
	JLabel IDLabel = new JLabel();
	JLabel contactLabel = new JLabel("Contato:");
	JLabel communicationTypeLabel = new JLabel("Comunicação:");
	JLabel messageLabel = new JLabel("Mensagem:");
	JLabel postSendMessageLabel = new JLabel();
	String employee;
	ArrayList<Pessoa> pessoas;
	MensagensEnviadas mensagensEnviadas = new MensagensEnviadas();
	
	public MessagePage(ArrayList<Pessoa> pessoas, String employee){
		
		this.pessoas = pessoas;
		this.employee = employee;

		IDLabel.setBounds(50,50,200,25);
		IDLabel.setText(employee);

		contactLabel.setBounds(50,100,75,25);
		communicationTypeLabel.setBounds(50,150,100,25);
		messageLabel.setBounds(50,200,75,25);
		
		contactField.setBounds(150,100,200,25);
		communicationTypeField.setBounds(150,150,200,25);
		messageField.setBounds(150,200,500,300);
		
		sendButton.setBounds(312,550,100,25);
		sendButton.setFocusable(false);
		sendButton.addActionListener(this);

		tokenVerification.setBounds(312,750,100,25);
		tokenVerification.setFocusable(false);
		tokenVerification.addActionListener(this);
		tokenVerification.setVisible(false);
		
		frame.add(IDLabel);
		frame.add(contactLabel);
		frame.add(communicationTypeLabel);
		frame.add(messageLabel);
		frame.add(postSendMessageLabel);
		frame.add(contactField);
		frame.add(communicationTypeField);
		frame.add(messageField);
		frame.add(sendButton);
		frame.add(tokenVerification);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(750,1500);
		frame.setLayout(null);
		frame.setVisible(true);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		Pessoa currentPessoa = null;
		Mensagem currentMensagem = null;

		if(e.getSource()==tokenVerification){
			frame.dispose();
			TokenVerificationPage TokenVerificationPage = new TokenVerificationPage(mensagensEnviadas.getMensagensEnviadas());
		}

		if(e.getSource()==sendButton) {
			
			
			String contact = contactField.getText();
			String message = messageField.getText();
			String communicationType = communicationTypeField.getText();
			
			for (Pessoa u : pessoas){
				if(u.nome.equals(contact)){
					currentPessoa = u;
				}
			}
			
			if (currentPessoa != null){
				
				if (communicationType.trim().isEmpty()){
					currentMensagem = new Mensagem(employee, message, currentPessoa, currentPessoa.getEmail(), mensagensEnviadas.getMensagensEnviadas());
					sendButton.setVisible(false);
					contactField.setEditable(false);
					communicationTypeField.setEditable(false);
					messageField.setEditable(false);
					messageField.setText(currentMensagem.corpo);
					postSendMessageLabel.setBounds(50,500,1000,100);
					postSendMessageLabel.setFont(new Font(null,Font.ITALIC,25));
					postSendMessageLabel.setForeground(Color.green);
					postSendMessageLabel.setText("<html>" + "Mensagem enviada com sucesso às " + currentMensagem.getDateString() + "<br/>Token: " + currentMensagem.token + "</html>");
					mensagensEnviadas.mensagensEnviadas.put(currentMensagem.token, currentMensagem);
					tokenVerification.setVisible(true);

				}

				else if ((communicationType.equals("telefone")) && (currentPessoa.getTelefone() != null)){
					currentMensagem = new Mensagem(employee, message, currentPessoa, currentPessoa.getTelefoneString(), mensagensEnviadas.getMensagensEnviadas());
					sendButton.setVisible(false);
					contactField.setEditable(false);
					communicationTypeField.setEditable(false);
					messageField.setEditable(false);
					messageField.setText(currentMensagem.corpo);
					postSendMessageLabel.setBounds(50,500,1000,100);
					postSendMessageLabel.setFont(new Font(null,Font.ITALIC,25));
					postSendMessageLabel.setForeground(Color.green);
					postSendMessageLabel.setText("<html>" + "Mensagem enviada com sucesso às " + currentMensagem.getDateString() + "<br/>Token: " + currentMensagem.token + "</html>");
					mensagensEnviadas.mensagensEnviadas.put(currentMensagem.token, currentMensagem);
					tokenVerification.setVisible(true);

				}

				else{
					postSendMessageLabel.setBounds(280,500,1000,25);
					postSendMessageLabel.setFont(new Font(null,Font.ITALIC,15));
					postSendMessageLabel.setForeground(Color.red);
					postSendMessageLabel.setText("Forma de comunicação não existente.");
				}

			}

			else{
				postSendMessageLabel.setBounds(280,500,1000,25);
				postSendMessageLabel.setFont(new Font(null,Font.ITALIC,15));
				postSendMessageLabel.setForeground(Color.red);
				postSendMessageLabel.setText("Contato não existente");
			}
		}
	}

}