package com.pradeep.emp.demo.application.exception;

import com.mongodb.ServerAddress;
import com.mongodb.WriteConcernResult;
import org.bson.BsonDocument;

public class DuplicateKeyException extends com.mongodb.DuplicateKeyException {
    public DuplicateKeyException(BsonDocument response, ServerAddress address, WriteConcernResult writeConcernResult) {
        super(response, address, writeConcernResult);
    }
}
