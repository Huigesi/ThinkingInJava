package Exercise.section19.ex9;

import Exercise.utils.Enums;

import java.util.EnumMap;
import java.util.HashMap;
import java.util.Iterator;
import java.util.*;
import java.util.logging.LogRecord;

class Mail {
    enum GeneralDelivery {
        YES, NO1, NO2, NO3, NO4, NO5
    }

    enum Scannability {UNSCANNABLE, YES1, YES2, YES3, YES4}

    enum Readability {ILLEGIBLE, YES1, YES2, YES3, YES4}

    enum Address {INCORRECT, OK1, OK2, OK3, OK4, OK5, OK6}

    enum ReturnAddress {MISSING, OK1, OK2, OK3, OK4, OK5}

    GeneralDelivery generalDelivery;
    Scannability scannability;
    Readability readability;
    Address address;
    ReturnAddress returnAddress;
    static long counter = 0;
    long id = counter++;

    public String toString() {
        return "Mail " + id;
    }

    public String details() {
        return toString() + ", General Delivery: " + generalDelivery +
                ", Address Scanability: " + scannability +
                ", Address Readability: " + readability +
                ", Address Address: " + address +
                ", Return address: " + returnAddress;
    }

    public static Mail randomMail() {
        Mail m = new Mail();
        m.generalDelivery = Enums.random(GeneralDelivery.class);
        m.scannability = Enums.random(Scannability.class);
        m.readability = Enums.random(Readability.class);
        m.address = Enums.random(Address.class);
        m.returnAddress = Enums.random(ReturnAddress.class);
        return m;
    }

    public static Iterable<Mail> generator(final int count) {
        return new Iterable<Mail>() {
            int n = count;

            @Override
            public Iterator<Mail> iterator() {
                return new Iterator<Mail>() {
                    @Override
                    public boolean hasNext() {
                        return n-- > 0;
                    }

                    @Override
                    public Mail next() {
                        return randomMail();
                    }

                    public void remove() {
                        throw new UnsupportedOperationException();
                    }
                };
            }
        };
    }
}
interface Handler { abstract boolean handle(Mail mail); }
public class PostOffice {
    enum MailHandler {
        GENERAL_DELIVERY ,
        MACHINE_SCAN ,
        VISUAL_INSPECTION ,
        RETURN_TO_SENDER ;
    }

    static void handle(Mail mail,EnumMap<MailHandler,Handler> em) {
        for (Map.Entry<MailHandler,Handler> e: em.entrySet()) {
            if (e.getValue().handle(mail)) {
                return;
            }
            System.out.println(mail+" is a dead letter");
        }
    }

    public static void main(String[] args) {
        EnumMap<MailHandler, Handler> em = new EnumMap<MailHandler, Handler>(MailHandler.class);
        em.put(MailHandler.GENERAL_DELIVERY, new Handler() {
            @Override
            public boolean handle(Mail m) {
                switch (m.generalDelivery) {
                    case YES:
                        System.out.println("Using general delivery for" + m);
                        return true;
                    default:
                        return false;
                }
            }
        });
        em.put(MailHandler.MACHINE_SCAN, new Handler() {
            @Override
            public boolean handle(Mail mail) {
                switch (mail.scannability) {
                    case UNSCANNABLE:
                        return false;
                    default:
                        switch (mail.address) {
                            case INCORRECT:
                                return false;
                            default:
                                System.out.println("Delivering " + mail + " automatically");
                                return true;
                        }
                }
            }
        });
        em.put(MailHandler.VISUAL_INSPECTION, new Handler() {
            @Override
            public boolean handle(Mail mail) {
                switch (mail.readability) {
                    case ILLEGIBLE:
                        return false;
                    default:
                        switch (mail.address) {
                            case INCORRECT:
                                return false;
                            default:
                                System.out.println("Delivering " + mail + " normally");
                                return true;
                        }
                }
            }
        });
        em.put(MailHandler.RETURN_TO_SENDER, new Handler() {
            @Override
            public boolean handle(Mail mail) {
                switch (mail.returnAddress) {
                    case MISSING:
                        return false;
                    default:
                        System.out.println("Returning " + mail + " to sender");
                        return true;
                }
            }
        });
        for (Mail mail : Mail.generator(10)) {
            System.out.println(mail.details());
            handle(mail,em);
            System.out.println("*******");
        }
    }
}
