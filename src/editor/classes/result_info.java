package editor.classes;

/**
 * Created by godex_000 on 04.06.2014.
 *
 * @author godex_000
 *         Клас для того что бі возвращать результат роботи
 */
public class result_info {
    private Boolean status;
    private String comment;

    result_info() {
        status = false;
        comment = "Unknown error";
    }

    public result_info(Boolean status, String comment) {
        this.status = status;
        this.comment = comment;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
