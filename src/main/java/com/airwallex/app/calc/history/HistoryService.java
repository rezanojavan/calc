package com.airwallex.app.calc.history;

import org.apiguardian.api.API;

/**
 * History that provide store and retrieve operation. This history specification implement LIFO
 *
 * @author Reza Nojavan
 */
@API(status = API.Status.EXPERIMENTAL)
public interface HistoryService {

    /**
     * this method store a new history record
     */
    void store(String[] item);

    /**
     * This method retrieve last history record.
     *
     * @return latest history record. If there is no item in history then return null
     */
    String[] retrieve();
}
