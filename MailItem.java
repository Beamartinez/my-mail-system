
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
    public MailItem(String From, String To, String Message, String Subject)
    {
        this.from = From;
        this.to = To;
        this.message = Message;
        this.subject = Subject;
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
