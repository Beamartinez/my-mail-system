
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

    /**
     * Constructor de la clase MailItem
     */
    public MailItem(String From, String To, String Message)
    {
        this.from = From;
        this.to = To;
        this.message = Message;
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
    
    public void print()
    {
        System.out.println("From: " + from);
        System.out.println("To: " + to);
        System.out.println("Message: " + message);
    }
}
