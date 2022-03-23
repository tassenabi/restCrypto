package com.ann.restCrypto.util;

import com.ann.restCrypto.persistence.model.ErrorRecord;
import org.bson.types.ObjectId;
import org.slf4j.Logger;

import java.util.function.Consumer;

public final class CommonUtils {

    private CommonUtils(){

    }

    public static ObjectId objectIdFromString(String id){
        return new ObjectId(id);
    }

    public static ObjectId saveErrorRecord(String recordToSave, Consumer<ErrorRecord> errorLogger, Throwable failure){

        var errorRecord = new ErrorRecord(new ObjectId(), recordToSave, failure.getMessage());
        errorLogger.accept(errorRecord);
        return errorRecord.getErrorId();
    }

    public static void logError(Logger log, String fehlerstelle, ObjectId errorRecordId){

    }

    public static double getDoubleVAlueNullSafe(Double number){
        if(number == null){
            return 0D;
        }
        return number;
    }
}
