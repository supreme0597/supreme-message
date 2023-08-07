package club.supreme.message.service;

import club.supreme.message.model.MsgSendLog;

public class LogService {
    public void logStartProcessing(MsgSendLog msgSendLog) {
        // Log the start of message processing
    }
    public void logEndProcessing(MsgSendLog msgSendLog) {
        // Log the end of message processing
    }
    public void logError(MsgSendLog msgSendLog, Exception error) {
        // Log an error during message processing
    }
}