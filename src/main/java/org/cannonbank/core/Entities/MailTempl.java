package org.cannonbank.core.Entities;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class MailTempl {

    private static final String AVAILABLE_CARD = "Your requested card is available, check the application";
    private static final String AVAILABLE_CHECKBOOK = "Your requested checkbook is available, check the application";
    private static final String AVAILABLE_DOCUMENT = "Your requested document is available, check the application";

    private String message;
    private String subject;


}
