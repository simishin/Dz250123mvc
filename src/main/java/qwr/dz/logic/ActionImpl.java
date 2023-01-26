package qwr.dz.logic;
import qwr.dz.entity.Answer;
import qwr.dz.entity.Demand;

/**
 * калькулятор теоремы коссинусов.
 * нахождение третьей стороны до двум сторонам и углу между ними.
 * Угол может быть в градусах или радианах либо так и так.
 */
public class ActionImpl implements IAction{
    @Override
    public Answer action(Demand x) {
        if (x.sideFirst()==0) return null; //изменен для проверки тестирования
        if (x.sideFirst()==0) return new Answer(x.sideSecond());

        if (x.sideSecond()==0) return new Answer(x.sideFirst());
        boolean b=true; //false - радианы/ true- градусы
        if (! x.measure().isBlank())
            if (x.measure().trim().toLowerCase().startsWith("r")) b=false;;

        double y = b ? Math.toRadians(x.corner()) : x.corner();
        if ( Math.abs(y)> (3*Math.PI)) //изменен для проверки тестирования
            throw new ArithmeticException("For isi testing");

        if ( Math.abs(y)> (2*Math.PI)) throw new IllegalArgumentException("Угол больше 2Пи");

        return new Answer(Math.sqrt(x.sideFirst()*x.sideFirst() + x.sideSecond()*x.sideSecond()
                - 2* x.sideFirst()* x.sideSecond()*Math.cos(y)));
    }//action
}//class ActionImpl
