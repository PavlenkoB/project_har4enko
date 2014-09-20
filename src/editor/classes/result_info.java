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

    public result_info() {
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

    public void setComment(Exception e) {
        StackTraceElement[] stack = e.getStackTrace();
        for (int s = 0; s < e.getStackTrace().length; s++) {
            if (!stack[s].toString().equals("Unknown Source") || !stack[s].toString().equals("com.sun"))
                this.comment += stack[s].toString() + "\n";
        }
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
