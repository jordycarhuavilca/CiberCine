package pe.org.group02.ventaboletoscine.helper;

import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import pe.org.group02.ventaboletoscine.interfaces.IEmail;


@Service
public class emailHelper implements IEmail {

    @Autowired
    private JavaMailSender javaMailSender;
    @Autowired
    private TemplateEngine templateEngine;

    @Override
    public void sendEmail(pe.org.group02.ventaboletoscine.entity.Email email) {
        try {
            MimeMessage message = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");

            helper.setTo(email.getUsuario().getEmail());
            helper.setSubject(email.getAsunto());

            // Procesar la plantilla Thymeleaf
            Context context = new Context();
            StringBuilder gretting = new StringBuilder();
            gretting.append("Hola, ");
            gretting.append(email.getUsuario().getNombre());
            context.setVariable("name", gretting);
            context.setVariable("secutityCode", email.getId());
            String contenidoHtml = templateEngine.process("email", context);

            helper.setText(contenidoHtml, true);
            javaMailSender.send(message);

        } catch (Exception e) {
            System.out.println("hola " + e);
            throw new RuntimeException("Error al enviar el correo: " + e.getMessage(), e);
        }
    }
}
