package db;

public class DbIntegfrityException  extends RuntimeException {


    private static final long serialVersionUID = 1L;

    public DbIntegfrityException (String msg){
        super (msg);
    }
}
