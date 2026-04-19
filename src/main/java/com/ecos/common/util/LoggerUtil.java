package com.ecos.common.util;

import jakarta.annotation.PostConstruct;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LoggerUtil {

    private static final StackWalker stackWalker = StackWalker.getInstance(StackWalker.Option.RETAIN_CLASS_REFERENCE);
    private static final String MESSAGE_TEMPLATE = "[%s] %s";
    private static String methodName;

    private LoggerUtil() {
        // Private constructor to prevent instantiation
    }

    // TODO: Add to all methods in the project
    @PostConstruct
    private static void getDeclaringClassName() {

        StackWalker.StackFrame caller = stackWalker.walk(frames -> frames.skip(1).findFirst()).orElse(null);
        assert caller != null;
        methodName = caller.getDeclaringClass().getName() + "#" + caller.getMethodName();
    }

    public static void debugLog(String message) {

        String messageWithMethod = String.format(MESSAGE_TEMPLATE, methodName, message);
        log.debug(messageWithMethod);
    }

    public static void warnLog(String message, Throwable throwable) {

        String messageWithMethod = String.format(MESSAGE_TEMPLATE, methodName, message);
        log.warn(messageWithMethod, throwable);
    }

    public static void errorLog(String message, Exception e) {

        String messageWithMethod = String.format(MESSAGE_TEMPLATE, methodName, message);
        log.error(messageWithMethod, e);
    }

}
