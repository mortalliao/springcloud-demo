package win.mortalliao.starter.common.exception;

/**
 * @author liaoyujian
 * Description: 事务中止异常
 * Date: 2017-09-16
 * Time: 17:01
 */
public class TransactionAbortException extends RuntimeException {

    public TransactionAbortException(String message) {
        super(message);
    }
}
