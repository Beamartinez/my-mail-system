
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
    private MailItem lastMailSpam;
    private boolean siSpam;
    private int countOfEnviar;
    private int countOfRecibir;
    private int countOfSpam;
    private int nCaracteres;
    private String longEmail;
    

    /**
     * Constructor de la clase MailClient
     */
    public MailClient(MailServer server, String user)
    {
        this.server = server;
        this.user = user;
        //Vemos si el mensaje guardado es spam o no
        siSpam();
        countOfEnviar = 0;
        countOfRecibir = 0;
        countOfSpam = 0;
        nCaracteres = 0;
        longEmail = "";
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
        countOfEnviar = countOfEnviar + 1;
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
         lastMailItem.print();  
    }
    
    /*
     * Imprime por pantalla el email
     */
    public void print()
    {
        if(lastMailItem != null & (siSpam == true))
        {
            printSpam();
        }
        else if(lastMailItem != null & (siSpam == false))
        {
            lastMailItem.print();
        }
        else
        {
            System.out.println("No hay mensajes sin abrir");
        }
    }
    
    /*
     * Nos dice si un email es spam o no y lo marca como sea
     */
    public void siSpam()
    {
        siSpam = false;
        if(lastMailItem != null)
        {
            String message = lastMailItem.getMessage();
            if(message.indexOf("proyecto") != 1)
            {
                siSpam = false;
            }
            else if((message.indexOf("oferta") != 1) | (message.indexOf("viagra") != 1))
            {
                siSpam = true;
            }
        }
    }
    
    /*
     * Imprime por pantalla el email spam
     */
    public void printSpam()
    {
        System.out.println("Subject: spam" + "\n" + "Message: spam");
    }

    public void datosEmail()
    {
        float datosSpam;
        if(countOfRecibir != 0)
        {
            datosSpam = ((float)countOfSpam/countOfRecibir) * (100);
        }
        else
        {
            datosSpam = 0;
        }
        System.out.println("Mensajes enviados: " + countOfEnviar + "\n" + 
                            "Mensajes recibidos: " + countOfRecibir + "\n" +
                            "Porcentaje de spam: " + datosSpam + "%" + "\n" +
                            "Remitente con email más largo: " + longEmail);
    }
    
    public void printLastMailSpam()
    {
        if(lastMailSpam != null)
        {
            lastMailSpam.print();
        }
        else
        {
            System.out.println("No hay mensajes de spam");
        }
    }
}
