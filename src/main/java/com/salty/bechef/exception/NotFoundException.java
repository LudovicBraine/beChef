package com.salty.bechef.exception;


public class NotFoundException extends ApplicationException {

    private static final long serialVersionUID = 5477619054099558741L;

    public enum NotFoundExceptionType implements ExceptionType {

        GENERIC("error.server.notfound.title", "error.server.notfound.msg", "Resource not found 400"),
        FILE_NOT_FOUND("error.server.notfound.file.title", "error.server.notfound.file.msg", "File not found : {0}"),
        LDAP_USER_NOT_FOUND("error.server.notfound.ldap.user.title", "error.server.notfound.ldap.user.msg", null),
        USER_NOT_FOUND("error.server.notfound.user.title", "error.server.notfound.user.msg", "User not found : {0}"),
        NOTIFICATION_PREFERENCE_NOT_FOUND("error.server.notfound.preference.title", "error.server.notfound.preference.msg", "Notification Preference not found : {0}"),
        BATCH_NOT_FOUND("error.server.notfound.batch.title", "error.server.notfound.batch.msg", "Batch not found : {0}"),
        BOOK_NOT_FOUND("error.server.notfound.book.title", "error.server.notfound.book.msg", "Book not found: {0}");

        private String messageKey;
        private String titleKey;
        private String messageCause;

        NotFoundExceptionType(String titleKey, String messageKey, String messageCause) {
            this.messageKey = messageKey;
            this.titleKey = titleKey;
            this.messageCause = messageCause;
        }

        @Override
        public String getTitleKey() {
            return titleKey;
        }

        @Override
        public String getMessageKey() {
            return messageKey;
        }

        @Override
        public String getMessageCause() {
            return messageCause;
        }
    }

    public NotFoundException(NotFoundExceptionType type) {
        super(type);
    }

    public NotFoundException(NotFoundExceptionType type, Throwable cause) {
        super(type, cause);
    }

    public NotFoundException(NotFoundExceptionType type, String message, Throwable cause) {
        super(type, message, cause);
    }

    public NotFoundException(NotFoundExceptionType type, String message, Throwable cause, Object... keyParams) {
        super(type, message, cause, keyParams);
    }

    public NotFoundException(NotFoundExceptionType type, Object[] valueParams, Object... keyParams) {
        super(type, valueParams, keyParams);
    }

    public NotFoundException(NotFoundExceptionType type, Object... valueParams) {
        super(type, valueParams);
    }
}

