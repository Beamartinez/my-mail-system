
/**
 * Represente un cliente de correo de electrónico
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MailClient
{
    //Hace referencia al servidor asociado al cliente
    private MailServer server;
    //Almacena la dirección de correo del usuario que usa el cliente
    private String user;

    /**
     * Constructor de la clase MailClient
     */
    public MailClient(MailServer newServer, String newUser)
    {
        this.server = server;
        this.user = user;
    }
    
    /**
     * Obtiene del servidor el siguiente correo del usuario y lo devuelve
     */
    public MailItem getNextMailItem()
    {
        return server.getNextMailItem(user);
    }
    
    /**
     * Obtiene del servidor el siguiente correo del usuario y lo imprime
     * por pantalla. Si no habia correos en el servidor, informa por pantalla
     * de ello.
     */
    public void printNextMailItem()
    {
        MailItem email = server.getNextMailItem(user);
        if(email == null) {
            System.out.println("No hay mensajes nuevos");
        }
        else {
            email.print();
        }
        
    }
    
    
    /**
     * Envia un correo a la dirección indicada con el contenido pasado por parametro
     */
    public void sendMailItem(String address, String message, String subject)
    {
        MailItem emailToSend = new MailItem(user, address, message, subject);
        server.post(emailToSend);
    }

}
