
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
    private MailItem lastMailItem;

    /**
     * Constructor de la clase MailClient
     */
    public MailClient(MailServer server, String user)
    {
        this.server = server;
        this.user = user;
    }
    
    /**
     * Obtiene del servidor el siguiente correo del usuario y lo devuelve
     */
    public MailItem getNextMailItem()
    {
        MailItem item = server.getNextMailItem(user);
        if(item == null)
        {
            System.out.println("No hay mensajes nuevos");
        }
        lastMailItem = item;
        return item;
    }
    
    /**
     * Obtiene del servidor el siguiente correo del usuario y lo imprime
     * por pantalla. Si no habia correos en el servidor, informa por pantalla
     * de ello.
     */
    public void printNextMailItem()
    {
        MailItem item = server.getNextMailItem(user);
        if(item == null) {
            System.out.println("No hay mensajes nuevos");
        }
        else {
            item.print();
        }
        lastMailItem = item;
    }
    
    
    /**
     * Envia un correo a la dirección indicada con el contenido pasado por parametro
     */
    public void sendMailItem(String address, String message, String subject)
    {
        MailItem itemNew = new MailItem(user, address, message, subject);
        server.post(itemNew);
    }
    
    /*
     * Metodo que imprime por pantalla los mensajes que tiene el usuario 
     * que esta utilizando el cliente
     */
    public void howManyMailItems()
    {
        System.out.println("Tienes " + server.howManyMailItems(user) + " mensajes nuevos");
    }
    
    /*
     * Metodo que responde automaticamente cuando el user esta de vacaciones
     */
    public void getNextMailItemAndAutorespond()
    {
        //Este es el ultimo mensaje
        MailItem item = server.getNextMailItem(user);
        if (item != null)
        {
            String newTo = item.getFrom();
            String newSubject = "RE: " + item.getSubject();
            String newMessage = "ESTAMOS DE VACACIONES" + "\n" + item.getMessage();
            MailItem newMail = new MailItem(user, newTo, newMessage, newSubject);
            server.post(newMail);
        }
    }
    
    
    public void printLastMailItem()
    {
        System.out.println("El ultimo mensaje es este: " + lastMailItem);
    }

}
