package sample;

/**
 * Created by Ash on 20.03.2017.
 */
public class CrawlerException extends Exception{
    private String msg;

    public CrawlerException(String message) {
        this.msg = message;
    }

    @Override
    public String getMessage() {
        return msg;
    }
}