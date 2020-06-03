package com.example.project101.Service;

import com.example.project101.Repository.EtudiantRepository;
import com.example.project101.model.Etudiant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("emailService")
public class EmailService
{
    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private SimpleMailMessage preConfiguredMessage;

    /**
     * This method will send compose and send the message
     * */
    public void sendMail(String to, String subject, Etudiant etudiant)
    {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject(subject);
        message.setText("Bonjour, Ceci est un message automatique \n" +
                "Félicitation, Vous avez été ajouté à la plateforme enseignants/étudiants de l'ihec carthage .\n" +
                " Pour vous connecter à la plateforme , entrez les informations suivantes :\n"+
                "Email: "+ etudiant.getEmail()+"\n"+
                "mot de passe : "+ etudiant.getPassword());
        mailSender.send(message);
    }

    /**
     * This method will send a pre-configured message
     * */
    public void sendPreConfiguredMail(String message)
    {
        SimpleMailMessage mailMessage = new SimpleMailMessage(preConfiguredMessage);
        mailMessage.setText(message);
        mailSender.send(mailMessage);
    }
}