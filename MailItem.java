
/**
 * Esta clase representa un mensaje de email
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MailItem
{
    //Almacena que dirección envia el mensaje
    private String from;
    //Almacena para que dirección es el mensaje
    private String to;
    //Almacena el contenido del mensaje del email
    private String message;
    //Asunto
    private String subject;

    /**
     * Constructor de la clase MailItem
     */
    public MailItem(String newFrom, String newTo, String newMessage, String newSubject)
    {
        this.from = newFrom;
        this.to = newTo;
        this.message = newMessage;
        this.subject = newSubject;
    }
    
    /**
     * Devuelve la dirección de origen del mensaje
     */
    public String getFrom()
    {
        return from;
    }
    
    /**
     * Devuelve la dirección de destino del mensaje
     */
    public String getTo()
    {
        return to;
    }
    
    /**
     * Devuelve el contenido del mensaje
     */
    public String getMessage()
    {
        return message;
    }
    
    /**
     * Devuelve el contenido del asunto
     */
    public String getSubject()
    {
        return subject;
    }
    
    public void print()
    {
        System.out.println("From: " + from);
        System.out.println("To: " + to);
        System.out.println("Message: " + message);
        System.out.println("Subject: " + subject);
    }
}
