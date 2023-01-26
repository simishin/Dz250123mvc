package qwr.dz.service;

import java.util.Date;

// классы сообщений
public class ClassMessages {
    // пустой интерфейс
    public interface IMessage { }

//    // класс простого сообщения
//    public  record Message(String message) implements IMessage{
//        public Date getTime(){return new Date();}
//    }
//    // входное сообщение
//    public  record InputMessage( double a, double b, double c) implements IMessage{
//        @Override
//        public String toString() {
//            return a + "x^2 + " + b + "x + " + c + " = 0";
//        }
//    }
//    // сообщение результата
//    public  record OutputMessage(int rootsCount,Double x1, Double x2) implements IMessage {
//    // переопределияю логику конструктора
//         public OutputMessage {
//            if (rootsCount == 0) {
//                x1 = null;
//                x2 = null;
//            } else if (rootsCount == 1) {
//                x2 = x1;
//            }
//        }//OutputMessage
//        @Override
//        public String toString() {
//            return rootsCount + ": " + x1 + ", " + x2;
//        }
//    }//record OutputMessage
//
//    // сообщение ошибки
//    public  record ErrorMessage (String message) implements IMessage{
//        public Date getTime(){return new Date();}
//    }//ErrorMessage
//
//    public  record MessageWithBool(Boolean flag) {
//        @Override
//        public String toString() {
//            return "flag " + flag;
//        }
//    }
}//class ClassMessages
